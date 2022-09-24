package base.frames;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WysiwygEditorPage;

public class FramesTest extends BaseTest {
    SoftAssert softAssert;
    WysiwygEditorPage wysiwygEditorPage;

    @Test
    public void testWysiwyg() {
        softAssert = new SoftAssert();
        wysiwygEditorPage = homePage.clickOnWysiwygEditor();
        wysiwygEditorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndention();
        wysiwygEditorPage.setTextArea(text2);
        softAssert.assertEquals(wysiwygEditorPage.getTextFromEditor(), text1 + text2,
                "Text from editor is incorrect");
    }
}
