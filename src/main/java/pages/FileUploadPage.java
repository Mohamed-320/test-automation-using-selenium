package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUploadButton() {
        driver.findElement(uploadButton).click();
    }

    /**
     * Provides path of the file to the form then click upload button
     *
     * @param absolutePathOfTheFile the full path of  the file need to be uploaded
     */
    public void uploadFile(String absolutePathOfTheFile) {
        driver.findElement(inputField).sendKeys(absolutePathOfTheFile);
        clickOnUploadButton();
    }

    public String getUploadedFiles(){
        return driver.findElement(uploadedFiles).getText();
    }
}
