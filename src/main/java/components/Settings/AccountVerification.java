package Components.Settings;

import Driver.MainMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountVerification extends MainMethods {



    @FindBy(xpath = "//label[contains(text(),'First Name')]/following-sibling::input")
    public WebElement firstName;

    @FindBy(xpath = "//label[contains(text(),'Last Name')]/following-sibling::input")
    public WebElement lastName;

    @FindBy(xpath = "//label[contains(text(),'Date')]/following-sibling::input")
    public WebElement birthDate;

    @FindBy(xpath = "//label[contains(text(),'Country')]/following-sibling::div/div/span/div[2]/input")
    public WebElement country;

    @FindBy(xpath = "//label[contains(text(),'City')]/following-sibling::input")
    public WebElement city;

    @FindBy(xpath = "//label[contains(text(),'State')]/following-sibling::input")
    public WebElement state;

    @FindBy(xpath = "//label[contains(text(),'ZIP')]/following-sibling::input")
    public WebElement zipCode;

    @FindBy(xpath = "//label[contains(text(),'Street')]/following-sibling::input")
    public WebElement street;

    @FindBy(xpath = "//label[contains(text(),'Building')]/following-sibling::input")
    public WebElement building;

    @FindBy(xpath = "//label[contains(text(),'Apartment')]/following-sibling::input")
    public WebElement apartment;

    @FindBy(xpath = "//label[contains(text(),'Identification number')]/following-sibling::input")
    public WebElement idNumber;

    @FindBy(xpath = "//label[contains(text(),'Country of')]/following-sibling::div/div/span/div[2]/input")
    public WebElement countryOfIssuance;

    @FindBy(xpath = "//div[@class='Verification__dropdown-row__information-text']")
    public WebElement hintBox;

    //@FindBy(xpath = "//span[contains(text(),'Select document')]/parent::h4")
    @FindBy(xpath = "//div[@class='Selector']")
    public WebElement selectDocumentType;

    @FindBy(xpath = "//h4[contains(text(),'Passport')]/parent::li")
    public WebElement selectDocumentPassport;

    @FindBy(xpath = "//h4[contains(text(),'Driving')]/parent::li")
    public WebElement selectDocumentDL;

    @FindBy(xpath = "//span[@class='icon']/parent::div/parent::div")
    public WebElement getUploadDocumentArea;

    @FindBy(xpath = "//span[contains(text(),'Browse')]")
    public WebElement uploadDocumentButton;

    @FindBy(xpath = "//span[contains(text(),'Submit')]/parent::button")
    public WebElement submitButton;

    @FindBy(xpath = "//input[contains(concat(' ', @type, ' '), ' file ')]")
    public WebElement uploadDocumentInput;

    @FindBy(css = ".file-name")
    public WebElement uploadedDocument;

    @FindBy(xpath = "//div[@class = 'VerificationStatus']/h4/span")
    public WebElement verificationStatus;

    public AccountVerification() {
        PageFactory.initElements(driver, this);
    }


    public void kycInputData(String firstName, String lastName, String birthDate,
                             String country, String city, String state, String zipCode,
                             String street, String building, String appartment,
                             String idNumber, String countryOfIssuance) {
        inputDataFieldClear(this.firstName, firstName);
        inputDataFieldClear(this.lastName, lastName);
        inputDataField(this.birthDate, birthDate);
        fillDropdown(this.country, country);
        inputDataField(this.city, city);
        inputDataField(this.state, state);
        inputDataField(this.zipCode, zipCode);
        inputDataField(this.street, street);
        inputDataField(this.building, building);
        inputDataField(this.apartment, appartment);
        inputDataField(this.idNumber, idNumber);
        fillDropdown(this.countryOfIssuance, countryOfIssuance);
    }

    public void clickSelectDocumentType() {
        moveToElement(hintBox);
        hoverOverElement(selectDocumentType);
        clickElement(selectDocumentType);
    }

    public void clickSelectDocumentPassport() {
        clickElement(selectDocumentPassport);
    }

    public void clickSelectDocumentDL() { clickElement(selectDocumentDL);}

    public void uploadDocument(String fileName) {
        moveToElement(uploadDocumentInput);
        uploadFile(fileName, uploadDocumentInput);
    }

    public void clickSubmitButton() {
        moveToElement(submitButton);
        clickElement(submitButton);
    }
}

//