package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;

public class BaseTest {
    private WebDriver driver;
    //    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
//        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver.register(new EventReporter());

        driver.get("https://the-internet.herokuapp.com/");
        // eg. for window maximization
        driver.manage().window().maximize();
        // eg. for mobile screen size maximization
//        driver.manage().window().setSize(new Dimension(375,812));
        homePage = new HomePage(driver);
        setCookie();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void captureScreenPhoto(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Taken Screenshot Path: " + screenshot.getAbsolutePath());
//        try {
//            Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        }
    }

    // Driver Extras
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(true);
        return options;
    }

    private void setCookie() {
        /**
         *         The builder takes a name and a value for the cookie.
         *         For our cookies name, let's just call it “test”, and the value, we'll say “123”.
         *         since it's a Builder we can do a . and continue building on.
         *
         *         We can say go ahead and set the domain of this and a domain needs to be the website
         *         that we're actually storing this cookie for.
         */
        Cookie cookie = new Cookie.Builder("test", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }
}
