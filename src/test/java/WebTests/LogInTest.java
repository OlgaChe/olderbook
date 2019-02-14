package WebTests;

import Components.Header;
import Components.LogIn;
import Setup.SetupTestWeb;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LogInTest extends SetupTestWeb {

    SoftAssert s = new SoftAssert();


    public LogIn logIn;

    @Parameters ({"login", "password"})
    @Test()
    public void logIn(String login, String password) throws InterruptedException, IOException {
        logIn = new LogIn();
        logIn.logInInput(login, password);
        logIn.clickLogInButton();

        Header header = new Header();
        header.clickProfileMenu();

        waitForElement(header.accountName);


        //Assert.assertEquals(header.accountName.getText(), login);
        s.assertEquals(header.accountName.getText(), "hhhhh");
        s.assertAll();

        header.clickProfileMenu();
        System.out.println("Login completed successfully.");

    }

    @Parameters ({"login", "password"})
    @Test
    public void logInQuick(String login, String password)  throws InterruptedException {
        logIn = new LogIn();
        logIn.logInInput( login , password);
        logIn.clickLogInButton();
    }
}

