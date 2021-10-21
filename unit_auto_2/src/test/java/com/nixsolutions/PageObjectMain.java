package com.nixsolutions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PageObjectMain {
    WebDriver driver;
    LogInPopUp logInPopUp;
    GoodOfPages goodOfPages;
    BasketPopUp basketPopUp;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void findElementById() {
        logInPopUp = PageFactory.initElements(driver, LogInPopUp.class);
        logInPopUp.openPage();
        logInPopUp.logIn("test", "test");
        logInPopUp.closeLogin();
    }

    @Test
    @Order(2)
    public void testTwo() {
        goodOfPages=PageFactory.initElements(driver,GoodOfPages.class);
        basketPopUp=PageFactory.initElements(driver,BasketPopUp.class);
        goodOfPages.findAllImages();
        goodOfPages.findFullText();
        goodOfPages.findByXpath();
        goodOfPages.findInput("search text");
        goodOfPages.findByClassName("new search text");
        goodOfPages.findByAttribute("test_user_login");
        goodOfPages.changedLanguage();
        basketPopUp.addToBasket();
        basketPopUp.removeFromBasket();

    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

}
