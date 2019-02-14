package Components.Settings;

import Driver.MainMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings extends MainMethods {


    @FindBy(xpath = "//span[contains(text(),'Account Verification')]/parent::a")
    public WebElement accountVerificationButton;

    @FindBy(xpath = "//span[contains(text(),'Account Settings')]/parent::a")
    public WebElement accountSettingsButton;

    public Settings() {
        PageFactory.initElements(driver, this);
    }

    public void clickAccountVerificationButton() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, -250);");
        clickElement(accountVerificationButton);
    }
}
