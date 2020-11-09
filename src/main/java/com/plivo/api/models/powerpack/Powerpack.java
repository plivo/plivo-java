package com.plivo.api.models.powerpack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;

public class Powerpack extends BaseResource {
  private String createdOn;
  private String name;
  private String application_type;
  private String application_id;
  private Boolean sticky_sender;
  private Boolean local_connect;
  private String number_pool;
  private String uuid;
  public NumberPriority[] number_priority;
  @JsonIgnore
  public NumberPool numberpool;

  public static PowerpackCreator creator(String name) {
    return new PowerpackCreator(name);
  }

  public static PowerpackGetter getter(String id) {
    return new PowerpackGetter(id);
  }

  public static PowerpackLister lister() {
    return new PowerpackLister();
  }

  public PowerpackDeleter deleter() {
    return new PowerpackDeleter(getId());
  }

  public PowerpackUpdater updater() {
    return new PowerpackUpdater(getId());
  }

  public PowerpackNumberLister list_numbers() {
    return new PowerpackNumberLister(getNumberPoolId());
  }

  public PowerpackFindNumber find_number() {
    return new PowerpackFindNumber(getNumberPoolId());
  }

  public PowerpackAddNumber add_number() {
    return new PowerpackAddNumber(getNumberPoolId());
  }

  public PowerpackAddTollfree add_tollfree() {
    return new PowerpackAddTollfree(getNumberPoolId());
  }

  public FindShortcode find_shortcode() {
    return new FindShortcode(getNumberPoolId());
  }

  public FindTollfree find_tollfree() {
    return new FindTollfree(getNumberPoolId());
  }

  public ShortcodeLister list_shortcode() {
    return new ShortcodeLister(getNumberPoolId());
  }

  public TollfreeLister list_tollfree() {
    return new TollfreeLister(getNumberPoolId());
  }

  public RemoveNumber remove_number() {
    return new RemoveNumber(getNumberPoolId());
  }

  public RemoveShortcode remove_shortcode() {
    return new RemoveShortcode(getNumberPoolId());
  }

  public RemoveTollfree remove_tollfree() {
    return new RemoveTollfree(getNumberPoolId());
  }

  public PowerpackNumberLister count_numbers() {
    return new PowerpackNumberLister(getNumberPoolId());
  }

  public BuyAddNumbers buy_add_number() {
    return new BuyAddNumbers(getNumberPoolId());
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public String getName() {
    return name;
  }

  public String getApplicationType() {
    return application_type;
  }

  public String getApplicationID() {
    return application_id;
  }

  public Boolean getStickySender() {
    return sticky_sender;
  }

  public Boolean getLocalConnect() {
    return local_connect;
  }

  public String getNumber_pool() {
    return number_pool;
  }

  public NumberPriority[] getNumber_priority() {
    return number_priority;
  }

  public String getUuid() {
    return uuid;
  }
  

  @Override
  public String getId() {
    return getUuid();
  }

  public String getNumberPoolId() {
	  String[] numberpool_uuid = getNumber_pool().split("/");
	  return numberpool_uuid[5];
  }

}
