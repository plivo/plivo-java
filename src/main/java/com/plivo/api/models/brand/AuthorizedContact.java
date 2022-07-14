package com.plivo.api.models.brand;

public class AuthorizedContact {
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  private String title;
  private String seniority;

  public AuthorizedContact(String firstName, String lastName, String phone, String email, String title, String seniority) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.title = title;
    this.seniority =seniority;
  }

  public AuthorizedContact() {
  }

  public String getFirstrname() {
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getTitle(){
    return title;
  }

  public String getSeniority() {
    return seniority;
  }
}