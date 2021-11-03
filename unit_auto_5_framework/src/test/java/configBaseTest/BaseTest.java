package configBaseTest;

import app.Browser;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    Browser browser = new Browser();

    @BeforeMethod(groups = "authentication")
    public void start() {
        browser.getBrowserType();
        open("https://rozetka.com.ua/");
    }

    @AfterMethod(groups = "authentication")
    public void end() {
        ScreenShooter.captureSuccessfulTests = false;
        closeWebDriver();
        System.out.println("AfterMethod - Screenshot of the test is taken");
    }

    @BeforeGroups(groups = "authentication")
    public void before() {
        System.out.println("BeforeGroups - authentication test starting");
    }

    @AfterGroups(groups = "authentication")
    public void after() {
        System.out.println("AfterGroups - authentication test finished");
    }
}
