package base.logintests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    SoftAssert softAssert;

    @Test
    public void testLogin() {
        softAssert = new SoftAssert();
        loginPage = homePage.clickOnFormAuthentication();
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        secureAreaPage = loginPage.clickOnLoginButton();
        softAssert.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!")
                , "Alert message is incorrect");
        softAssert.assertAll();
    }
}
