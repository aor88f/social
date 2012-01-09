package Test;

import junit.framework.TestCase;
import ru.hh.school.example.web.UserSessions;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 1/9/12
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserSessionsTest extends TestCase {
    private UserSessions userSessions = new UserSessions();
    
    public void test1() throws Exception {
        assertNull(userSessions.getEntityId("sessionId1"));
        assertNull(userSessions.getEntityId("sessionId2"));
        assertNull(userSessions.getEntityId("sessionId3"));
        
        userSessions.login("sessionId1", 1);

        assertEquals((Long) 1L, userSessions.getEntityId("sessionId1"));
        assertNull(userSessions.getEntityId("sessionId2"));
        assertNull(userSessions.getEntityId("sessionId3"));

        userSessions.login("sessionId2", 2);

        assertEquals((Long) 1L, userSessions.getEntityId("sessionId1"));
        assertEquals((Long) 2L, userSessions.getEntityId("sessionId2"));
        assertNull(userSessions.getEntityId("sessionId3"));

        userSessions.login("sessionId3", 3);

        assertEquals((Long) 1L, userSessions.getEntityId("sessionId1"));
        assertEquals((Long) 2L, userSessions.getEntityId("sessionId2"));
        assertEquals((Long) 3L, userSessions.getEntityId("sessionId3"));

        userSessions.logout("sessionId2");

        assertEquals((Long) 1L, userSessions.getEntityId("sessionId1"));
        assertNull(userSessions.getEntityId("sessionId2"));
        assertEquals((Long) 3L, userSessions.getEntityId("sessionId3"));

        userSessions.login("sessionId4", 4);

        assertEquals((Long) 1L, userSessions.getEntityId("sessionId1"));
        assertNull(userSessions.getEntityId("sessionId2"));
        assertEquals((Long) 3L, userSessions.getEntityId("sessionId3"));
        assertEquals((Long) 4L, userSessions.getEntityId("sessionId4"));
    }
}
