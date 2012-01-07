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

  @Autowired
  public UserController(UserFacade userFacade) {
      System.out.println("UserController.UserController");
    this.userFacade = userFacade;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String list(Model model) {
      System.out.println("UserController.list");
    model.addAttribute("users", userFacade.listUsers());
    return "listUsers";
  }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String create(Model model) {
        System.out.println("UserController.create");
        model.addAttribute("userForm", new UserForm());
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String login(Model model) {
        System.out.println("UserController.create");
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

  @RequestMapping(method = RequestMethod.POST)
  public String doCreate(Model model, @ModelAttribute("userForm") UserForm userForm) {
            System.out.println("UserController.doCreate");
    try {
      userFacade.registerUser(userForm.getEmail(), userForm.getPassword(), userForm.getFullName());
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
