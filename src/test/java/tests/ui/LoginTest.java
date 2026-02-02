package tests.ui;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import tests.BaseTest;

public class LoginTest extends BaseTest {
    private LoginTest (){}

    LoginPage loginPage = new LoginPage();
    HeaderPage headerPage = new HeaderPage();

    @Test
    public void loginWithValidCredentials(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("email"), properties.getValue("password") );
        headerPage.verifyUserIsLoggedIn();
    }

    @Test()
    public void loginWithUnregisteredCredentials(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("unregisteredEmail"),
                properties.getValue("unregisteredPassword") );
        loginPage.verifyErrorMessageWithUnregisteredCredentials();
    }

    @Test
    public void loginWithUnregisteredPassword(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("email"),
                properties.getValue("unregisteredPassword") );
        loginPage.verifyErrorMessageWithUnregisteredCredentials();
    }

    @Test
    public void loginWithUnregisteredEmail(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("unregisteredEmail"),
                properties.getValue("password") );
       loginPage.verifyErrorMessageWithUnregisteredCredentials();
    }

    @Test
    public void loginWithInvalidEmail(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("invalidEmail"),
                properties.getValue("password") );
        loginPage.verifyErrorMessageForInvalidEmail();
    }
}
