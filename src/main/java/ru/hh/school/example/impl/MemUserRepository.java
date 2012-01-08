package ru.hh.school.example.impl;

import org.springframework.stereotype.Component;
import ru.hh.school.example.Logger;
import ru.hh.school.example.User;
import ru.hh.school.example.UserRepository;
import ru.hh.school.example.exceptions.login.LoginException;

@Component
public class MemUserRepository extends MemRepository<User> implements UserRepository {

  private final Logger logger = new Logger(this);
    
  public User byEmail(String email) {
    logger.log("byEmail");
    for (User user : all())
      if (user.getEmail().equals(email))
        return user;
    return null;
  }

  public User byIdPassword(Long id, String password) throws LoginException {
    logger.log("byIdPassword");
    User user = byId(id);
    if (user == null || !password.equals(user.getPassword())) {
      throw new LoginException(id, null, password);
    }
    return user;
  }

  public User byEmailPassword(String email, String password) throws LoginException {
    logger.log("byEmailPassword");
    User user = byEmail(email);
    if (user == null || !password.equals(user.getPassword())) {
      throw new LoginException(-1, email, password);
    }
    return user;
  }
}
