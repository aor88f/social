package Test;

import ru.hh.school.example.User;
import ru.hh.school.example.UserRepository;
import ru.hh.school.example.UserService;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.impl.MemUserRepository;
import ru.hh.school.example.web.RecommendationRequestEx;
import ru.hh.school.example.web.RecommendationToUserEx;
import ru.hh.school.example.web.UserFacade;

import java.util.Collections;

public class UserFacadeTest extends junit.framework.TestCase {
  private UserRepository userRepository = new MemUserRepository();
  private UserFacade userFacade = new UserFacade(userRepository, new UserService(userRepository));

  public void testRegisterLoginLogout() throws Exception {
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

    public void testGetUserById() throws Exception {
        assertNull(userFacade.getUserById(1));
        assertNull(userFacade.getUserById(2));
        assertNull(userFacade.getUserById(3));

        userFacade.registerUser("aa@aa.aa", "", "");
        assertEquals("aa@aa.aa", userFacade.getUserById(1).getEmail());
        assertNull(userFacade.getUserById(2));
        assertNull(userFacade.getUserById(3));

        userFacade.registerUser("bb@bb.bb", "", "");
        assertEquals("aa@aa.aa", userFacade.getUserById(1).getEmail());
        assertEquals("bb@bb.bb", userFacade.getUserById(2).getEmail());
        assertNull(userFacade.getUserById(3));

        userFacade.registerUser("cc@cc.cc", "", "");
        assertEquals("aa@aa.aa", userFacade.getUserById(1).getEmail());
        assertEquals("bb@bb.bb", userFacade.getUserById(2).getEmail());
        assertEquals("cc@cc.cc", userFacade.getUserById(3).getEmail());
    }

    public void testGetUserBySessionId() throws Exception {
        assertNull(userFacade.getUserBySessionId("sessionId1"));
        assertNull(userFacade.getUserBySessionId("sessionId2"));

        userFacade.registerUser("aaa@aa.aa", "", "");
        userFacade.registerUser("bbb@bb.bb", "", "");
        userFacade.loginUser("aaa@aa.aa", "", "sessionId1");
        userFacade.loginUser("bbb@bb.bb", "", "sessionId2");

        assertEquals("aaa@aa.aa", userFacade.getUserBySessionId("sessionId1").getEmail());
        assertEquals("bbb@bb.bb", userFacade.getUserBySessionId("sessionId2").getEmail());

        userFacade.logoutUser("sessionId1");

        assertNull(userFacade.getUserBySessionId("sessionId1"));
        assertEquals("bbb@bb.bb", userFacade.getUserBySessionId("sessionId2").getEmail());
    }      
    
    public void testAddRecommendationRequest() throws Exception {
        userFacade.registerUser("aaaa@aa.aa", "", "");
        userFacade.registerUser("bbbb@bb.bb", "", "");
        userFacade.registerUser("cccc@bb.bb", "", "");

        userFacade.addRecommendationRequest(1, 2, 3);
        assertEquals(1, count(userFacade.listRecommendationRequestsExRev(2)));

        userFacade.addRecommendationRequest(3, 2, 1);
        assertEquals(2, count(userFacade.listRecommendationRequestsExRev(2)));

        userFacade.removeRequest(1, 2, 3);
        assertEquals(1, count(userFacade.listRecommendationRequestsExRev(2)));
    }

    protected long count(Iterable<RecommendationRequestEx>/*<T>*/ iterable) {
        long ret = 0;
        for (RecommendationRequestEx req : iterable)
            ++ret;
        return ret;
    }
}
