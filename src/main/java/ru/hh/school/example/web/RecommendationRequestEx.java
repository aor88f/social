package ru.hh.school.example.web;

public class RecommendationRequestEx {
  private final UserInfo requesterUserInfo;
  private final UserInfo toUserInfo;

  RecommendationRequestEx(UserInfo requesterUserInfo, UserInfo toUserInfo) {
    this.requesterUserInfo = requesterUserInfo;
    this.toUserInfo = toUserInfo;
  }

  public UserInfo getRequesterUserInfo() {
    return requesterUserInfo;
  }

  public UserInfo getToUserInfo() {
    return toUserInfo;
  }
}
