package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnFormAuthentication() {
        clickOnLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickOnDropDown() {
        clickOnLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickOnHovers() {
        clickOnLink("Hovers");
        return new HoversPage(driver);
    }

    public AdditionalKeysPage clickKeyPresses() {
        clickOnLink("Key Presses");
        return new AdditionalKeysPage(driver);
    }

    public AdditionalKeysPage clickOnHorizontalSlider() {
        clickOnLink("Horizontal Slider");
        return new AdditionalKeysPage(driver);
    }

    public AlertsPage clickOnAlertsPage() {
        clickOnLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickOnFileUpload() {
        clickOnLink("File Upload");
        return new FileUploadPage(driver);
    }

    public WysiwygEditorPage clickOnWysiwygEditor() {
        clickOnLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickOnFramesPage() {
        clickOnLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickOnDynamicLoading() {
        clickOnLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    /**
     * When we create another link for each page, we'll need to create another method.
     * However, if there were (eg. 45) links when we ran that test to see how many links there were.
     * And that could get really long. This is where we start designing your class to be a little-bit flexible.
     * Instead of creating links for each one, they're all going to follow the same pattern.
     * They're going to have some text, and this is going to be the variable.
     *
     * @param linkText
     */
    public void clickOnLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
