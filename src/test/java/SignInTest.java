import com.automationpractice.pages.SignInPage;
import com.automationpractice.factory.ThreadLocalDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    @Test
    public void signIn() {
        SignInPage signInPage = new SignInPage(ThreadLocalDriver.getTLDriver(), parentTest.get());
        assertFalse(true, "Sign out link was not displayed");
    }

    @Test
    public void forgotPassword() {
        assertTrue(true, "Success message was not displayed");
    }

    @Test
    public void signInWithInvalidCredentials() {
        assertTrue(true, "Error message was not displayed");
    }

    @Test
    public void forgotPasswordWithInvalidCredentials() {
        assertTrue(true, "Error message was not displayed");
    }

    @Test
    public void signOut() {
        assertTrue(true, "SignIn link was not displayed after sign out action");
    }
}