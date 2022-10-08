package base;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DynamicLoadingFirstExamplePage;
import pages.DynamicLoadingPage;

public class WaitStrategiesTest extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;
    DynamicLoadingFirstExamplePage dynamicLoadingFirstExamplePage;
    SoftAssert softAssert;

    @Test
    public void waitUntilHiddenTest() {
        softAssert = new SoftAssert();
        dynamicLoadingPage = homePage.clickOnDynamicLoading();
        dynamicLoadingFirstExamplePage = dynamicLoadingPage.clickOnFirstExample();
        dynamicLoadingFirstExamplePage.clickOnStart();
        softAssert.assertEquals(dynamicLoadingFirstExamplePage.getTheLoadedText(),
                "Hello World!", "Loaded text incorrect");
        softAssert.assertAll();
    }
}
