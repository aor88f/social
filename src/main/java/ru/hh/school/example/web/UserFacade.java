package ru.hh.school.example.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hh.school.example.Logger;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.exceptions.mail.EmailAlreadyBoundException;
import ru.hh.school.example.User;
import ru.hh.school.example.UserRepository;
import ru.hh.school.example.UserService;
import ru.hh.school.example.exceptions.mail.InvalidEmailException;

@Component
public class UserFacade {


  private final Logger logger = new Logger(this);
  private final UserRepository users;
  private final UserService userService;

  @Autowired
  public UserFacade(UserRepository users, UserService userService) {
    logger.log("UserFacade");
    this.users = users;
    this.userService = userService;
  }

  public Iterable<UserInfo> listUsers() {
    logger.log("listUsers");
    List<UserInfo> users = new ArrayList<UserInfo>();
    for (User user : this.users.all())
      users.add(new UserInfo(user));
    return users;
  }

  public Iterable<RecommendationToUser> listRecommendationsToUser(long id) {
    logger.log("listRecommendationsToUser");
    List<RecommendationToUser> ret = new ArrayList<RecommendationToUser>();
    UserInfo ui = new UserInfo(new User("asdf", "asdf", "asdf@asdf.asdf"));
    ret.add(new RecommendationToUser(ui, "rec_text"));
    return ret;
  }

  public Long registerUser(String email, String password, String fullName) throws EmailAlreadyBoundException, InvalidEmailException {
    logger.log("registerUser");
    return userService.registerUser(email, password, fullName).getId();
  }

  public Long loginUser(String email, String password, String sessionId) throws LoginException {
    logger.log("loginUser");
    return userService.loginUser(email, password, sessionId).getId();
  }

  public void logoutUser(String sessionId) {
    logger.log("logoutUser");
    userService.logoutUser(sessionId);
  }

  public User getUserById(long id) {
    logger.log("getUserById");
    return userService.getUserById(id);
  }

  public User getUserBySessionId(String sessionId) {
    logger.log("getUserBySessionId");
    return userService.getUserBySessionId(sessionId);
  }
}
