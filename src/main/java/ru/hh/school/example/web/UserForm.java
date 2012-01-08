package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class UserForm {

  private final Logger logger = new Logger(this);
  private String from;
  private String education;
  private String experience;

  public String getFrom() {
    logger.out("getFrom");
    return from;
  }

  public void setFrom(String from) {
    logger.out("setFrom");
    this.from = from;
  }

  public String getEducation() {
    logger.out("getEducation");
    return education;
  }

  public void setEducation(String education) {
    logger.out("setEducation");
    this.education = education;
  }

  public String getExperience() {
    logger.out("getExperience");
    return experience;
  }

  public void setExperience(String experience) {
    logger.out("setExperience");
    this.experience = experience;
  }
}
