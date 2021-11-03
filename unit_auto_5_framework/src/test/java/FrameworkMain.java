import authenticationPages.LogInPopUp;
import configBaseTest.BaseTest;
import dataProvider.DataProviderClass;
import org.testng.annotations.Test;


public class FrameworkMain extends BaseTest {

    LogInPopUp logInPopUp = new LogInPopUp();

    @Test(dataProvider = "data-provider-login", dataProviderClass = DataProviderClass.class, groups = "authentication")
    public void verificationLogInFieldsIsEditable(String login, String password) {
        logInPopUp.LogIn(login, password);
    }

    @Test (groups = "authentication")
    public void verificationTitleOfLogInFields() {
        logInPopUp.titleOfLoginFields();
    }

    @Test (groups = "authentication")
    public void validationLogInPopUpLoginField() {
        logInPopUp.validationLoginField();
    }

    @Test(groups = "authentication")
    public void validationLogInPopUpPasswordField() {
        logInPopUp.validationPasswordField();
    }

    @Test(groups = "authentication")
    public void verificationRegisterPopUpFieldsIsEditable() {
        logInPopUp.registerPopUp("FistName", "LastName", "44 455 54 54", "test@nix.com", "Password");
    }

    @Test(groups = "authentication")
    public void verificationTitleOfRegisterFields() {
        logInPopUp.titleOfRegisterFields();
    }

    @Test(groups = "authentication")
    public void validationRegisterFields() {
        logInPopUp.validationOfRegisterFields();
    }

  }
