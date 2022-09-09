package base.dropdownandhoveringtests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HoversPage;

public class HoveringTest extends BaseTest {
    SoftAssert softAssert;
    HoversPage hoversPage;
    HoversPage.FigureCaption figuresCaption;

    @Test
    public void testFirstUserHover() {
        softAssert = new SoftAssert();
        hoversPage = homePage.clickOnHovers();
        figuresCaption = hoversPage.hoverOverFigureElement(1);
        softAssert.assertTrue(figuresCaption.isCaptionDisplayed(), "Caption isNot Displayed!");
        softAssert.assertEquals(figuresCaption.getTitle(), "name: user1",
                "Caption Title is Not Correct!");
        softAssert.assertEquals(figuresCaption.getLinkText(), "View profile",
                "Caption Link Text is Not Correct!");
        softAssert.assertTrue(figuresCaption.getLink().endsWith("/users/1"), "Link is incorrect!");
        softAssert.assertAll();
    }
}
