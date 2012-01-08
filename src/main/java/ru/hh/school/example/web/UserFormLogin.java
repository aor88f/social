package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class UserFormLogin {

  private final Logger logger = new Logger(this);
  private String email;
  private String password;

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
}
