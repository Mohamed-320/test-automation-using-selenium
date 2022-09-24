package base.alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTest {
    SoftAssert softAssert;
    FileUploadPage fileUploadPage;

    @Test
    public void fileUploadTest() {
        softAssert = new SoftAssert();
        fileUploadPage = homePage.clickOnFileUpload();
        fileUploadPage.uploadFile
                ("F:\\test-automation-using-selenium\\resources\\UIUXandDesignThinking.pdf");
        softAssert.assertEquals(fileUploadPage.getUploadedFiles(), "UIUXandDesignThinking.pdf",
                "Incorrect File is Uploaded!");
        softAssert.assertAll();
    }
}
