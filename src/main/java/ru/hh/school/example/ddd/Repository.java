package ru.hh.school.example.ddd;

import ru.hh.school.example.exceptions.login.LoginException;

public interface Repository<T extends Entity> {
  public void put(T entity);
  public T byId(Long id);
  public T byIdPassword(Long id, String password) throws LoginException;
  public void remove(T entity);
  Iterable<T> all();
}
