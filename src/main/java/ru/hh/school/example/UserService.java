package ru.hh.school.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.exceptions.mail.EmailAlreadyBoundException;
import ru.hh.school.example.exceptions.mail.InvalidEmailException;
import ru.hh.school.example.web.UserSessions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserService {

  private final Logger logger = new Logger(this);
  private final UserRepository users;
  private final UserSessions userSessions = new UserSessions();


  @Autowired
  public UserService(UserRepository users) {
    logger.out("UserService");
    this.users = users;
  }

  public User registerUser(String email, String password, String fullName) throws EmailAlreadyBoundException, InvalidEmailException {
    logger.out("registerUser");
    if (!isValidEmail(email))
      throw new InvalidEmailException(email);
    User existing = users.byEmail(email);
    if (existing != null)
      throw new EmailAlreadyBoundException(email);
    User user = new User(email, password, fullName);
    users.put(user);
    return user;
  }

  public User loginUser(String email, String password, String sessionId) throws LoginException {
    logger.out("loginUser");
    User existing = users.byEmailPassword(email, password);
    if (existing == null)
      throw new LoginException(-1, email, password);
    userSessions.login(sessionId, existing.getId());
    return existing;
  }

  public User getUserById(Long id) {
    logger.out("getUserById");
    return users.byId(id);
  }

  public User getUserBySessionId(String session) {
    logger.out("getUserBySessionId");
    return getUserById(userSessions.getEntityId(session));
  }
    
  public void logoutUser(String sessionId) {
    logger.out("logoutUser");
    userSessions.logout(sessionId);
  }

  public boolean isValidEmail(final String email) {
    logger.out("isValidEmail");
    final String emailPattern =
      "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(emailPattern);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
