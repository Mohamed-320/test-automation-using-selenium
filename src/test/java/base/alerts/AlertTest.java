package base.alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AlertsPage;

public class AlertTest extends BaseTest {
    SoftAssert softAssert;
    AlertsPage alertsPage;

    @Test
    public void acceptAlertTest() {
        softAssert = new SoftAssert();
        alertsPage = homePage.clickOnAlertsPage();
        alertsPage.triggerAlert();
        alertsPage.clickToAcceptAlert();
        softAssert.assertEquals(alertsPage.getResult(), "You successfully clicked an alert",
                "The Alert Message is Not Correct!");
        softAssert.assertAll();
    }
}
