package driverutils;

import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Action {


    public void click(WebElement ele) {
        ele.click();
    }


    public boolean isEnabled(WebElement ele) {
        return ele.isEnabled();
    }

    public void inputSendKeys(WebElement ele, String keys) {
        ele.sendKeys(keys);
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }


    public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void pageLoadTimeOut(WebDriver driver, int timeOut) {
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
    }

    public String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }

    public String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }

    public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
        }
    }


}
