package ru.hh.school.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.exceptions.mail.EmailAlreadyBoundException;
import ru.hh.school.example.exceptions.mail.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserService {

  private final UserRepository users;

  @Autowired
  public UserService(UserRepository users) {
    this.users = users;
  }

    public User registerUser(String email, String password, String fullName) throws EmailAlreadyBoundException, InvalidEmailException {
        if (!isValidEmail(email))
            throw new InvalidEmailException(email);
        User existing = users.byEmail(email);
        if (existing != null)
            throw new EmailAlreadyBoundException(email);
        User user = new User(email, password, fullName);
        users.put(user);
        return user;
    }

    public User loginUser(String email, String password) throws LoginException {
        User existing = users.byEmailPassword(email, password);
        if (existing == null)
            throw new LoginException(-1, email, password);
        return existing;
    }

  public boolean isValidEmail(final String email) {
      final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

      Pattern pattern = Pattern.compile(EMAIL_PATTERN);
      Matcher matcher = pattern.matcher(email);
      return matcher.matches();
  }
}
