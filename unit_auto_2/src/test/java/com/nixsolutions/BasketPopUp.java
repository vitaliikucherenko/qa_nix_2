package com.nixsolutions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPopUp {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/section/rz-grid/ul/li[2]/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button")
    WebElement addToBasket;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/section/rz-grid/ul/li[2]/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button")
    WebElement basketButton;
    @FindBy(id = "cartProductActions0")
    WebElement basketAction;
    @FindBy(xpath = "//*[text()=' Удалить ']")
    WebElement remove;
    @FindBy(xpath = "/html/body/app-root/single-modal-window/div[2]/div[2]/rz-shopping-cart/div/div[1]/h4")
    WebElement message;

    public BasketPopUp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
    }

    public void addToBasket() {
        addToBasket.click();
        this.wait.until(ExpectedConditions.attributeToBe(addToBasket, "aria-label", "В корзине"));
        Assertions.assertEquals("В корзине", addToBasket.getAttribute("aria-label"));
    }

    public void removeFromBasket() {
        basketButton.click();
        basketAction.click();
        remove.click();
        Assertions.assertEquals("Корзина пуста", message.getText());
    }
}
