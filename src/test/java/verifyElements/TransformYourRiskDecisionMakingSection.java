package verifyElements;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import utils.Logging;

public class TransformYourRiskDecisionMakingSection extends BaseClass {
    private HomePage hp;
    private boolean success;
    private Logging log;

    @BeforeClass
    public void setUp() {
        //Instantiate pages
        hp = new HomePage(driver);
    }

  @Test
   public void verifyLinksUnderTransformYourRiskDecisionMaking() throws Throwable {
        //Test case started
        log.startTestCase("check elements present under heading - Transform Your Risk Decision Making");

        //Accept cookies on the search page
        hp.acceptAllCookies();
        log.info("Cookies accepted successfully");

        //Click on Login tab
        success = hp.isElementPresentAndClickable("fs");
        Assert.assertTrue(success, "FinancialServices Element is not enabled for clicking");
        log.info("FinancialServices link is present and clickable");

        success = hp.isElementPresentAndClickable("insurance");
        Assert.assertTrue(success, "Insurance Element is not enabled for clicking");
        log.info("Insurance link is present and clickable");

        success = hp.isElementPresentAndClickable("life");
        Assert.assertTrue(success, "LifeAndPensions Element is not enabled for clicking");
        log.info("LifeAndPensions link is present and clickable");

        success = hp.isElementPresentAndClickable("bnp");
        Assert.assertTrue(success, "CorporationsAndNonProfits Element is not enabled for clicking");
        log.info("CorporationsAndNonProfits link is present and clickable");

        //End of test case
        log.endTestCase("Ended TransformYourRiskDecisionMakingSection");
    }
}

