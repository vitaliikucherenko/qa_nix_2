import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "data-provider-login")
    public static Object[][] dataProviderLogin() {
        return new Object[][]{{"login1", "Pass1"}, {"log2", "Pass2"}};
    }

    @DataProvider(name = "data-provider-count-in-basket")
    public static Object[][] dataProviderCountInBasket() {
        return new Object[][]{{"5"}, {"7"}, {"10"}};
    }
}
