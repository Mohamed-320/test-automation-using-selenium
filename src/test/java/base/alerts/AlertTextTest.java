package base.alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AlertsPage;

public class AlertTextTest extends BaseTest {
    SoftAssert softAssert;
    AlertsPage alertsPage;

    @Test
    public void getAlertTextTest() {
        softAssert = new SoftAssert();
        alertsPage = homePage.clickOnAlertsPage();
        alertsPage.triggerConfirm();
        String alertText = alertsPage.getAlertText();
        alertsPage.clickToDismissConfirm();
        softAssert.assertEquals(alertText, "I am a JS Confirm",
                "The Alert Text is Not Correct!");
        softAssert.assertAll();
    }
}
