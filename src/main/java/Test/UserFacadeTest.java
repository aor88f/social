package Test;

import ru.hh.school.example.User;
import ru.hh.school.example.UserRepository;
import ru.hh.school.example.UserService;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.impl.MemUserRepository;
import ru.hh.school.example.web.UserFacade;

public class UserFacadeTest extends junit.framework.TestCase {
  private UserRepository userRepository = new MemUserRepository();
  private UserFacade userFacade = new UserFacade(userRepository, new UserService(userRepository));

  public void testLoginRegister() throws Exception {
    final String email         = "asdf@asdf.asdf";
    final String password      = "password";
    final String wrongPassword = "wrong password";
    final String sessionId     = "Session ID";
    final String fullName      = "Full Name";
    assertNull(userFacade.getUserById(1));
    userFacade.registerUser(email, password, fullName);
    assertNotNull(userFacade.getUserById(1));
    try {
        userFacade.loginUser(email, wrongPassword, sessionId);
        assertTrue(false);
    }
    catch (LoginException e) {
    }
    User sessionUser = userFacade.getUserBySessionId(sessionId);
    assertNull(sessionUser);
    userFacade.loginUser(email, password, sessionId);
    sessionUser = userFacade.getUserBySessionId(sessionId);
    assertNotNull(sessionUser);
    assertEquals(email, sessionUser.getEmail());
    assertEquals(password, sessionUser.getPassword());
    assertEquals(fullName, sessionUser.getFullName());
    userFacade.logoutUser(sessionId);
    sessionUser = userFacade.getUserBySessionId(sessionId);
    assertNull(sessionUser);
  }
}
