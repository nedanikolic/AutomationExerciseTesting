package tests.ui;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import tests.BaseTest;

public class LogOutTest extends BaseTest {
    private LogOutTest(){}
    LoginPage loginPage = new LoginPage();
    HeaderPage headerPage = new HeaderPage();
    @Test
    public void logOut() {
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("email"), properties.getValue("password") );
        headerPage.logOut();
        headerPage.verifyUserIsLoggedOut();




    }

}
