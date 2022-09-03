package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameTextBox = By.id("username");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public SecureAreaPage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
