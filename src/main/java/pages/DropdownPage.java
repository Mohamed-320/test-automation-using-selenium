package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropDown(String dropdownOption) {
        findDropdownElement().selectByVisibleText(dropdownOption);
    }

    /**
     * this method is created to return all the selected options so the test can make sure that only thing selected
     * is what it's expecting to be selected.
     *
     * @return
     */
    public List<String> getSelectedDropdownOptions() {
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        /* Inside the created Map Lambda expression is passed. so,for every element that's inside the list,
        we want to take this action, and once you get the text from every element, I want you to collect all of
        those into a new List and that will be a List of Strings.
         */
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    /**
     * A private method here is created fo not repeating the same thing for every method because any method
     * in here that will be created later on is going to have to work with this dropdown.
     * So, this one will be private — it's not for my test to access, it's just a little helper method for me.
     *
     * @return this Select and we'll call this findDropDownElements and return the new Select instance.
     */
    private Select findDropdownElement() {
        return new Select(driver.findElement(dropdown));
    }
}
