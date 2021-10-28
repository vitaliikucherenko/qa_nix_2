import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;

public class SelenideMain extends BaseTest {
    LogInPopUp logInPopUp = new LogInPopUp();
    BasketPopUp basketPopUp = new BasketPopUp();
    SearchGoods searchGoods = new SearchGoods();
    SoftAssert assertTest = new SoftAssert();

    @Test(invocationCount = 2,groups = "validation")
    public void verificationOfGoodInBasket() {
        searchGoods.selectSection();
        SelenideElement good1 = $(By.xpath("//span[@class = 'goods-tile__title' and text() =' Компьютер Cobra I11.8.H1S2.165.101 ']")).should(Condition.exist);
        String text = good1.getText().trim();
        good1.click();
        basketPopUp.addToBasket(text);
    }

    @Test(groups = "validation")
    public void removeFromBasket() {
        searchGoods.selectSection();
        SelenideElement good1 = $(By.xpath("//span[@class = 'goods-tile__title' and text() =' Компьютер Cobra I11.8.H1S2.165.101 ']")).should(Condition.exist);
        String text = good1.getText().trim();
        good1.click();
        basketPopUp.addToBasket(text);
        basketPopUp.removeFromBasket();
    }

    @Test(dataProvider = "data-provider-count-in-basket", dataProviderClass = DataProviderClass.class, groups = "validation")
    public void verificationAmountInBasket(String count) {
        searchGoods.selectSection();
        SelenideElement good1 = $(By.xpath("//span[@class = 'goods-tile__title' and text() =' Компьютер Cobra I11.8.H1S2.165.101 ']")).should(Condition.exist);
        String text = good1.getText().trim();
        good1.click();
        basketPopUp.addToBasket(text);
        basketPopUp.amountInBasket(count);
    }

    @Test(dataProvider = "data-provider-login", dataProviderClass = DataProviderClass.class, groups = "validation")
    public void verificationLogInFieldsIsEditable(String login, String password) {
        logInPopUp.LogIn(login, password);
    }

    @Test (groups = {"validation"})
    public void verificationTitleOfLogInFields() {
        logInPopUp.titleOfLoginFields();
    }

    @Test (groups = "validation")
    public void validationLogInPopUpLoginField() {
        logInPopUp.validationLoginField();
    }

    @Test(groups = "validation")
    public void validationLogInPopUpPasswordField() {
        logInPopUp.validationPasswordField();
    }

    @Test(groups = "validation")
    public void verificationRegisterPopUpFieldsIsEditable() {
        logInPopUp.registerPopUp("FistName", "LastName", "44 455 54 54", "test@nix.com", "Password");
    }

    @Test(groups = "validation")
    public void verificationTitleOfRegisterFields() {
        logInPopUp.titleOfRegisterFields();
    }

    @Test(groups = "validation")
    public void validationRegisterFields() {
        logInPopUp.validationOfRegisterFields();
    }

    @Test(groups = "validation")
    public void searchOfGood() {
        searchGoods.search("Asus");
    }

    @Test(groups = "validation")
    public void setFilters() {
        searchGoods.search("Asus");
        searchGoods.setFilters();
    }

    @Test(groups = "validation")
    public void SelectGood() {
        searchGoods.search("Asus");
        SelenideElement select = $(By.xpath("//*[@class='goods-tile__title']")).should(Condition.visible);
        String s = select.getText();
        select.click();
        SelenideElement good1 = $(By.xpath("//*[@class = 'product__title']")).should(Condition.exist);
        String text = good1.getText().trim();
        assertTest.assertEquals(text, s);
    }

    @Test(groups = "validation")
    public void orderForm() {
        searchGoods.search("Lg");
        SelenideElement select = $(By.xpath("//*[@class='goods-tile__title']")).should(Condition.visible);
        select.click();
        SelenideElement addGood = $(By.xpath("//button[@class = 'buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"))
                .should(Condition.exist, Condition.visible);
        addGood.click();
        basketPopUp.orderForm();
    }

    @Test(groups = "validation")
    public void orderFormValidation() {
        searchGoods.search("Lg");
        SelenideElement select = $(By.xpath("//*[@class='goods-tile__title']")).should(Condition.visible);
        select.click();
        SelenideElement addGood = $(By.xpath("//button[@class = 'buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"))
                .should(Condition.exist, Condition.visible);
        addGood.click();
        basketPopUp.orderFormValidation();
    }
}
