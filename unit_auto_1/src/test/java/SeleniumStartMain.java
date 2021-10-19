import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumStartMain {
    public static WebDriver driver;

    @BeforeAll
    public static void start() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void findElementById() {
        var explicitWait = new WebDriverWait(driver, 20);
        explicitWait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button")));
        WebElement loginDialog = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        loginDialog.click();
        var waiter = new WebDriverWait(driver, 10);
        WebElement inputLogin = driver.findElement(By.id("auth_email"));
        var test = waiter.until(ExpectedConditions.visibilityOf(inputLogin));
        inputLogin.sendKeys("nix-login");
        Assertions.assertEquals("login", inputLogin.getAttribute("formcontrolname"));
        WebElement inputPassword = driver.findElement(By.id("auth_pass"));
        inputPassword.sendKeys("nix-Password");
        Assertions.assertEquals("password", inputPassword.getAttribute("formcontrolname"));
        var waitClose = new WebDriverWait(driver, 20);
        WebElement closeDialog = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[1]/button"));
        waitClose.until(ExpectedConditions.elementToBeClickable(closeDialog));
        closeDialog.click();
    }

    @Test
    @Order(2)
    public void findAllImages() {
        List<WebElement> findImg = driver.findElements(By.tagName("img"));
        System.out.println(findImg.size());
        Assertions.assertEquals(findImg.size(), findImg.size());
    }

    @Test
    @Order(3)
    public void findFullText() {
        WebElement findFullText = driver.findElement(By.partialLinkText("Канцтовари"));//Канцтовари
        System.out.println(findFullText.getText());
        findFullText.click();
        Assertions.assertEquals("Канцтовари та книги", findFullText.getText());
    }

    @Test
    @Order(4)
    public void findByXpath() {
        var goodWait = new WebDriverWait(driver, 20);
        goodWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[2]/section/ul/li[1]/rz-list-tile/div/ul/li[1]/a")));
        WebElement goods = driver
                .findElement(By.xpath("/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[2]/section/ul/li[1]/rz-list-tile/div/ul/li[1]/a"));
        goods.click();
        var waitAllImages = new WebDriverWait(driver, 20);
        waitAllImages.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
        WebElement title = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-category/div/main/div[1]/div/h1"));
        Assertions.assertEquals("Калькулятори", title.getText());
    }

    @Test
    @Order(5)
    public void findInput() {
        WebElement findInput = driver.findElement(By.cssSelector("input[name='search']"));
        findInput.sendKeys("test findInput");
        var findInputWait = new WebDriverWait(driver, 10);
        findInputWait.until(ExpectedConditions.textToBePresentInElementValue(findInput, "test findInput"));
        Assertions.assertEquals("search", findInput.getAttribute("name"));
        findInput.clear();
    }

    @Test
    @Order(6)
    public void findByClassName() {
        WebElement findByClassName = driver.findElement(By.cssSelector("input.search-form__input.ng-valid.ng-touched.ng-dirty"));
        findByClassName.sendKeys("new text findByClassName");
        var findByClassNameWait = new WebDriverWait(driver, 10);
        findByClassNameWait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(findByClassName, "test")),
                ExpectedConditions.visibilityOf(findByClassName)));
        findByClassName.clear();
        Assertions.assertEquals("search", findByClassName.getAttribute("name"));
    }

    @Test
    @Order(7)
    public void findByAttribute() {
        WebElement login = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        login.click();
        var findByAttributeWaite = new WebDriverWait(driver, 20);
        WebElement findByAttribute = driver.findElement(By.xpath("//div/input[@id='auth_email']"));
        findByAttributeWaite.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(findByAttribute)));
        findByAttribute.sendKeys("test");
        Assertions.assertEquals("login", findByAttribute.getAttribute("formcontrolname"));
        WebElement closeLogin = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[1]/button"));
        closeLogin.click();
    }

    @Test
    @Order(8)
    public void changedLanguage() {
        WebElement text = driver.findElement(By.xpath("//*[text()=' RU ']"));
        text.click();
        WebElement language = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[1]/rz-lang/ul/li[1]/span"));
        Assertions.assertEquals("lang__link lang__link--active ng-star-inserted", language.getAttribute("class"));
    }

    @Test
    @Order(9)
    public void addToBasket() {
        WebElement addToBasket = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/section/rz-grid/ul/li[2]/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button"));
        addToBasket.click();
        var addingWaite = new WebDriverWait(driver, 20);
        addingWaite.until(ExpectedConditions.attributeToBe(addToBasket, "aria-label", "В корзине"));
        Assertions.assertEquals("В корзине", addToBasket.getAttribute("aria-label"));
    }

    @Test
    @Order(10)
    public void removeFromBasket() {
        WebElement basketButton = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/section/rz-grid/ul/li[2]/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button"));
        basketButton.click();
        WebElement basketAction = driver.findElement(By.id("cartProductActions0"));
        basketAction.click();
        WebElement remove = driver.findElement(By.xpath("//*[text()=' Удалить ']"));
        remove.click();
        var addingWaite = new WebDriverWait(driver, 20);
        addingWaite.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/rz-shopping-cart/div/div[1]/h4")));
        WebElement message = driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/rz-shopping-cart/div/div[1]/h4"));
        Assertions.assertEquals("Корзина пуста", message.getText());
    }

    @AfterAll
    public static void closeDriver() {
        driver.close();
    }
}