package WebTests;

import Components.Header;
import Components.Settings.Settings;
import Setup.SetupTestWeb;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTest extends SetupTestWeb {


    public Header header;
    public Settings settings;

    @Test
    public void openSignUp() {
        header = new Header();
        header.clickSignUpButton();
        //Assert.assertTrue(isElementNotVisible(header.signUpButton));

        System.out.println("Redirect to Sign Up step.");

    }

    @Test
    public void openLogIn() {
        header = new Header();
        header.clickLogInButton();
        //Assert.assertTrue(isElementNotVisible(header.logInButton));

        System.out.println("Redirect to Log In step.");
    }

    @Test()
    public void logOut() {
        header = new Header();
        header.clickProfileMenu();
        header.clickLogOut();

        Assert.assertTrue(isElementVisible(header.signUpButton));

        System.out.println("Log Out completed.");
    }

    @Test
    public void openSettings(){
        header = new Header();
        header.clickSettingsButton();

        settings = new Settings();
        Assert.assertTrue(isElementVisible(settings.accountSettingsButton));
        System.out.println("Redirect to Settings.");
    }

    @Test
    public void openTrades() throws InterruptedException {
        header = new Header();
        header.clickTradeButton();

        Thread.sleep(5000);

        System.out.println("Redirect to Trades");
    }
}
