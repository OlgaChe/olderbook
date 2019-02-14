package WebTests;

import Components.Header;
import Components.SignUp;
import Data.UserData;
import Services.BrowserStorages.SessionStorage;
import Services.GetLastBlock;
import Services.MailVerification;
import Services.PhoneVerification;
import Setup.SetupTestWeb;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;


public class SignUpTest extends SetupTestWeb {


    public SignUp signUp;
    public String email = new UserData().uniqueAccount;

    @Test()
    public void signUp() throws Exception {

        //Delete emails
        MailVerification mailVerification = new MailVerification();
        mailVerification.deleteAllMessages();

        //Start account creation
        signUp = new SignUp();
        System.out.println(new Date());
        System.out.println(new UserData().uniqueAccount);
        signUp.signUpInput(email, getProperty("birthDate"), getProperty("signUpPassword"), getProperty("confirmPassword"), getProperty("firstName"), getProperty("lastName"));
        signUp.clickCountryDrop(getProperty("country"));
        signUp.checkSignUpTerms();
        signUp.clickSignUpButton();

        //Stop if no redirect to account activation
//        Assert.assertTrue(isElementNotVisible(signUp.emailInput), "Failed to redirect to Mail Verification step.");
        System.out.println("Redirect to Mail Verification step.");

        //Account activation
        System.out.println("Starting mail verification...");
        mailVerification.getEmailQuerry("Welcome to Orderbook.io!", "=0D=0A=0D=0A","=0D=0A=0D=0A", "([A-F0-9]{8})", 1);
        String activationCode = MailVerification.emailQuerry;

        //Stop if mail was not found
        Assert.assertTrue(mailVerification.isMailFound, "Mail not found!");

        signUp.activationCodeInput(activationCode);
        signUp.clickConfirmEmailButton();

        //stop if no redirect to phone verification
        //Assert.assertTrue(isElementNotVisible(signUp.activationCodeInput), "Failed to redirect to Phone Verification step.");
        System.out.println("Email was confirmed.");
        System.out.println("Redirect to Phone Verification step.");

        //Phone verification
        PhoneVerification phoneVerification = new PhoneVerification();
        signUp.phoneNumberInput("+" + getProperty("phone"));
        phoneVerification.parsePage();
        Assert.assertTrue(phoneVerification.phoneExists, "Phone has expired! Please contact QA team.");
        signUp.clickConfirmPhoneButton();

        //stop if no redirect to sms confirmation
        //Assert.assertTrue(isElementNotVisible(signUp.phoneNumberInput), "No redirect to SMS confirmation page.");
        System.out.println("Redirect to SMS confirmation page.");
        System.out.println("Starting phone verification...");

        phoneVerification.getPhoneVerificationCode();
        String phoneVerificationCode = phoneVerification.phoneVerificationCode;
        signUp.phoneVerificationConfirmInput(phoneVerificationCode.toString());

        //Stop if SMS not received
        Assert.assertTrue(phoneVerification.smsReceived, "No SMS received! Something went wrong. Please contact  QA team. ");
        System.out.println("Phone was confirmed.");
        signUp.clickConfirmPhoneActivationCodeButton();

        //Finish SignUp
        Assert.assertTrue(isElementNotVisible(signUp.phoneVerificationConfirmInput), "No redirect to thank you screen.");

        signUp.clickThankYouButton();
        Assert.assertTrue(isElementNotVisible(signUp.thankYouButton), "No redirect to OkThanks screen.");

        signUp.clickOkThanksButton();
        Assert.assertTrue(isElementNotVisible(signUp.okThanksButton), "No redirect to Dashboard.");

        Header header = new Header();
        header.clickProfileMenu();
        waitForElement(header.accountName);

        System.out.printf("Is lastUser present in SessionStorage: ");
        SessionStorage sessionStorage = new SessionStorage(driver);
        System.out.println(sessionStorage.isItemPresentInSessionStorage("app"));

        GetLastBlock getLastBlock = new GetLastBlock();
        getLastBlock.getLastBlock();

        Assert.assertEquals(header.accountName.getText(), email, "Sign Up is failed!");
        header.clickProfileMenu();

        System.out.println("Sign Up is successful!");

    }

    ///
    ///Sign Up test separated into one
    ///

    @Test
    public void createAccountOB() throws IOException, MessagingException {
        MailVerification mailVerification = new MailVerification();
        mailVerification.deleteAllMessages();

        signUp = new SignUp();
        signUp.signUpInput(email, getProperty("birthDate"), getProperty("signUpPassword"), getProperty("confirmPassword"), getProperty("firstName"), getProperty("lastName"));
        signUp.clickCountryDrop(getProperty("country"));
        signUp.checkSignUpTerms();
        signUp.clickSignUpButton();

        //Stop if no redirect to account activation
        Assert.assertTrue(isElementNotVisible(signUp.emailInput), "Failed to redirect to Mail Verification step.");
        System.out.println("Redirect to Mail Verification step.");
    }

    @Test
    public void mailVerification() throws Exception {
        //Account activation
        MailVerification mailVerification = new MailVerification();

        System.out.println("Starting mail verification...");
        mailVerification.getEmailQuerry("Welcome to Orderbook.io!", "=0D=0A=0D=0A", "=0D=0A=0D=0A", "([A-F0-9]{8})",1);
        String activationCode = MailVerification.emailQuerry;

        //Stop if mail was not found
        Assert.assertTrue(mailVerification.isMailFound, "Mail not found!");

        signUp.activationCodeInput(activationCode);
        signUp.clickConfirmEmailButton();

        //stop if no redirect to phone verification
        Assert.assertTrue(isElementNotVisible(signUp.activationCodeInput), "Failed to redirect to Phone Verification step.");
        System.out.println("Email was confirmed.");
        System.out.println("Redirect to Phone Verification step.");
    }

    @Test
    public void phoneInputStep() throws InterruptedException {
        //Phone verification
        signUp = new SignUp();
        Thread.sleep(8000); ///fix this

        PhoneVerification phoneVerification = new PhoneVerification();
        signUp.phoneNumberInput("+" + getProperty("phone"));
        phoneVerification.parsePage();
        Assert.assertTrue(phoneVerification.phoneExists, "Phone has expired! Please contact QA team.");
        signUp.clickConfirmPhoneButton();

        //stop if no redirect to sms confirmation
        Assert.assertTrue(isElementNotVisible(signUp.phoneNumberInput), "No redirect to SMS confirmation page.");
        System.out.println("Redirect to SMS confirmation page.");
    }

    @Test
    public void phoneVerificationStep() throws InterruptedException {
        //Phone verification
        signUp = new SignUp();
        Thread.sleep(8000); ///fix this

        PhoneVerification phoneVerification = new PhoneVerification();
        signUp.phoneNumberInput("+" + getProperty("phone"));
        phoneVerification.parsePage();
        Assert.assertTrue(phoneVerification.phoneExists, "Phone has expired! Please contact QA team.");
        signUp.clickConfirmPhoneButton();

        //stop if no redirect to sms confirmation
        Assert.assertTrue(isElementNotVisible(signUp.phoneNumberInput), "No redirect to SMS confirmation page.");
        System.out.println("Redirect to SMS confirmation page.");
        System.out.println("Starting phone verification...");

        phoneVerification.getPhoneVerificationCode();
        String phoneVerificationCode = phoneVerification.phoneVerificationCode;
        signUp.phoneVerificationConfirmInput(phoneVerificationCode.toString());

        //Stop if SMS not received
        Assert.assertTrue(phoneVerification.smsReceived, "No SMS received! Something went wrong. Please contact  QA team. ");
        System.out.println("Phone was confirmed.");
        signUp.clickConfirmPhoneActivationCodeButton();
    }

    @Test
    public void finishSignUpOB(){
        signUp = new SignUp();

        signUp.clickThankYouButton();
        Assert.assertTrue(isElementNotVisible(signUp.thankYouButton), "No redirect to OkThanks screen.");

        signUp.clickOkThanksButton();
        Assert.assertTrue(isElementNotVisible(signUp.okThanksButton), "No redirect to Dashboard.");

        Header header = new Header();
        header.clickProfileMenu();
        waitForElement(header.accountName);

        System.out.printf("Is lastUser present in SessionStorage: ");
        SessionStorage sessionStorage = new SessionStorage(driver);
        System.out.println(sessionStorage.isItemPresentInSessionStorage("app"));

        Assert.assertEquals(header.accountName.getText(), email);
        header.clickProfileMenu();
        System.out.println("Sign Up successful!");
    }

    ///
    ///Sign Up
    ///
    @Test
    public void signUpOB() throws Exception {
        createAccountOB();
        mailVerification();
        phoneInputStep();
        phoneVerificationStep();
        finishSignUpOB();
    }

}
