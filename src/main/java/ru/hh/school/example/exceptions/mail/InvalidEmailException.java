package ru.hh.school.example.exceptions.mail;

public class InvalidEmailException extends EmailException {
  public InvalidEmailException(String email) {
    super(email);
  }
}
