package Test;

import junit.framework.TestCase;
import ru.hh.school.example.User;
import ru.hh.school.example.exceptions.login.LoginException;
import ru.hh.school.example.impl.MemUserRepository;

public class MemUserRepositoryTest extends TestCase {
    private MemUserRepository memUserRepository = new MemUserRepository();
    
    public void testByEmail() throws Exception {
        assertNull(memUserRepository.byEmail("aa@aa.aa"));
        assertNull(memUserRepository.byEmail("bb@bb.bb"));

        User userA = new User("aa@aa.aa", "aa", "AA");
        User userB = new User("bb@bb.bb", "bb", "BB");
        
        memUserRepository.put(userA);
        memUserRepository.put(userB);

        assertEquals("aa@aa.aa", memUserRepository.byEmail("aa@aa.aa").getEmail());
        assertEquals("BB",       memUserRepository.byEmail("bb@bb.bb").getFullName());
        
        memUserRepository.remove(userA);

        assertNull(memUserRepository.byEmail("aa@aa.aa"));
        assertEquals("bb", memUserRepository.byEmail("bb@bb.bb").getPassword());
    }

    public void testByIdPassword() throws Exception {
        try {
            memUserRepository.byIdPassword(1L, "aa").getEmail();
            assertTrue(false);
        } catch (LoginException e) {
        }

        User userA = new User("aa@aa.aa", "aa", "AA");
        User userB = new User("bb@bb.bb", "bb", "BB");

        memUserRepository.put(userA);
        memUserRepository.put(userB);

        try {
            memUserRepository.byIdPassword(1L, "xx").getEmail();
            assertTrue(false);
        } catch (LoginException e) {
        }
        assertEquals("aa@aa.aa", memUserRepository.byIdPassword(1L, "aa").getEmail());
        assertEquals("BB",       memUserRepository.byIdPassword(2L, "bb").getFullName());
    }

    public void testByEmailPassword() throws Exception {
        try {
            memUserRepository.byEmailPassword("aa@aa.aa", "aa").getEmail();
            assertTrue(false);
        } catch (LoginException e) {
        }

        User userA = new User("aa@aa.aa", "aa", "AA");
        User userB = new User("bb@bb.bb", "bb", "BB");

        memUserRepository.put(userA);
        memUserRepository.put(userB);

        try {
            memUserRepository.byIdPassword(1L, "xx").getEmail();
            assertTrue(false);
        } catch (LoginException e) {
        }
        assertEquals("aa@aa.aa", memUserRepository.byEmailPassword("aa@aa.aa", "aa").getEmail());
        assertEquals("BB",       memUserRepository.byEmailPassword("bb@bb.bb", "bb").getFullName());
    }
}
