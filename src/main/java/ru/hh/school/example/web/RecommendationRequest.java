package ru.hh.school.example.web;

public class RecommendationRequest {
  private long requesterId;
  private long toId;

  RecommendationRequest(long fromId, long toId) {
    this.requesterId = fromId;
    this.toId = toId;
  }

  public long getRequesterId() {
    return requesterId;
  }

  public long getToId() {
    return toId;
  }
}
