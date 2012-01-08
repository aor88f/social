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

import javax.security.sasl.RealmChoiceCallback;

@Component
public class UserFacade {


  private final Logger logger = new Logger(this);
  private final UserRepository users;
  private final UserService userService;

  @Autowired
  public UserFacade(UserRepository users, UserService userService) {
    logger.out("UserFacade");
    this.users = users;
    this.userService = userService;
  }

  public Iterable<UserInfo> listUsers() {
    logger.out("listUsers");
    List<UserInfo> users = new ArrayList<UserInfo>();
    for (User user : this.users.all())
      users.add(new UserInfo(user));
    return users;
  }

  public Iterable<RecommendationToUserEx> listRecommendationsToUserEx(long id) {
    logger.out("listRecommendationsToUser");
    //List<RecommendationToUser> ret = new ArrayList<RecommendationToUser>();
    //UserInfo ui = new UserInfo(new User("asdf", "asdf", "asdf@asdf.asdf"));
    //ret.add(new RecommendationToUser(ui, "rec_text"));
    //return ret;
    Iterable<RecommendationToUser> recs = userService.getUserById(id).getRecommendationsList();
    List<RecommendationToUserEx> recsEx = new ArrayList<RecommendationToUserEx>();
    for (RecommendationToUser rec : recs) {
      User userFrom = getUserById(rec.getFromUserId());
      UserInfo userFromInfo = new UserInfo(userFrom);
      String text = rec.getText();
      RecommendationToUserEx recEx = new RecommendationToUserEx(userFromInfo, text);
      recsEx.add(recEx);
    }
    return recsEx;
  }

  public Long registerUser(String email, String password, String fullName) throws EmailAlreadyBoundException, InvalidEmailException {
    logger.out("registerUser");
    return userService.registerUser(email, password, fullName).getId();
  }

  public Long loginUser(String email, String password, String sessionId) throws LoginException {
    logger.out("loginUser");
    return userService.loginUser(email, password, sessionId).getId();
  }

  public void logoutUser(String sessionId) {
    logger.out("logoutUser");
    userService.logoutUser(sessionId);
  }

  public User getUserById(long id) {
    logger.out("getUserById");
    return userService.getUserById(id);
  }

  public User getUserBySessionId(String sessionId) {
    logger.out("getUserBySessionId");
    return userService.getUserBySessionId(sessionId);
  }

  public boolean addRecommendationToUser(long userId, RecommendationToUser recommendationToUser) {
    return userService.addRecommendation(userId, recommendationToUser);
  }
}
