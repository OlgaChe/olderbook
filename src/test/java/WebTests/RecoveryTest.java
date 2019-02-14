package WebTests;

import Components.LogIn;
import Components.Recovery;
import Services.MailVerification;
import Services.PhoneVerification;
import Setup.SetupTestWeb;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RecoveryTest extends SetupTestWeb {


    public Recovery recovery;
    public String recoveryString;


    @Test()
    @Parameters({"email", "password", "recoveryUrl", "env"})
    public void recovery(String email, String password, String recoveryUrl, String env) throws Exception {
        MailVerification mailVerification = new MailVerification();
        mailVerification.deleteAllMessages();

        LogIn logIn = new LogIn();
        logIn.clickRecoveryButton();

        Recovery recovery = new Recovery();
        recovery.stepOne(email);
        recovery.stepTwo();

        mailVerification.getEmailQuerry("Set up a new password for Orderbook.io", "?recovery=", "=0D=0A=0D=0AIf", ".*", 0);

        //recoveryString = getProperty(recoveryUrl) + ((MailVerification.emailQuerry.replace("=0D=0A=0D=0AIf", "")).replace("trading?recovery=3D", "")).replace("=", "");

        mailVerification.editRecoveryUrl(env);
        recoveryString = getProperty(recoveryUrl) + MailVerification.recoveryUrl;

        System.out.println(recoveryString);

        driver.get(recoveryString);


        recovery.stepThree(password);

        PhoneVerification phoneVerification = new PhoneVerification();
        phoneVerification.parsePage();
        Assert.assertTrue(phoneVerification.phoneExists, "Phone has expired! Please contact QA team.");

        System.out.println("Starting phone verification...");

        phoneVerification.getPhoneVerificationCode();
        String phoneVerificationCode = phoneVerification.phoneVerificationCode;
        recovery.stepFour(phoneVerificationCode.toString());
        recovery.stepFive();
  }
}

