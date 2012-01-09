package Test;

import ru.hh.school.example.UserRepository;
import ru.hh.school.example.UserService;
import ru.hh.school.example.impl.MemUserRepository;
import ru.hh.school.example.web.UserFacade;

public class UserFacadeTest extends junit.framework.TestCase {
  private UserRepository userRepository = new MemUserRepository();
  private UserFacade userFacade = new UserFacade(userRepository, new UserService(userRepository));

  public void testLoginRegister() throws Exception {
    assertNull(userFacade.getUserById(1));
    userFacade.registerUser("asdf@asdf.asdf", "", "");
    assertNotNull(userFacade.getUserById(1));
  }
}
