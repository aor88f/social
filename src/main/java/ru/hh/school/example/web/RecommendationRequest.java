package ru.hh.school.example.web;

public class RecommendationRequest {
  private long requesterId;
  private long toId;

  RecommendationRequest(long requesterId, long toId) {
    this.requesterId = requesterId;
    this.toId = toId;
  }

  public long getRequesterId() {
    return requesterId;
  }

  public long getToId() {
    return toId;
  }
}
