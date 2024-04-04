package verifyElements;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePage;
import utils.Logging;


public class ChooseYourIndustrySection extends BaseClass {

    private HomePage hp;
    private boolean success;
    private Logging log;

    @BeforeClass
    public void setUp() {
        //Instantiate pages
        hp = new HomePage(driver);
    }

    @Test
    public void verifyLinksUnderChooseYourIndustrySection() throws InterruptedException {
        //Test case started
        log.startTestCase("check elements present under tab - Choose Your Indurstry");

        //Accept cookies on the search page
        hp.acceptAllCookies();
        log.info("Cookies accepted successfully");

        //Open FinancialService section under Choose Your Industry tab
        hp.clickElement("Choose Your Industry");
        hp.clickFinancialServicesUnderChooseYourIndustry();

        //Click on Choose Your Industry tab
        success = hp.isElementPresentAndClickable2("financial-crime-compliance");
        Assert.assertTrue(success, "financial-crime-compliance Element is not enabled for clicking");
        log.info("financial-crime-compliance link is present and clickable");

        success = hp.isElementPresentAndClickable2("fraud-and-identity-management");
        Assert.assertTrue(success, "fraud-and-identity-management Element is not enabled for clicking");
        log.info("fraud-and-identity-management link is present and clickable");

        success = hp.isElementPresentAndClickable2("customer-data-management");
        Assert.assertTrue(success, "customer-data-management Element is not enabled for clicking");
        log.info("customer-data-management link is present and clickable");

        success = hp.isElementPresentAndClickable2("credit-risk-assessment");
        Assert.assertTrue(success, "credit-risk-assessment Element is not enabled for clicking");
        log.info("credit-risk-assessment link is present and clickable");

        success = hp.isElementPresentAndClickable2("collections-and-recovery");
        Assert.assertTrue(success, "collections-and-recovery Element is not enabled for clicking");
        log.info("collections-and-recovery link is present and clickable");

        success = hp.isElementPresentAndClickable2("tracing-and-investigations");
        Assert.assertTrue(success, "tracing-and-investigations Element is not enabled for clicking");
        log.info("tracing-and-investigations(Investigations and Due Diligence) link is present and clickable");

        //End of test case
        log.endTestCase("Ended ChooseYourIndustrySection");

    }
}
/*public class ChooseYourIndustrySection extends BaseClass {
    private HomePage hp;
    private boolean success;
    private Logging log;

    @BeforeClass
    public void setUp() {

        //Instantiate pages
        hp = new HomePage(driver);
    }

    @Test
    public void ChooseYourIndustrySection() throws Throwable {

        //Test case started
        log.startTestCase("check elements present under tab - Choose Your Indurstry");

        //Accept cookies on the search page
        hp.acceptAllCookies();
        log.info("Cookies accepted successfully");

        //Open FinancialService section under Choose Your Industry tab
        hp.clickElement("Choose Your Industry");
        hp.clickFinancialServicesUnderChooseYourIndustry();

        //Click on Choose Your Industry tab
        success = hp.isElementPresentAndClickable2("financial-crime-compliance");
        Assert.assertTrue(success, "financial-crime-compliance Element is not enabled for clicking");
        log.info("financial-crime-compliance link is present and clickable");

        success = hp.isElementPresentAndClickable2("fraud-and-identity-management");
        Assert.assertTrue(success, "fraud-and-identity-management Element is not enabled for clicking");
        log.info("fraud-and-identity-management link is present and clickable");

        success = hp.isElementPresentAndClickable2("customer-data-management");
        Assert.assertTrue(success, "customer-data-management Element is not enabled for clicking");
        log.info("customer-data-management link is present and clickable");

        success = hp.isElementPresentAndClickable2("credit-risk-assessment");
        Assert.assertTrue(success, "credit-risk-assessment Element is not enabled for clicking");
        log.info("credit-risk-assessment link is present and clickable");

        success = hp.isElementPresentAndClickable2("collections-and-recovery");
        Assert.assertTrue(success, "collections-and-recovery Element is not enabled for clicking");
        log.info("collections-and-recovery link is present and clickable");

        success = hp.isElementPresentAndClickable2("tracing-and-investigations");
        Assert.assertTrue(success, "tracing-and-investigations Element is not enabled for clicking");
        log.info("tracing-and-investigations(Investigations and Due Diligence) link is present and clickable");

        //End of test case
        log.endTestCase("Ended ChooseYourIndustrySection");
    }
}*/
