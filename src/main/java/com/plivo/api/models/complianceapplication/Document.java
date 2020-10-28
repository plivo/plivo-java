package com.plivo.api.models.complianceapplication;

import com.plivo.api.models.base.BaseResource;

public class Document extends BaseResource {
  private String documentId;
  private String documentName;
  private String documentTypeId;
  private String documentTypeName;
  private String name;
  private String scope;

  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

  public String getDocumentName() {
    return documentName;
  }

  public void setDocumentName(String documentName) {
    this.documentName = documentName;
  }

  public String getDocumentTypeId() {
    return documentTypeId;
  }

  public void setDocumentTypeId(String documentTypeId) {
    this.documentTypeId = documentTypeId;
  }

  public String getDocumentTypeName() {
    return documentTypeName;
  }

  public void setDocumentTypeName(String documentTypeName) {
    this.documentTypeName = documentTypeName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  @Override
  public String getId() {
    return documentId;
  }
}