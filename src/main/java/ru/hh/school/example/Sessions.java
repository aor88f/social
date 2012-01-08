package ru.hh.school.example;

public interface Sessions {
  void login(long sessionId, long entityId);
  void logout(long sessionId);
  Long getEntityId(long sessionId);
}
