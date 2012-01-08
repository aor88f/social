package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;
import ru.hh.school.example.web.UserForm;

public class User extends Entity {

  private final Logger logger = new Logger(this);
  private String email;
  private String password;
  private String fullName;
  private UserForm userForm = new UserForm();

  public User(String email, String password, String fullName) {
    logger.out("User");
    this.email = email;
    this.password = password;
    this.fullName = fullName;
  }
    
  public void setUserForm(UserForm userForm) {
    this.userForm = userForm;
  }

  public String getEmail() {
    logger.out("getEmail");
    return email;
  }

  public String getPassword() {
    logger.out("getPassword");
    return password;
  }

  public String getFullName() {
    logger.out("getFullName");
    return fullName;
  }

  public UserForm getUserForm() {
    logger.out("getUserForm");
    return userForm;
  }
}
