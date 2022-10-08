package base.frames;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.NestedFramesPage;

public class NestedFramesTest extends BaseTest {
    SoftAssert softAssert;
    NestedFramesPage nestedFramesPage;

    @Test
    public void nestedFramesTest() {
        softAssert = new SoftAssert();
         nestedFramesPage = homePage.clickOnFramesPage().clickOnNestedFrames();
        softAssert.assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT",
                "Left frame text incorrect");
        softAssert.assertEquals(nestedFramesPage.getTheBottomFrameText(),
                "BOTTOM", "Bottom frame text incorrect");
        softAssert.assertAll();
    }
}
