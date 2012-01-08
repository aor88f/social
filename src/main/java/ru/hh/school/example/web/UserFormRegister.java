package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class UserFormRegister {

  private final Logger logger = new Logger(this);
  private String email;
  private String password;
  private String fullName;

  public String getEmail() {
    logger.out("getEmail");
    return email;
  }

  public void setEmail(String email) {
    logger.out("setEmail");
    this.email = email;
  }

  public String getPassword() {
    logger.out("getPassword");
    return password;
  }

  public void setPassword(String password) {
    logger.out("setPassword");
    this.password = password;
  }

  public String getFullName() {
    logger.out("getFullName");
    return fullName;
  }

  public void setFullName(String fullName) {
    logger.out("setFullName");
    this.fullName = fullName;
  }
}
