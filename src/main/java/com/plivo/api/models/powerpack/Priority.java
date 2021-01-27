package com.plivo.api.models.powerpack;

public class Priority {
  private String priority1;
  private String priority2;
  private String priority3;

  public Priority(String priority1, String priority2, String priority3) {
    this.priority1 = priority1;
    this.priority2 = priority2;
    this.priority3 = priority3;
  }

  public Priority() {
  }

  public String getPriority1() {
    return priority1;
  }

  public String getPriority2() {
    return priority2;
  }

  public String getPriority3() {
    return priority3;
  }
}
