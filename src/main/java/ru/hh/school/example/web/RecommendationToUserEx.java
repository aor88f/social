package ru.hh.school.example.web;

import ru.hh.school.example.Logger;

public class RecommendationToUserEx {

  private final Logger logger = new Logger(this);
  private final UserInfo fromUserInfo;
  private final String text;

  public RecommendationToUserEx(UserInfo fromUserInfo, String text) {
    logger.out("RecommendationToUser");
    this.fromUserInfo = fromUserInfo;
    this.text = text;
  }

  public UserInfo getFromUserInfo() {
    logger.out("getFromUserInfo");
    return fromUserInfo;
  }

  public String getText() {
    logger.out("getText");
    return text;
  }
}
