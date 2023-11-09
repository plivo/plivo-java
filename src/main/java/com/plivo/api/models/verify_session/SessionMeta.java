package com.plivo.api.models.verify_session;

import com.plivo.api.models.base.Meta;

public class SessionMeta extends Meta{
  public SessionMeta(Meta m) {
    limit = m.getLimit();
    next = m.getNext();
    offset = m.getOffset();
    previous = m.getPrevious();
  }

//  @Override
//  public Long getTotalCount() throws NoSuchMethodException {
//    throw new NoSuchMethodException("total_count field is deprecated");
//  }
}
