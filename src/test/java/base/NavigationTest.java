package base;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DynamicLoadingFirstExamplePage;
import pages.DynamicLoadingPage;


public class NavigationTest extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;
    DynamicLoadingFirstExamplePage dynamicLoadingFirstExamplePage;

    @Test
    public void applicationNavigationTest() {
        SoftAssert softAssert = new SoftAssert();
        dynamicLoadingPage = homePage.clickOnDynamicLoading();
        dynamicLoadingFirstExamplePage = dynamicLoadingPage.clickOnFirstExample();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goTo("https://google.com");
        softAssert.assertAll();
    }
}
