package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class UserFormLogin {

  private final Logger logger = new Logger(this);
  private String email;
  private String password;

  public String getEmail() {
    logger.log("getEmail");
    return email;
  }

  public void setEmail(String email) {
    logger.log("setEmail");
    this.email = email;
  }

  public String getPassword() {
    logger.log("getPassword");
    return password;
  }

  public void setPassword(String password) {
    logger.log("setPassword");
    this.password = password;
  }
}
