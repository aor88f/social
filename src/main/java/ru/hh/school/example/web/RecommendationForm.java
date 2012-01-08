package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class RecommendationForm {

  private final Logger logger = new Logger(this);
  private String text;
  private long userId;

  public String getText() {
    logger.out("getText");
    return text;
  }

  public void setText(String text) {
    logger.out("setText");
    this.text = text;
  }

  public long getUserId() {
    logger.out("getUserId");
    return userId;
  }

  public void setUserId(long userId) {
    logger.out("setUserId");
    this.userId = userId;
  }
}
