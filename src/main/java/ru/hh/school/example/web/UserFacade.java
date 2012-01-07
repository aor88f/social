package ru.hh.school.example.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.exceptions.mail.EmailAlreadyBoundException;
import ru.hh.school.example.User;
import ru.hh.school.example.UserRepository;
import ru.hh.school.example.UserService;
import ru.hh.school.example.exceptions.mail.InvalidEmailException;

@Component
public class UserFacade {

  private final UserRepository users;
  private final UserService userService;

  @Autowired
  public UserFacade(UserRepository users, UserService userService) {
    this.users = users;
    this.userService = userService;
  }

  public Iterable<UserInfo> listUsers() {
    List<UserInfo> users = new ArrayList<UserInfo>();
    for (User user : this.users.all())
      users.add(new UserInfo(user));
    return users;
  }

  public Long registerUser(String email, String password, String fullName) throws EmailAlreadyBoundException, InvalidEmailException {
    return userService.registerUser(email, password, fullName).getId();
  }

  public Long loginUser(String email, String password) throws LoginException {
    return userService.loginUser(email, password).getId();
  }
}
