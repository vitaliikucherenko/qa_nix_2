import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class seleniumStartMain {
    @Test

    public void firstSeleniumTest() throws InterruptedException {
        //findElementById
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
        driver.manage().window().maximize();
        var explicitWait = new WebDriverWait(driver, 20);
        explicitWait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button")));
        WebElement loginDialog = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        loginDialog.click();
        var waiter = new WebDriverWait(driver, 10);
        WebElement inputLogin = driver.findElement(By.id("auth_email"));
        var test = waiter.until(ExpectedConditions.visibilityOf(inputLogin));
        inputLogin.sendKeys("nix-login");
        WebElement inputPassword = driver.findElement(By.id("auth_pass"));
        inputPassword.sendKeys("nix-Password");
        var waitClose = new WebDriverWait(driver, 20);
        WebElement closeDialog = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[1]/button"));
        waitClose.until(ExpectedConditions.elementToBeClickable(closeDialog));
        //Thread.sleep(2000);
        closeDialog.click();
        //find all images
        List<WebElement> findImg = driver.findElements(By.tagName("img"));
        System.out.println(findImg.size());
        WebElement findFullText = driver.findElement(By.partialLinkText("Канцтовари"));//Канцтовари
        System.out.println(findFullText.getText());
        findFullText.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        var goodWait = new WebDriverWait(driver, 20);
        goodWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[2]/section/ul/li[1]/rz-list-tile/div/ul/li[1]/a")));
        WebElement goods = driver
                .findElement(By.xpath("/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[2]/section/ul/li[1]/rz-list-tile/div/ul/li[1]/a"));
        goods.click();
        var waitAllImages = new WebDriverWait(driver, 20);
        waitAllImages.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));

        WebElement findInput = driver.findElement(By.cssSelector("input[name='search']"));
        findInput.sendKeys("test findInput");
        // Thread.sleep(2000);
        var findInputWait = new WebDriverWait(driver, 10);
        findInputWait.until(ExpectedConditions.textToBePresentInElementValue(findInput, "test findInput"));
        findInput.clear();

        WebElement findByClassName = driver.findElement(By.cssSelector("input.search-form__input.ng-valid.ng-touched.ng-dirty"));
        findByClassName.sendKeys("new text findByClassName");
        //Thread.sleep(2000);
        var findByClassNameWait = new WebDriverWait(driver, 10);
        findByClassNameWait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(findByClassName, "test")),
                ExpectedConditions.visibilityOf(findByClassName)));
        findByClassName.clear();

        WebElement login = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        login.click();
        var findByAttributeWaite = new WebDriverWait(driver, 20);
        WebElement findByAttribute = driver.findElement(By.xpath("//div/input[@id='auth_email']"));
        findByAttributeWaite.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(findByAttribute)));
        findByAttribute.sendKeys("test");
        //Thread.sleep(2000);
        WebElement closeLogin = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[1]/button"));
        closeLogin.click();
//changed language
        WebElement text = driver.findElement(By.xpath("//*[text()=' RU ']"));
        text.click();
        driver.close();
    }
}