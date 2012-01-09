package ru.hh.school.example.web;

public class RecommendationRequestEx {
  private final UserInfo fromUserInfo;
  private final UserInfo toUserInfo;

  RecommendationRequestEx(UserInfo fromUserInfo, UserInfo toUserInfo) {
    this.fromUserInfo = fromUserInfo;
    this.toUserInfo = toUserInfo;
  }

  public UserInfo getFromUserInfo() {
    return fromUserInfo;
  }

  public UserInfo getToUserInfo() {
    return toUserInfo;
  }
}
