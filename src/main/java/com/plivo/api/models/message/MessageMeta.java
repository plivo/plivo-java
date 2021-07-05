package com.plivo.api.models.message;

import java.lang.NoSuchMethodException;
import com.plivo.api.models.base.Meta;

public class MessageMeta extends Meta {

    public MessageMeta(Meta m) {
        limit = m.getLimit();
        next = m.getNext();
        offset = m.getOffset();
        previous = m.getPrevious();
    }

    @Override
    public Long getTotalCount() throws NoSuchMethodException {
        throw new NoSuchMethodException("total_count field is deprecated");
    }
  }