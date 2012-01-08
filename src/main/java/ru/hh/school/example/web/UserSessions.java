package ru.hh.school.example.web;

import ru.hh.school.example.Logger;
import ru.hh.school.example.Sessions;

import java.util.HashMap;
import java.util.Map;

public class UserSessions implements Sessions {
    
  Logger logger = new Logger(this);    
  Map sessionUserMap = new HashMap<Long, Long>();
  
  @Override
  public void login(long sessionId, long entityId) {
    logger.log("login");
    sessionUserMap.put(sessionId, entityId);
  }

  @Override
  public void logout(long sessionId) {
    logger.log("logout");
    sessionUserMap.remove(sessionId);
  }

  @Override
  public Long getEntityId(long sessionId) {
    logger.log("getEntityId");
    return (Long)sessionUserMap.get(sessionId);
  }
}
