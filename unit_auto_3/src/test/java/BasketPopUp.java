import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;

public class BasketPopUp {
    SoftAssert assertTest = new SoftAssert();

    public void addToBasket(String text) {
        SelenideElement addGood = $(By.xpath("//button[@class = 'buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"))
                .should(Condition.exist, Condition.visible);
        addGood.click();
        assertTest.assertEquals($(By.className("modal__heading")).should(Condition.appear).getText(), "Корзина");
        SelenideElement goodIsAdded = $(By.xpath("//a[@class = 'cart-product__title']"));
        assertTest.assertEquals(goodIsAdded.getAttribute("title").trim(), text);
        assertTest.assertAll();
    }

    public void removeFromBasket() {
        SelenideElement cartProductActions = $(By.xpath("//button[@id='cartProductActions0']")).should(Condition.visible);
        cartProductActions.click();
        SelenideElement remove = $(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")).should(Condition.visible);
        remove.click();
        SelenideElement message = $(By.xpath("//h4[@class='cart-dummy__heading']")).should(Condition.visible);
        assertTest.assertEquals("Корзина пуста", message.getText());
    }

    public void amountInBasket(String value) {
        SelenideElement amountValue = $(By.xpath("//*[@class='cart-product__price']")).shouldBe(Condition.visible, Condition.enabled);
        Double amount = Double.parseDouble(amountValue.getText().replaceAll("[^0-9]+", ""));
        SelenideElement countValue = $(By.xpath("//*[@class='cart-counter__input ng-untouched ng-pristine ng-valid']")).should(Condition.visible);
        countValue.setValue(value);
        int count = Integer.parseInt(Objects.requireNonNull(countValue.getAttribute("value")));
        Double sum = count * amount;
        SelenideElement totalAmount = $(By.xpath("//*[@class='cart-receipt__sum-price']")).should(Condition.visible);
        Double total = Double.parseDouble(totalAmount.getText().replaceAll("[^0-9]+", ""));
        assertTest.assertEquals(sum, total);
    }

    public void orderForm() {
        SelenideElement zakazOrderButton = $(By.xpath("//*[@class = 'button button_size_large button_color_green cart-receipt__submit ng-star-inserted']")).should(Condition.enabled);
        zakazOrderButton.click();
        SelenideElement title = $(By.xpath("//*[@class = 'checkout-heading ng-star-inserted']")).should(Condition.visible);
        assertTest.assertEquals(title.getText(), "Оформление заказа");
    }

    public void orderFormValidation() {
        SelenideElement zakazOrderButton = $(By.xpath("//*[@class = 'button button_size_large button_color_green cart-receipt__submit ng-star-inserted']")).should(Condition.enabled);
        zakazOrderButton.click();
        SelenideElement enterButton = $(By.xpath("//*[@class = 'button button--green button--large checkout-total__submit ng-untouched ng-pristine ng-valid']")).should(Condition.enabled);
        enterButton.click();
        SelenideElement lastName = $(By.xpath("//*[@class = 'form__row js-surname validation_type_error']//*[@class='validation-message ng-star-inserted']")).should(Condition.visible);
        SelenideElement firstName = $(By.xpath("//*[@class = 'form__row js-name validation_type_error']//*[@class='validation-message ng-star-inserted']")).should(Condition.visible);
        SelenideElement phone = $(By.xpath("//*[@class = 'form__row js-phone validation_type_error']//*[@class='validation-message ng-star-inserted']")).should(Condition.visible);
        assertTest.assertEquals(lastName.getText(), "Введите свою фамилию на кириллице");
        assertTest.assertEquals(firstName.getText(), "Введите свое имя на кириллице");
        assertTest.assertEquals(phone.getText(), "Введите номер мобильного телефона");
        assertTest.assertAll();
    }
}
