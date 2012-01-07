package ru.hh.school.example.impl;

import org.springframework.stereotype.Component;
import ru.hh.school.example.User;
import ru.hh.school.example.UserRepository;
import ru.hh.school.example.exceptions.login.LoginException;

@Component
public class MemUserRepository extends MemRepository<User> implements UserRepository {
  public User byEmail(String email) {
    for (User user : all())
      if (user.getEmail().equals(email))
        return user;
    return null;
  }

  public User byIdPassword(Long id, String password) throws LoginException {
    User user = byId(id);
    if (password != user.getPassword()) {
      throw new LoginException(id, null, password);
    }
    return user;
  }

  public User byEmailPassword(String email, String password) throws LoginException {
    User user = byEmail(email);
    if (password != user.getPassword()) {
      throw new LoginException(-1, email, password);
    }
    return user;
  }
}
