package WebTests;

import Driver.MainMethods;
import Services.GetLastBlock;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by qovtunov on 14/11/2017.
 */
public class TEST extends MainMethods {

    String operationSystem = System.getProperty("os.name").toLowerCase();

    File dir = new File("src");

    File driverChromeWin = new File(dir, "chromedriver.exe");
    File driverChromeLinux = new File(dir, "chromedriverLinux64");
    File driverChromeMac = new File(dir, "chromedriverMac");


    @BeforeSuite(groups = {"Chrome"})                       // РАЗОБРАТЬСЯ - ЗАПУСК ДЛЯ ВСЕХ ГРУП

    public void DriverChrome() throws IOException {
        System.out.println(("[TEST STARTED]"));
        System.out.println(("OS: " + operationSystem));
        if (operationSystem.contains("win")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeWin));
        } else if (operationSystem.contains("nux") || operationSystem.contains("nix")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeLinux));
        } else if (operationSystem.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeMac));
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.navigate().to("https://bogdan:ultvjbnjrbyscerf@staging.gdetokiny.cc/");
    }

    @Test
    public void test() throws AWTException, InterruptedException, IOException, MessagingException {

        GetLastBlock getLastBlock = new GetLastBlock();
        getLastBlock.getLastBlock();

        /*MailVerification mailVerification = new MailVerification();
        mailVerification.deleteAllMessages();*/

        /*String user = "bogdan";
        String password = "ultvjbnjrbyscerf";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //UsernamePasswordCredentials upc = new UsernamePasswordCredentials("httpwatch", "password");
        //UserAndPassword upc = new UserAndPassword("httpwatch", "password");
        driver.switchTo().alert().authenticateUsing(new UserAndPassword(user, password)); //not released yet*/

        //System.out.println(new UserData().uniqueAccount);

        /*String emailCode = getEmailQuerry.emailQuerry;
        System.out.println(emailCode);*/



        /*String anim= "|/-\\";
        for (int x =0 ; x < 100 ; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(1000);
        }*/



        /*String user = "bogdan";
        String password = "ultvjbnjrbyscerf";
        Thread.sleep(3000);
        driver.switchTo().alert().authenticateUsing(new UserAndPassword(user, password)); //authenticateUsing(new UserAndPassword(user, password));*/


        /*aa.sendKeys("bogdan");
        Robot a = new Robot();
        a.keyPress(KeyEvent.VK_ENTER);

        Alert bb = driver.switchTo().alert();
        bb.sendKeys("ultvjbnjrbyscerf");
        a.keyPress(KeyEvent.VK_ENTER);*/


    }
}


