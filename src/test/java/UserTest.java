import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Testing User Class")
public class UserTest {
    @Test
    public void SettersAndGettersTest() {
        User newUser = new User("john", "pass1234");
        String name = newUser.getUsername();
        String password = newUser.getPassword();

        newUser.setUsername("bob");
        newUser.setPassword("password");

        String newName = newUser.getUsername();
        String newPass = newUser.getPassword();

        assertEquals("john", name);
        assertEquals("pass1234", password);
        assertEquals("bob", newName);
        assertEquals("password", newPass);
    }
}