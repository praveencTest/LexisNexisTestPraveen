package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import reporting.ExtentManager;
import utils.Logging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    static Logging log;

    @BeforeSuite
    public void loadConfig() {
       ExtentManager.setExtent();

        //Load properties file
        try {
            prop = new Properties();
            log.info("Super constructor invoked");
            if (driver == null) {
                FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
                prop.load(fip);
            }
            System.out.println("driver :" + driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void launchApp() {

        String browserName = prop.getProperty("browser");

        if (browserName.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities dc = new DesiredCapabilities();

            //Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1200x600"); // To accept cookies
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--safebrowsing-disable-download-protection");
            options.addArguments("safebrowsing-disable-extension-blacklist");
            options.addArguments("disable-infobars");

            //Chrome capabilities
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            dc.setCapability(ChromeOptions.CAPABILITY, options);

            //Open new browser window
            driver = new ChromeDriver();

            //Delete cookies
            driver.manage().deleteAllCookies();

            //Maximise the window
            driver.manage().window().maximize();

            //Open Evri website
            driver.get(prop.getProperty("url"));
            log.info("Opening lexisnexis website on Chrome browser");

        } else if (browserName.contains("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browserName.contains("IE")) {
            WebDriverManager.iedriver().setup();
        }
        //Set implicit wait and page load timeouts
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("defaultimplicitwaittime")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageWait")), TimeUnit.SECONDS);

    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDown() throws IOException {
        //End reporter session
        ExtentManager.endReport();

        //End drier session
        if(driver!= null)
            driver.quit();
        log.info("Quit browser");
    }
}
