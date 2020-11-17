package com.plivo.api.models.powerpack;

public class NumberPriority {

  private String country_iso;
  private Priority priority;
  private String service_type;

  public NumberPriority(String country_iso, Priority priority, String service_type) {
    this.country_iso = country_iso;
    this.priority = priority;
    this.service_type = service_type;
  }

  public NumberPriority() {
  }

  public String getCountry_iso() {
    return country_iso;
  }

  public Priority getPriority() {
    return priority;
  }
  
  public String getService_type() {
    return service_type;
  }
}
