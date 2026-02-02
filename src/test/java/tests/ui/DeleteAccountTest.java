package tests.ui;

import models.UserData;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.SignUpPage;
import factories.UserFactory;
import tests.BaseTest;

public class DeleteAccountTest extends BaseTest {
    private DeleteAccountTest(){}
    SignUpPage signUpPage = new SignUpPage();
    HeaderPage headerPage = new HeaderPage();

    @Test
    public void deleteAccount(){
        headerPage.clickSignUpLogin();
        UserData newUser = UserFactory.createRandomUser();
        signUpPage.signUpWithNewCredentials(newUser);
        headerPage.deleteAccount();
        headerPage.verifyAccountIsDeleted();
    }
}
