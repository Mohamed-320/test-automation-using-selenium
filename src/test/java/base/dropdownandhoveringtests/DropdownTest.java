package base.dropdownandhoveringtests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DropdownPage;

import java.util.List;

public class DropdownTest extends BaseTest {
    SoftAssert softAssert;
    DropdownPage dropdownPage;

    @Test
    public void testDropdownSelectedOptions() {
        String firstOption = "Option 1";
        softAssert = new SoftAssert();
        dropdownPage = homePage.clickOnDropDown();
        dropdownPage.selectFromDropDown(firstOption);
        List<String> selectedOptions = dropdownPage.getSelectedDropdownOptions();
        softAssert.assertEquals(selectedOptions.size(), 1,
                "Incorrect Number of The Selected Dropdown Options!");
        softAssert.assertTrue(selectedOptions.contains(firstOption), "First dropdown option is not selected!");
        softAssert.assertAll();
    }
}
