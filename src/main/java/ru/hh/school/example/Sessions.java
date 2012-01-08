package ru.hh.school.example;

public interface Sessions {
  void login(String sessionId, long entityId);
  void logout(String sessionId);
  Long getEntityId(String sessionId);
}
