package base.additionalkeys;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdditionalKeysPage;

public class AdditionalKeysTest extends BaseTest {
    SoftAssert softAssert;
    AdditionalKeysPage additionalKeysPage;

    @Test
    public void backspaceKetTest() {
        softAssert = new SoftAssert();
        additionalKeysPage = homePage.clickKeyPresses();
        additionalKeysPage.enterText("A" + Keys.BACK_SPACE);
        softAssert.assertEquals(additionalKeysPage.getResult(), "You entered: BACK_SPACE",
                "Wrong key pressed message is displayed!");
        softAssert.assertAll();
    }

    @Test
    public void piSymbolTest() {
        additionalKeysPage = homePage.clickKeyPresses();
        additionalKeysPage.enterPi();
    }
}
