package com.plivo.api.models.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.IterableError;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.util.Utils;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Lists instances of a resource, possibly filtered.
 *
 * @param <T> The type of the resource.
 */
@JsonSerialize(typing = Typing.STATIC)
public abstract class Lister<T extends BaseResource> extends BaseRequest<T> implements Iterable<T> {

  protected Integer limit = null;
  protected Integer offset = null;

  @Override
  public Lister<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  /**
   * @return Used to display the number of results per page. The maximum number of results that can
   * be fetched is 20.
   */
  public Integer limit() {
    return this.limit;
  }

  /**
   * @return Denotes the number of value items by which the results should be offset.
   */
  public Integer offset() {
    return this.offset;
  }

  /**
   * @param limit Used to display the number of results per page. The maximum number of results that
   * can be fetched is 20.
   */
  public Lister<T> limit(final Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * @param offset Denotes the number of value items by which the results should be offset.
   */
  public Lister<T> offset(final Integer offset) {
    this.offset = offset;
    return this;
  }

  protected abstract Call<ListResponse<T>> obtainCall();

  /**
   * Actually list instances of the resource.
   */
  public ListResponse<T> list() throws IOException, PlivoRestException {
    validate();
    Response<ListResponse<T>> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }

  protected Map<String, Object> toMap() {
    client();
    return Utils.objectToMap(PlivoClient.getObjectMapper(), this);
  }

  @Override
  public Iterator<T> iterator() throws IterableError {
    if (limit == null) {
      limit = 20;
    }

    if (offset == null) {
      offset = 0;
    }

    return new Iterator<T>() {
      Deque<T> items = new ConcurrentLinkedDeque<>();

      @Override
      public boolean hasNext() {
        if (!items.isEmpty()) {
          return true;
        }

        try {
          ListResponse<T> itemList = Lister.this.list();
          if (itemList.getObjects().isEmpty()) {
            return false;
          }
          this.items.addAll(itemList.getObjects());
          offset += limit;
        } catch (IOException | PlivoRestException exception) {
          throw new IterableError();
        }
        return true;
      }

      @Override
      public T next() {
        if (items.isEmpty()) {
          try {
            ListResponse<T> itemList = Lister.this.list();
            this.items.addAll(itemList.getObjects());
            offset += limit;
          } catch (IOException | PlivoRestException exception) {
            throw new IterableError();
          }
        }

        return items.removeFirst();
      }
    };
  }
}
