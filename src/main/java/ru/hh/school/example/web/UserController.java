package ru.hh.school.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.hh.school.example.exceptions.mail.EmailAlreadyBoundException;
import ru.hh.school.example.exceptions.mail.InvalidEmailException;

@Controller
@RequestMapping(value = "/users")
public class UserController {

  private final UserFacade userFacade;
    
  void log(String s) {
    System.out.println(s);
  }

  @Autowired
  public UserController(UserFacade userFacade) {
    log("UserController.UserController");
    this.userFacade = userFacade;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String list(Model model) {
    log("UserController.list");
    model.addAttribute("users", userFacade.listUsers());
    return "listUsers";
  }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String create(Model model) {
      log("UserController.register");
      model.addAttribute("userFormRegister", new UserFormRegister());
      return "register";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
      log("UserController.login");
      model.addAttribute("userFormLogin", new UserFormLogin());
      return "login";
    }

  @RequestMapping(method = RequestMethod.POST)
  public String doCreate(Model model, @ModelAttribute("userFormRegister") UserFormRegister userFormRegister) {
    log("UserController.doCreate");
    try {
      userFacade.registerUser(userFormRegister.getEmail(),
                              userFormRegister.getPassword(),
                              userFormRegister.getFullName());
    } catch (InvalidEmailException e) {
      model.addAttribute("error", "Email is not valid: " + e.getEmail());
      return "error";
    } catch (EmailAlreadyBoundException e) {
      model.addAttribute("error", "Email already bound: " + e.getEmail());
      return "error";
    }
    return "redirect:/users";
  }
}
