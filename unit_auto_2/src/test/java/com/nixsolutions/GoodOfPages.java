package com.nixsolutions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoodOfPages {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(tagName = "img")
    private List<WebElement> findImg;
    @FindBy(partialLinkText = "Канцтовари")
    private WebElement findFullText;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[2]/section/ul/li[1]/rz-list-tile/div/ul/li[1]/a")
    WebElement goods;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-category/div/main/div[1]/div/h1")
    WebElement title;
    @FindBy(css = "input[name='search']")
    WebElement findInput;
    @FindBy(css = "input.search-form__input.ng-valid.ng-touched.ng-dirty")
    WebElement findByClassName;
    @FindBy(xpath = "//div/input[@id='auth_email']")
    WebElement findByAttribute;
    @FindBy(xpath = "//*[text()=' RU ']")
    WebElement changeLanguage;


    public GoodOfPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
    }

    public void findAllImages() {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfAllElements(findImg)));
        System.out.println(findImg.size());
        Assertions.assertEquals(findImg.size(), findImg.size());
    }

    public void findFullText() {
        System.out.println(findFullText.getText());
        findFullText.click();
        Assertions.assertEquals("Канцтовари та книги", findFullText.getText());
    }

    public void findByXpath() {
        this.wait.until(ExpectedConditions.visibilityOf(goods));
        goods.click();
        this.wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfAllElements(findImg)));
        Assertions.assertEquals("Калькулятори", title.getText());
    }

    public void findInput(String searchText) {
        findInput.sendKeys(searchText);
        this.wait.until(ExpectedConditions.textToBePresentInElementValue(findInput, searchText));
        Assertions.assertEquals("search", findInput.getAttribute("name"));
        findInput.clear();
    }

    public void findByClassName(String searchText) {
        findByClassName.sendKeys(searchText);
        this.wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(findByClassName, "test")),
                ExpectedConditions.visibilityOf(findByClassName)));
        Assertions.assertEquals("search", findByClassName.getAttribute("name"));
        findByClassName.clear();
    }

    public void findByAttribute(String testText) {
        LogInPopUp logInPopUp = PageFactory.initElements(driver, LogInPopUp.class);
        logInPopUp.openPage();
        this.wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(findByAttribute)));
        findByAttribute.sendKeys(testText);
        Assertions.assertEquals("login", findByAttribute.getAttribute("formcontrolname"));
        logInPopUp.closeLogin();
    }

    public void changedLanguage() {
        changeLanguage.click();
        WebElement language = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[1]/rz-lang/ul/li[1]/span"));
        Assertions.assertEquals("lang__link lang__link--active ng-star-inserted", language.getAttribute("class"));
    }
}
