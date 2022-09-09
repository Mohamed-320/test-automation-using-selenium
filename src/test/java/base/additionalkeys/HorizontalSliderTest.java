package base.additionalkeys;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdditionalKeysPage;

public class HorizontalSliderTest extends BaseTest {
    SoftAssert softAssert;
    AdditionalKeysPage additionalKeysPage;

    /**
     * Horizontal Slider Task Description
     * <p>
     * Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left.
     * Or click and drag the slider with your mouse. It will indicate the value of the slider to the right.
     * You're going to sendKeys to this slider until it gets to the number 4. And then you'll verify that
     * this text actually equals 4.
     * To actually move this slider, you'll just need to send some arrow keys to the slider itself.
     * So, send enough of those arrow keys to get to the number 4.
     */
    @Test
    public void testSlideToWholeNumber() {
        String requiredSliderValue = "4";
        softAssert = new SoftAssert();
        additionalKeysPage = homePage.clickOnHorizontalSlider();
        additionalKeysPage.setSliderValue(requiredSliderValue);
        softAssert.assertEquals(additionalKeysPage.getSliderValue(), requiredSliderValue,
                "Slider value is incorrect!");
        softAssert.assertAll();
    }
}
