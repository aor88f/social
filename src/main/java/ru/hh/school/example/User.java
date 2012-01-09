package ru.hh.school.example;

import ru.hh.school.example.ddd.Entity;
import ru.hh.school.example.web.RecommendationRequest;
import ru.hh.school.example.web.RecommendationToUser;
import ru.hh.school.example.web.UserForm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class User extends Entity {

  private final Logger logger = new Logger(this);
  private String email;
  private String password;
  private String fullName;
  private UserForm userForm = new UserForm();
  private List<RecommendationToUser> recommendationsList = new ArrayList<RecommendationToUser>();
  private LinkedHashSet<RecommendationRequest> recommendationRequestsList = new LinkedHashSet<RecommendationRequest>();

  public User(String email, String password, String fullName) {
    logger.out("User");
    this.email = email;
    this.password = password;
    this.fullName = fullName;
  }
    
  public void setUserForm(UserForm userForm) {
    this.userForm = userForm;
  }

  public String getEmail() {
    logger.out("getEmail");
    return email;
  }

  public String getPassword() {
    logger.out("getPassword");
    return password;
  }

  public String getFullName() {
    logger.out("getFullName");
    return fullName;
  }

  public UserForm getUserForm() {
    logger.out("getUserForm");
    return userForm;
  }

  public List<RecommendationToUser> getRecommendationsList() {
    logger.out("getRecommendationsList");
    return recommendationsList;
  }

  public void addRecommendation(RecommendationToUser recommendationToUser) {
    logger.out("addRecommendation");
    recommendationsList.add(recommendationToUser);
  }

  public void addRecommendationRequest(RecommendationRequest recommendationRequest) {
    logger.out("addRecommendationRequest");
    recommendationRequestsList.add(recommendationRequest);
  }

  public LinkedHashSet<RecommendationRequest> getRecommendationsRequestsList() {
    logger.out("getRecommendationsRequestsList");
    return recommendationRequestsList;
  }
}
