package ru.hh.school.example.impl;

import java.util.HashMap;
import java.util.Map;

import ru.hh.school.example.Logger;
import ru.hh.school.example.ddd.Entity;
import ru.hh.school.example.ddd.Repository;
import ru.hh.school.example.exceptions.login.LoginException;

public abstract class MemRepository<T extends Entity> implements Repository<T> {

  private final Logger logger = new Logger(this);
  private final Map<Long, T> identityMap = new HashMap<Long, T>();
  private Long counter = 0L;

  public void put(T entity) {
    logger.out("put");
    entity.setId(++counter);
    identityMap.put(entity.getId(), entity);
  }

  public T byId(Long id) {
    logger.out("byId");
    return identityMap.get(id);
  }

  public void remove(T entity) {
    logger.out("remove");
    identityMap.remove(entity.getId());
  }

  public Iterable<T> all() {
    logger.out("all");
    return identityMap.values();
  }
}
