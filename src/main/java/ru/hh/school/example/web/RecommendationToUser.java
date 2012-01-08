package ru.hh.school.example.web;

import ru.hh.school.example.Logger;
import ru.hh.school.example.User;

public class RecommendationToUser {

  private final Logger logger = new Logger(this);
  private final long fromUserId;
  private final String text;

  public RecommendationToUser(long fromUserId, String text) {
    logger.out("RecommendationToUser");
    this.fromUserId = fromUserId;
    this.text = text;
  }

  public long getFromUserId() {
    logger.out("getFromUserId");
    return fromUserId;
  }

  public String getText() {
    logger.out("getText");
    return text;
  }
}
