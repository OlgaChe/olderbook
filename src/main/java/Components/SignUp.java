package Components;

import Driver.MainMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SignUp extends MainMethods{

    @FindBy(xpath = "//label[contains(text(),'Email')]/following-sibling::input")
    public WebElement emailInput;

    @FindBy(xpath = "//label[contains(text(),'Date of birth')]/following-sibling::input")
    public WebElement birthDateInput;

    @FindBy(xpath = "//label[contains(text(),'Password')]/following-sibling::input")
    public WebElement passwordInput;

    @FindBy(xpath = "//label[contains(text(),'Confirm password')]/following-sibling::input")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//label[contains(text(),'First Name')]/following-sibling::input")
    public WebElement firstNameInput;

    @FindBy(xpath = "//label[contains(text(),'Last Name')]/following-sibling::input")
    public WebElement lastNameInput;

    @FindBy(xpath = "//label[contains(text(),'Country')]/following-sibling::div/div/span/div[2]/input")
    public WebElement countryInput;

    @FindBy(xpath= "(//input[@value='on'])[1]")
    public WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "(//div[contains(@class,'SignUpForm__agreement-checkbox')]/input)[2]")
    public WebElement privacyPolicyCheckbox;

    @FindBy(xpath ="//div[contains(concat(' ', @class, ' '), ' SignUpForm__agreement ')]/div[3]/input")
    public WebElement thirdPartyCheckbox;

    @FindBy(xpath ="//div[contains(concat(' ', @class, ' '), ' SignUpForm__agreement ')]/div[4]/input")
    public WebElement promotionalCheckbox;

    @FindBy(className = "SignUpForm__signUpButton")
    public WebElement signUpButton;

    //Account activation
    @FindBy(xpath = "//label[contains(text(),'Please enter your activation code:')]/following-sibling::input")
    public WebElement activationCodeInput;

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' SignUpForm__row signUpRow ')]/button")
    public WebElement confirmEmailButton;

    //Phone verification
    @FindBy(xpath = "//input[contains(concat(' ', @type, ' '), ' tel ')]")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' SignUpForm__row SignUpForm__btn__row ')]/button")
    public WebElement confirmPhoneButton;

    @FindBy(xpath = "//input[contains(concat(' ', @type, ' '), ' number ')]")
    public  WebElement phoneVerificationConfirmInput;

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' SignUpForm__row ')]/button")
    public  WebElement confirmPhoneActivationCodeButton;

    @FindBy(xpath = "//span[contains(text(),'Thank You')]/parent::button")
    public  WebElement thankYouButton;

    @FindBy(xpath = "//span[contains(text(),'Thanks')]/parent::button")
    public WebElement okThanksButton;


    public SignUp() {
        PageFactory.initElements(driver, this);
    }

    public void signUpInput(String email, String birthDate, String password, String confirmPassword, String firstName, String lastName) {
        inputDataField(emailInput, email);
        //birthDateInput.click();
        //birthDateInput.sendKeys(Keys.DELETE);
        inputDataField(birthDateInput, birthDate);
        inputDataField(passwordInput, password);
        inputDataField(confirmPasswordInput, confirmPassword);
        inputDataField(firstNameInput, firstName);
        inputDataField(lastNameInput, lastName);
        //inputDataField(countryInput, country);
    }

    public void checkSignUpTerms() {
        checkCheckbox(termsOfServiceCheckbox);
        checkCheckbox(privacyPolicyCheckbox);
        //clickElement(thirdPartyCheckbox);
        //clickElement(promotionalCheckbox);
    }

    public void clickCountryDrop(String country) {
        fillDropdown(countryInput, country);
    }

    public void clickSignUpButton() {
        clickElement(signUpButton);
    }

    //Account activation
    public void activationCodeInput(String activationCode) {
        inputDataField(activationCodeInput, activationCode);
    }

    public void clickConfirmEmailButton() {
        clickElement(confirmEmailButton);
    }

    //Phone verification
    public  void phoneNumberInput(String phoneNumber) {
        waitForElement(phoneNumberInput);
        phoneNumberInput.clear();
        inputDataField(phoneNumberInput, phoneNumber);
    }

    public void clickConfirmPhoneButton() {
        clickElement(confirmPhoneButton);
    }

    public void phoneVerificationConfirmInput(String phoneVerificationCode) {
        inputDataField(phoneVerificationConfirmInput, phoneVerificationCode);
    }

    public void  clickConfirmPhoneActivationCodeButton() {
        clickElement(confirmPhoneActivationCodeButton);
    }

    public void clickThankYouButton() {
        clickElement(thankYouButton);
    }

    public void clickOkThanksButton() {
        clickElement(okThanksButton);
    }







}
