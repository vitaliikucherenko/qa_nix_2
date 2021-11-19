package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "data-provider-login")
    public static Object[][] dataProviderLogin() {
        return new Object[][]{{"login1", "Pass1"}, {"log2", "Pass2"}};
    }
}
