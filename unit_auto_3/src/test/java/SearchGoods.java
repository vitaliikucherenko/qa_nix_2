import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.$;

public class SearchGoods {
    SoftAssert assertTest = new SoftAssert();

    public void search(String searchData){
        SelenideElement searchField = $(By.xpath("//*[@class='search-form__input ng-untouched ng-pristine ng-valid']")).should(Condition.enabled);
        searchField.sendKeys(searchData);
        SelenideElement searchButton = $(By.xpath("//*[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).should(Condition.visible);
        searchButton.click();
        SelenideElement result = $(By.xpath("//*[@class='catalog-heading ng-star-inserted']")).should(Condition.appear);
        assertTest.assertEquals(result.getText(), "«Asus»");
    }

    public void setFilters(){
        SelenideElement filter1 = $(By.xpath("//*[@class='checkbox-filter__link']//label[@for='Rozetka']")).shouldBe(Condition.visible, Condition.enabled);
        filter1.click();
        SelenideElement maxValueClear = $(By.xpath("//*[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']")).should(Condition.visible);
        maxValueClear.clear();
        SelenideElement maxValueSet = $(By.xpath("//*[@class='slider-filter__inner']//*[@class='slider-filter__input ng-pristine ng-valid ng-touched']")).should(Condition.visible);
        maxValueSet.sendKeys("5000");
        SelenideElement okButton = $(By.xpath("//*[@class='button button_color_gray button_size_small slider-filter__button']")).shouldBe(Condition.enabled);
        okButton.click();
        SelenideElement result = $(By.xpath("//*[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']")).should(Condition.visible);
        assertTest.assertEquals(result.getAttribute("value"), "5000");
    }

    public void selectSection(){
        SelenideElement el1 = $(By.xpath("//a[@class = 'menu-categories__link' and text() = 'Ноутбуки и компьютеры']")).should(Condition.enabled);
        el1.click();
        SelenideElement el2 = $(By.xpath("//a[@class = 'tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and text() = ' Компьютеры ']")).should(Condition.enabled);
        el2.click();
    }
}
