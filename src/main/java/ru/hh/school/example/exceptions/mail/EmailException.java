package ru.hh.school.example.exceptions.mail;

public class EmailException extends Exception {

  private final String email;

  public EmailException(String email) {
    super(email);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
}
