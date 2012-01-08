package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class UserForm {

  private final Logger logger = new Logger(this);
  private String from;
  private String education;
  private String experience;

  public String getFrom() {
    logger.log("getFrom");
    return from;
  }

  public void setFrom(String from) {
    logger.log("setFrom");
    this.from = from;
  }

  public String getEducation() {
    logger.log("getEducation");
    return education;
  }

  public void setEducation(String education) {
    logger.log("setEducation");
    this.education = education;
  }

  public String getExperience() {
    logger.log("getExperience");
    return experience;
  }

  public void setExperience(String experience) {
    logger.log("setExperience");
    this.experience = experience;
  }
}
