package Components;

import Driver.MainMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Trades extends MainMethods{

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' col-centered Spinner ')]")
    public WebElement gipnokrug;

    @FindBy(xpath = "//span[contains(text(),'Market selector')]")
    public WebElement marketSelectorTab;

    @FindBy(xpath = "//div[contains(text(),'OUSD')]/following-sibling::span/following-sibling::div[contains(text(),'ETH')]")
    public WebElement tradePairOusdEth;

    @FindBy(xpath = "//span[contains(text(),'to Buy')]/parent::label/following-sibling::div/input")
    public WebElement amountToBuyInput;

    @FindBy(xpath = "//span[contains(text(),'to Sell')]/parent::label/following-sibling::div/input")
    public WebElement amountToSellInput;

    @FindBy(xpath = "(//span[contains(text(),'Price')]/parent::label/following-sibling::div/input)[1]")
    public WebElement buyPriceInput;

    @FindBy(xpath = "(//span[contains(text(),'Price')]/parent::label/following-sibling::div/input)[2]")
    public WebElement sellPriceInput;

    @FindBy(xpath = "//span[contains(text(),'buy')]/parent::button")
    public WebElement buyButton;

    @FindBy(xpath = "(//span[contains(text(),'sell')]/parent::button)[2]")
    public WebElement sellButton;

    @FindBy(xpath = "(//span[contains(text(),'Incl. Fee')]/parent::dt/following-sibling::dd)[1]")
    public WebElement buyFee;

    @FindBy(xpath = "(//span[contains(text(),'Incl. Fee')]/parent::dt/following-sibling::dd)[4]")
    public WebElement sellFee;

    @FindBy(xpath = "(//span[contains(text(),'Total:')]/parent::dt/following-sibling::dd)[1]")
    public WebElement totalBuy;

    @FindBy(xpath = "(//span[contains(text(),'Total:')]/parent::dt/following-sibling::dd)[2]")
    public WebElement totalBuyUsd;

    @FindBy(xpath = "(//span[contains(text(),'Total:')]/parent::dt/following-sibling::dd)[3]")
    public WebElement totalSell;

    @FindBy(xpath = "(//span[contains(text(),'Total:')]/parent::dt/following-sibling::dd)[4]")
    public WebElement totalSellUsd;

    @FindBy(xpath = "(//span[contains(text(),'Last Price')]/parent::h2//following-sibling::span)[1]")
    public WebElement lastPriceAsset1;

    @FindBy(xpath = "(//span[contains(text(),'Last Price')]/parent::h2//following-sibling::span)[2]")
    public WebElement lastPriceAsset2;


    public Trades() {
        PageFactory.initElements(driver, this);
    }

    public void gipnokrugAbsent(){
        isElementNotVisible(gipnokrug);
    }

    public void clickMarketSelectorTab(){
        clickElement(marketSelectorTab);
    }

    public void clickOUSDETHtradepair(){
        clickElement(tradePairOusdEth);
    }

    public void setAmoutToBuy(String amout){
        inputDataField(amountToBuyInput, amout);
    }

    public void setAmountToSell(String amout){
        inputDataField(amountToSellInput, amout);
    }

    public void setBuyPrice(String price){
        inputDataField(buyPriceInput, price);
    }

    public void setSellPrice(String price){
        inputDataField(sellPriceInput, price);
    }

    public void clickBuyButton(){
        clickElement(buyButton);
    }

    public void clickSellButton(){
        clickElement(sellButton);
    }

    public void whatIsBuyFee(){
        waitForElement(buyFee);
        System.out.println(buyFee.getText());
    }

    public void whatIsSellFee(){
        waitForElement(sellFee);
        System.out.println(sellFee.getText());
    }

    public void whatIsBuyTotal(){
        waitForElement(totalBuy);
        waitForElement(totalBuyUsd);
        System.out.println(totalBuy.getText());
        System.out.println(totalBuyUsd.getText());
    }

    public void whatIsSellTotal(){
        waitForElement(totalSell);
        waitForElement(totalSellUsd);
        System.out.println(totalSell.getText());
        System.out.println(totalSellUsd.getText());
    }

    public void whatIsLastPrice(){
        waitForElement(lastPriceAsset1);
        waitForElement(lastPriceAsset2);
        System.out.println(lastPriceAsset1.getText() + " " + lastPriceAsset2.getText());
    }

}
