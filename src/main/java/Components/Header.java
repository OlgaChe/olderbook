package Components;

import Driver.MainMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Header extends MainMethods{

    @FindBy(css = ".header__link.signup-link")
    public WebElement signUpButton;

    @FindBy(css = ".header__link.login-link")
    public WebElement logInButton;

    @FindBy(id = "dropdown-custom-menu")
    public WebElement profileMenu;

    @FindBy(xpath = "//span[contains(concat(' ', @class, ' '), ' email ')]")
    public WebElement accountName;

    @FindBy(xpath = "//a[contains(concat(' ', @class, ' '), ' Menu__logout-text ')]")
    public WebElement logOut;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    public WebElement settingsButton;

    @FindBy (xpath = "//span[contains(text(),'Trade')]")
    public WebElement tradeButton;

    public Header(){

        PageFactory.initElements(driver, this);
    }

    public void clickSignUpButton(){
        clickElement(signUpButton);
    }

    public void clickLogInButton(){
        clickElement(logInButton);
    }

    public void clickProfileMenu(){
        clickElement(profileMenu);
    }

    public void clickLogOut() {
        clickElement(logOut);
    }

    public void clickSettingsButton() {
        clickElement(settingsButton);
    }

    public void clickTradeButton(){clickElement(tradeButton);}


}
