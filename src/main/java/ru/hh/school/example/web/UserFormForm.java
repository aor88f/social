package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class UserFormForm {

  private final Logger logger = new Logger(this);
  private String from;
  private String education;
  private String experience;

  public String getFrom() {
    logger.log("getFrom");
    return from;
  }

  public void setFrom(String email) {
    logger.log("setFrom");
    this.from = from;
  }

  public String getEducation() {
    logger.log("getEducation");
    return education;
  }

  public void setEducation(String password) {
    logger.log("setEducation");
    this.education = education;
  }

  public String getExperience() {
    logger.log("getExperience");
    return experience;
  }

  public void setExperience(String fullName) {
    logger.log("setExperience");
    this.experience = experience;
  }
}
