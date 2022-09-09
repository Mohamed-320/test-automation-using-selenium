package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver webDriver;
    private By figureClass = By.className("figure");
    // instead of doing driver.findElement, which will take it from the top of the DOM,
    // we're going to do figure.findElement, which will find it just from within this element itself.
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.webDriver = driver;
    }


    /**
     * @param index starts at 1, that's why the [index - 1] is passed
     *              <p>
     *              This should move our mouse to that figure, which will cause the hover action to occur.
     *              This alone is not going to do the action because the Actions class uses what's called the builder pattern.
     *              What the builder pattern allows you to do is chain multiple method calls, and then execute them all at once.
     *              So, for this actions, I might want it to do a moveToElement. Then I could do a dot [.] and put any other method
     *              calls I wanted to. Once I've chained together all of the ones that I want, then I can simply call this
     *              perform and then it will execute.
     */
    public FigureCaption hoverOverFigureElement(int index) {
        WebElement figure = webDriver.findElements(figureClass).get(index - 1);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {
        private WebElement figureCaption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        // figure caption constructor
        public FigureCaption(WebElement caption) {
            this.figureCaption = caption;
        }

        public boolean isCaptionDisplayed() {
            return figureCaption.isDisplayed();
        }

        public String getTitle() {
            return figureCaption.findElement(header).getText();
        }

        public String getLink() {
            return figureCaption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return figureCaption.findElement(link).getText();
        }
    }
}
