package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;

public class BaseTest {
    private WebDriver driver;
    //    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
//        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver.register(new EventReporter());

        driver.get("https://the-internet.herokuapp.com/");
        // eg. for window maximization
        driver.manage().window().maximize();
        // eg. for mobile screen size maximization
//        driver.manage().window().setSize(new Dimension(375,812));
        homePage = new HomePage(driver);
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
}
