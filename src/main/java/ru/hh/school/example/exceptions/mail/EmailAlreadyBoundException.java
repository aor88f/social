package ru.hh.school.example.exceptions.mail;

public class EmailAlreadyBoundException extends EmailException {
  public EmailAlreadyBoundException(String email) {
    super(email);
  }
}
