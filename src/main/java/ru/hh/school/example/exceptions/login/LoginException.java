package ru.hh.school.example.exceptions.login;

public class LoginException extends Exception {
  private final long id;
  private final String email;
  private final String password;

  public LoginException(long id, String email, String password) {
    super();
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public long getIdl() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
