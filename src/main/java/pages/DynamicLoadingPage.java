package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkXpathFormat = ".//a[contains(text(), '%s')]";
    private By firstExampleLink = By.xpath(String.format(linkXpathFormat, "Example 1"));

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicLoadingFirstExamplePage clickOnFirstExample(){
        driver.findElement(firstExampleLink).click();
        return new DynamicLoadingFirstExamplePage(driver);
    }

}
