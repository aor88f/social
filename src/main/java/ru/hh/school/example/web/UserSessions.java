package ru.hh.school.example.web;

import ru.hh.school.example.Logger;
import ru.hh.school.example.Sessions;

import java.util.HashMap;
import java.util.Map;

public class UserSessions implements Sessions {
    
  Logger logger = new Logger(this);    
  Map sessionUserMap = new HashMap<String, Long>();
  
  @Override
  public void login(String sessionId, long entityId) {
    logger.log("login");
    sessionUserMap.put(sessionId, entityId);
  }

  @Override
  public void logout(String sessionId) {
    logger.log("logout");
    sessionUserMap.remove(sessionId);
  }

  @Override
  public Long getEntityId(String sessionId) {
    logger.log("getEntityId");
      logger.log("" + sessionUserMap.isEmpty());
      logger.log("xxxxx");
      logger.log(sessionId);
    return (Long)sessionUserMap.get(sessionId);
  }
}
