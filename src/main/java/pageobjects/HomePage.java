package pageobjects;

import driverutils.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
   WebDriver driver;
    Action action;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action= new Action();  }

    /**
     * SearchPage Locators
     */

   @FindBy(css = "button[id = 'onetrust-accept-btn-handler']")
    private WebElement acceptAllCookies;

    @FindBy(css = "ul[role='tablist'] [data-industryname='Financial Services ']")
    private WebElement FinancialServicesTab;


    /**
     * SearchPage Actions
     */
    public boolean isElementPresentAndClickable(String linkName){

        WebElement ElementToClick = driver.findElement(By.partialLinkText(linkName));

        if(action.isDisplayed(ElementToClick)) {
            return action.isEnabled(ElementToClick);
        }
        else{
            return false;
        }
    }

    public void clickElement(String linkName) {
        driver.findElement(By.partialLinkText(linkName)).click();
    }

    public void clickFinancialServicesUnderChooseYourIndustry()
    {
        FinancialServicesTab.click();
    }
    public boolean isElementPresentAndClickable2(String linkName){

        WebElement ElementToClick = driver.findElement(By.cssSelector("[href='/financial-services/" + linkName +"']"));

        if(action.isDisplayed(ElementToClick)) {
            return action.isEnabled(ElementToClick);
        }
        else{
            return false;
        }
    }

    public void acceptAllCookies() throws InterruptedException {
        action.isEnabled(acceptAllCookies);
        action.click(acceptAllCookies);
    }
}

