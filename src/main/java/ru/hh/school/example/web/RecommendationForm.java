package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class RecommendationForm {

  private final Logger logger = new Logger(this);
  private String text;

  public String getText() {
    logger.out("getText");
    return text;
  }

  public void setText(String email) {
    logger.out("setText");
    this.text = text;
  }
}
