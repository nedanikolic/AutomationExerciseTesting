package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public final By loginEmailFieldBy = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordFieldBy = By.xpath("//input[@data-qa='login-password']");
    private final By loginButtonBy = By.xpath("//button[@data-qa='login-button']");
    private final By errorMessageIncorrectEmailOrPassword = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");


    public void login(String email, String password){
        write(loginEmailFieldBy,email);
        write(loginPasswordFieldBy,password);
        click(loginButtonBy);
    }
    public void verifyErrorMessageForInvalidEmail(){
        String validationMessage = getTooltipText(loginEmailFieldBy);
        Assert.assertTrue(validationMessage.contains("@"));
    }
    public void verifyErrorMessageWithUnregisteredCredentials(){
        Assert.assertTrue(waitVisible(errorMessageIncorrectEmailOrPassword));
    }









}

