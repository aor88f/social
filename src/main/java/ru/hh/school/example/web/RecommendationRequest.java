package ru.hh.school.example.web;

public class RecommendationRequest {
  private long fromId;
  private long toId;

  RecommendationRequest(long fromId, long toId) {
    this.fromId = fromId;
    this.toId = toId;
  }

  public long getFromId() {
    return fromId;
  }

  public long getToId() {
    return toId;
  }
}
