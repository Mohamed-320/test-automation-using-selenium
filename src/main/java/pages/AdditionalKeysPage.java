package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AdditionalKeysPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");
    private By sliderValue = By.id("range");
    private By slider = By.cssSelector(".sliderContainer input");

    public AdditionalKeysPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(inputField).sendKeys(text);
    }

    // chord is used to click on multiple keys in the same time [eg. to enter pi symbol, click on Alt+P]
    public void enterPi() {
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    public String getResult() {
        return driver.findElement(resultText).getText();
    }

    public void setSliderValue(String value) {
        while (!getSliderValue().equals(value)) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }
}
