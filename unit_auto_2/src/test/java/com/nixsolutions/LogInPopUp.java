package com.nixsolutions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPopUp {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "auth_email")
    private WebElement loginField;
    @FindBy(id = "auth_pass")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/app-root/single-modal-window/div[2]/div[1]/button")
    WebElement closeLogin;

    public LogInPopUp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
    }

    public void logIn(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        Assertions.assertEquals("login", loginField.getAttribute("formcontrolname"));
        Assertions.assertEquals("password", passwordField.getAttribute("formcontrolname"));

    }

    public void openPage() {
        this.wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button")));
        WebElement loginDialog = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        loginDialog.click();
        Assertions.assertEquals("Вхід", driver.findElement(By.xpath("/html/body/app-root/single-modal-window/div[2]/div[1]/h3")).getText());

    }

    public void closeLogin(){
        closeLogin.click();
        Assertions.assertEquals("Інтернет-магазин Rozetka.ua - №1",driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/a")).getAttribute("title"));
    }
}
