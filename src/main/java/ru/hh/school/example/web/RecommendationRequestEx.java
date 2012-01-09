package ru.hh.school.example.web;

public class RecommendationRequestEx {
  private final UserInfo requesterUserInfo;
  private final UserInfo toUserInfo;

  RecommendationRequestEx(UserInfo fromUserInfo, UserInfo toUserInfo) {
    this.requesterUserInfo = fromUserInfo;
    this.toUserInfo = toUserInfo;
  }

  public UserInfo getRequesterUserInfo() {
    return requesterUserInfo;
  }

  public UserInfo getToUserInfo() {
    return toUserInfo;
  }
}
