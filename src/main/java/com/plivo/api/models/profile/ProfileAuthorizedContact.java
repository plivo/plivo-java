package com.plivo.api.models.profile;

public class ProfileAuthorizedContact {
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  private String title;
  private String seniority;

  public ProfileAuthorizedContact(String firstName, String lastName, String phone, String email, String title, String seniority) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.title = title;
    this.seniority =seniority;
  }

  public ProfileAuthorizedContact() {
  }

  public String getFirstName() {
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