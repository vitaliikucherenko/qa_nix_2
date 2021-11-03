import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

   /* @BeforeMethod
    public void start() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua/");
    }

    @AfterMethod
    public void finish() {
        closeWebDriver();
    }*/

    @BeforeSuite(groups = "validation")
    public void setUp() {
        Configuration.browser = "chrome";
        System.out.println("BeforeSuite - the setup process is completed");
    }

    @BeforeTest(groups = "validation")
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        Configuration.startMaximized = true;
        System.out.println("BeforeTest - the browser setup process is completed");
    }

    @BeforeClass(groups = "validation")
    public void appSetup() {
        System.out.println("BeforeClass - app setup process is completed");
    }

    @BeforeMethod(groups = "validation")
    public void start() {
        open("https://rozetka.com.ua/");
        System.out.println("BeforeMethod - url is opened");
    }

    @AfterMethod(groups = "validation")
    public void screenShot() {
        ScreenShooter.captureSuccessfulTests = false;
        closeWebDriver();
        System.out.println("AfterMethod - Screenshot of the test is taken");
    }

    @AfterClass(groups = "validation")
    public void closeUp() {
        //closeWebDriver();
        System.out.println("AfterClass - The close_up process is completed");
    }

    @AfterTest(groups = "validation")
    public void reportReady() {
        System.out.println("AfterTest - Report is ready to be shared, with screenshots of tests");
    }

    @AfterSuite(groups = "validation")
    public void cleanUp() {
        System.out.println("AfterSuite - All close up activities completed");
    }

    @BeforeGroups(groups = "validation")
    public void before() {
        System.out.println("BeforeGroups - validation test starting");
    }

    @AfterGroups(groups = "validation")
    public void after() {
        System.out.println("AfterGroups - validation test finished");
    }
}
