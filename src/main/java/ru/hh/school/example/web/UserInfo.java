package ru.hh.school.example.web;

import ru.hh.school.example.Logger;
import ru.hh.school.example.User;

public class UserInfo {

  private final Logger logger = new Logger(this);
  private final Long id;
  private final String email;
  private final String fullName;

  public UserInfo(User user) {
    logger.out("UserInfo");
    this.id = user.getId();
    this.email = user.getEmail();
    this.fullName = user.getFullName();
  }

  public Long getId() {
    logger.out("getId");
    return id;
  }

  public String getEmail() {
    logger.out("getEmail");
    return email;
  }

  public String getFullName() {
    logger.out("getFullName");
    return fullName;
  }
}
