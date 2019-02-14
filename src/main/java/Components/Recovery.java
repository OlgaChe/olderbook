/*
package Pages;

import Data.ConfigProperties;
import Methods.MainMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends MainMethods {

    @FindBy(xpath = "html/body/div[1]/ion-side-menus/ion-side-menu-content/div/div/ion-content/div/div[1]/div/div/div[3]/div/label[1]/input")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
    public WebElement login;

    @FindBy(xpath = "html/body/div[1]/ion-side-menus/ion-side-menu-content/div/div/ion-content/div/div[1]/div/div/div[3]/div/label[2]/input")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
    public WebElement password;

    @FindBy(xpath = "html/body/div[1]/ion-side-menus/ion-side-menu-content/div/div/ion-content/div/div[1]/div/div/div[4]/div/button")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
    public WebElement signInButton;

    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAToolbar[1]/UIAButton[3]")
    public WebElement doneButton;


    public SignInPage(WebDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void signInInput (WebDriver driver) {
        printTextField(login, ConfigProperties.getProperty("login"), driver);
        printTextField(password, ConfigProperties.getProperty("password"), driver);
    }

    public void clickSignInButton(WebDriver driver) {
        clickElement(signInButton, driver);
    }
}
*/
package Components;

import Driver.MainMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.pagefactory.iOSFindBy;

public class Recovery extends MainMethods {

    @FindBy(xpath = "//label[contains(text(),'Please enter your email address')]/following-sibling::input")
    public WebElement inputEmail;

    @FindBy(xpath = "//span[contains(text(),'Confirm')]/parent::button")
    public WebElement confirmButton;

    @FindBy(xpath = "//span[contains(text(),'Got it')]/parent::button")
    public WebElement gotItButton;

    @FindBy(xpath = "//label[contains(text(),'Please enter new password')]/following-sibling::input")
    public WebElement inputNewPassword;

    @FindBy(xpath = "//label[contains(text(),'Confirm password')]/following-sibling::input")
    public WebElement inputConfirmNewPassword;

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), 'RecoveryForm__smsCode')]/div/input")
    public WebElement inputSMS;

    @FindBy(xpath = "//span[contains(text(),'Thank You')]/parent::button")
    public  WebElement thankYouButton;


    public Recovery() {

        PageFactory.initElements(driver, this);
    }

    public void stepOne(String emailRecovery) {
        inputDataField(inputEmail, emailRecovery);
        clickElement(confirmButton);
    }

    public void stepTwo(){
        clickElement(gotItButton);
    }

    public void stepThree(String newPassword){
        inputDataField(inputNewPassword, newPassword);
        inputDataField(inputConfirmNewPassword, newPassword);
        clickElement(confirmButton);
    }

    public void stepFour (String SMS){
        inputDataField(inputSMS, SMS);
        clickElement(confirmButton);
    }

    public void stepFive(){
        clickElement(thankYouButton);
    }



}

