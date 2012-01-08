package ru.hh.school.example.web;

import ru.hh.school.example.Logger;
import ru.hh.school.example.User;

public class RecommendationToUser {

  private final Logger logger = new Logger(this);
  private final UserInfo fromUserInfo;
  private final String text;

  public RecommendationToUser(UserInfo fromUserInfo, String text) {
    logger.log("RecommendationToUser");
    this.fromUserInfo = fromUserInfo;
    this.text = text;
  }

  public UserInfo getFromUserInfo() {
    logger.log("getFromUserInfo");
    return fromUserInfo;
  }

  public String getText() {
    logger.log("getText");
    return text;
  }
}
