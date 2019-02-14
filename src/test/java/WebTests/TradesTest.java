package WebTests;

import Components.Trades;
import Setup.SetupTestWeb;
import org.testng.annotations.Test;

public class TradesTest extends SetupTestWeb {

    public Trades trades;

    @Test
    public void setOUSDETHmarket(){
        trades = new Trades();
        trades.gipnokrugAbsent();

        trades.clickMarketSelectorTab();
        trades.clickOUSDETHtradepair();
        trades.clickMarketSelectorTab();
        trades.gipnokrugAbsent();

        System.out.println("Trading on OUSD ETH market");

        System.out.println("Last price is:");
        trades.whatIsLastPrice();

        System.out.println("Buy Fee is:");
        trades.whatIsBuyFee();

        System.out.println("Sell Fee is:");
        trades.whatIsSellFee();

    }

    @Test(dependsOnMethods = "setOUSDETHmarket")
    public void testTrade(){
        trades = new Trades();

        trades.setAmoutToBuy("1");
        trades.setBuyPrice("1");
        trades.setAmountToSell("1");
        trades.setSellPrice("1");
        trades.clickBuyButton();
        //trades.clickSellButton();

        System.out.println("Buy total is: ");
        trades.whatIsBuyTotal();

        System.out.println("Sell total is: ");
        trades.whatIsSellTotal();




    }

}
