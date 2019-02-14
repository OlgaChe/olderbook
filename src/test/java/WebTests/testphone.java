package WebTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import static Data.ConfigProperties.getProperty;
import static Driver.MainMethods.driver;

public class testphone {
    String operationSystem = System.getProperty("os.name").toLowerCase();

    File dir = new File("src");

    File driverChromeWin = new File(dir, "chromedriver.exe");
    File driverChromeLinux = new File(dir, "chromedriverLinux64");
    File driverChromeMac = new File(dir, "chromedriverMac");

    File driverFFWin = new File(dir, "geckodriver.exe");
    File driverFFLinux = new File(dir, "geckodriverLinux64");
    File driverFFMac = new File(dir, "geckodriverMac");

    File driverIE = new File(dir, "IEDriverServer.exe");


    @BeforeSuite(groups = {"Chrome"})                       // РАЗОБРАТЬСЯ - ЗАПУСК ДЛЯ ВСЕХ ГРУП
    @Parameters("baseUrl")
    public void DriverChrome(String baseUrl) throws IOException {
        System.out.println(("[TEST STARTED]"));
        System.out.println(("OS: "+ operationSystem));
        if (operationSystem.contains("win")){
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeWin));
        }else if (operationSystem.contains("nux") || operationSystem.contains("nix")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeLinux));
        }else if (operationSystem.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeMac));
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.navigate().to(getProperty("https://smsreceivefree.com/info/13042023083/"));
    }
}
