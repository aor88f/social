package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;

public class User extends Entity {

  private final Logger logger = new Logger(this);
  private String email;
  private String password;
  private String fullName;

  public User(String email, String password, String fullName) {
    logger.log("User");
    this.email = email;
    this.password = password;
    this.fullName = fullName;
  }

  public String getEmail() {
    logger.log("getEmail");
    return email;
  }

  public String getPassword() {
    logger.log("getPassword");
    return password;
  }

  public String getFullName() {
    logger.log("getFullName");
    return fullName;
  }
}
