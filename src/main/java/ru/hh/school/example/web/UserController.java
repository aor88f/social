package ru.hh.school.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import ru.hh.school.example.Logger;
import ru.hh.school.example.User;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.exceptions.mail.EmailAlreadyBoundException;
import ru.hh.school.example.exceptions.mail.InvalidEmailException;

@Controller
@RequestMapping(value = "/users")
public class UserController {

  private final UserFacade userFacade;
  private final Logger logger = new Logger(this);

  @Autowired
  public UserController(UserFacade userFacade) {
    logger.out("UserController");
    this.userFacade = userFacade;
  }

  protected String getSessionId() {
    String ret = RequestContextHolder.currentRequestAttributes().getSessionId();
    logger.out("getSessionId: " + ret);
    return ret;
  }

  protected String getNavigation() {
    logger.out("getNavigation");
    return (userFacade.getUserBySessionId(getSessionId()) == null) ? getNavigationNotLoginned()
                                                                   : getNavigationLoginned();
  }

  protected String getNavigationLoginned() {
    logger.out("getNavigationLoginned");
    return "<a href=home>Home</a>  <a href=listUsers>Users</a>  <a href=logout>Logout</a>";
  }

  protected String getNavigationNotLoginned() {
    logger.out("getNavigationNotLoginned");
    return "<a href=listUsers>Users</a>  <a href=login>Login</a>  <a href=register>Register</a>";
  }

  @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
  public String list(Model model) {
    logger.out("list");
    model.addAttribute("navigation", getNavigation());
    model.addAttribute("users", userFacade.listUsers());
    return "listUsers";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model) {
    logger.out("login");
    model.addAttribute("navigation", getNavigation());
    model.addAttribute("userFormLogin", new UserFormLogin());
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String doLogin(Model model, @ModelAttribute("userFormLogin") UserFormLogin userFormLogin) {
    logger.out("doLogin");
    try {
      userFacade.loginUser(userFormLogin.getEmail(), userFormLogin.getPassword(), getSessionId());
    } catch (LoginException e) {
      model.addAttribute("navigation", getNavigation());
      model.addAttribute("error", "The username or password you entered is incorrect.");
      model.addAttribute("var", "<a href=\"login\">Back</a>");
      return "error";
    }

    return "redirect:/users/home";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String create(Model model) {
    logger.out("register");
    model.addAttribute("navigation", getNavigation());
    model.addAttribute("userFormRegister", new UserFormRegister());
    return "register";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String doCreate(Model model, @ModelAttribute("userFormRegister") UserFormRegister userFormRegister) {
    logger.out("doCreate");
    try {
      userFacade.registerUser(userFormRegister.getEmail(),
                              userFormRegister.getPassword(),
                              userFormRegister.getFullName());
    } catch (InvalidEmailException e) {
      model.addAttribute("navigation", getNavigation());
      model.addAttribute("error", "Email is not valid: " + e.getEmail());
      model.addAttribute("var", "<a href=\"register\">Back</a>");
      return "error";
    } catch (EmailAlreadyBoundException e) {
      model.addAttribute("navigation", getNavigation());
      model.addAttribute("error", "Email already bound: " + e.getEmail());
      model.addAttribute("var", "<a href=\"register\">Back</a>");
      return "error";
    }
    return "redirect:/users/login";
  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home(Model model) {
    logger.out("home");
    User user = userFacade.getUserBySessionId(getSessionId());
    if (user == null)
      return "redirect:/users/login";
    model.addAttribute("user", user.getFullName() + '[' + user.getEmail() + ']');
    model.addAttribute("navigation", getNavigation());
    model.addAttribute("userForm", user.getUserForm());
    return "home";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(Model model) {
    logger.out("logout");
    userFacade.logoutUser(getSessionId());
    return "redirect:/";
  }

  @RequestMapping(value = "/editForm", method = RequestMethod.GET)
  public String editForm(Model model) {
    logger.out("editForm");
    User user = userFacade.getUserBySessionId(getSessionId());
    if (user == null)
      return "redirect:/users/login";
    model.addAttribute("navigation", getNavigation());
    model.addAttribute("userForm", user.getUserForm());
    return "editForm";
  }

  @RequestMapping(value = "/editForm", method = RequestMethod.POST)
  public String doEditForm(Model model, @ModelAttribute("userForm") UserForm userForm) {
    logger.out("doEditForm");
    User user = userFacade.getUserBySessionId(getSessionId());
    user.setUserForm(userForm);
    return "redirect:/users/home";
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String user(Model model, @RequestParam("id") long id) {
    logger.out("user?id=" + id);
    User user = userFacade.getUserById(id);
    model.addAttribute("navigation", getNavigation());
    model.addAttribute("user", user);
    model.addAttribute("userForm", user.getUserForm());
    return "user";
  }
}
