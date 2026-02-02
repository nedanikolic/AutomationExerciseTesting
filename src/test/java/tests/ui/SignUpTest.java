package tests.ui;

import models.UserData;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.SignUpPage;
import factories.UserFactory;
import tests.BaseTest;


public class SignUpTest extends BaseTest {
    private SignUpTest(){}

    HeaderPage headerPage = new HeaderPage();
    SignUpPage signUpPage = new SignUpPage();

    @Test
    public void signUpWithNewCredentials (){
        headerPage.clickSignUpLogin();
        UserData newUser = UserFactory.createRandomUser();
        signUpPage.signUpWithNewCredentials(newUser);
        headerPage.verifyUserIsRegistered();
    }
    @Test
    public void signUpWithExistingCredentials(){
        headerPage.clickSignUpLogin();
        signUpPage.signUpWithExistingCredentials(properties.getValue("signupName"),properties.getValue("email"));
        signUpPage.verifyUserCannotSignInWithExistingCredentials();
    }
}
