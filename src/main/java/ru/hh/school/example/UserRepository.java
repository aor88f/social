package ru.hh.school.example;

import ru.hh.school.example.ddd.Repository;
import ru.hh.school.example.exceptions.login.LoginException;

public interface UserRepository extends Repository<User> {
  User byEmail(String email);
  User byIdPassword(Long id, String password) throws LoginException;
  User byEmailPassword(String email, String password) throws LoginException;
}
