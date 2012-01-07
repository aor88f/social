package ru.hh.school.example.exceptions.login;

public class LoginException extends Exception {
    private final String email;
    private final String password;

    public LoginException(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
