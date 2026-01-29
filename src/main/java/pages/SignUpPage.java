package pages;

import models.UserData;
import org.openqa.selenium.By;
import org.testng.Assert;


public class SignUpPage extends BasePage{

    private final By nameFieldBy = By.xpath("//input[@type='text']");
    private final By emailAddressFieldBy = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButtonBy = By.xpath("//button[@data-qa='signup-button']");
    private final By titleButtonBy = By.id("id_gender2");
    private final By passwordBy = By.id("password");
    private final By dayDropdownBy = By.id("days");
    private final By monthDropdownBy = By.id("months");
    private final By yearDropdownBy = By.id("years");
    private final By firstNameFieldBy = By.id("first_name");
    private final By lastNameFieldBy = By.id("last_name");
    private final By addressFieldBy = By.id("address1");
    private final By countryDropdownBy = By.id("country");
    private final By stateFieldBy = By.id("state");
    private final By cityFieldBy = By.id("city");
    private final By zipcodeFieldBy = By.id("zipcode");
    private final By mobileNumberFieldBy = By.id("mobile_number");
    private final By createAccountButtonBy = By.xpath("//button[@type='submit']");
    private final By continueButtonBy = By.cssSelector(".btn.btn-primary");
    private final By errorMessageBySignInWithExistingEmail= By.xpath("//p[normalize-space()='Email Address already exist!']");


public void signUpWithNewCredentials(UserData user){
    write(nameFieldBy,user.randomNameLoginPage);
    write(emailAddressFieldBy,user.randomEmail);
    click(signUpButtonBy);
    click(titleButtonBy);
    write(passwordBy,user.password);
    selectByValue(dayDropdownBy,"15");
    selectByVisibleText(monthDropdownBy,"August");
    selectByValue(yearDropdownBy,"1992");
    write(firstNameFieldBy,user.firstName);
    write(lastNameFieldBy,user.lastName);
    write(addressFieldBy,user.address);
    selectByVisibleText(countryDropdownBy,"Canada");
    write(stateFieldBy,user.state);
    write(cityFieldBy,user.city);
    write(zipcodeFieldBy,user.zipCode);
    write(mobileNumberFieldBy,user.mobilePhone);
    click(createAccountButtonBy);
    click(continueButtonBy);
}

public void signUpWithExistingCredentials(String signupName, String email){
    write(nameFieldBy,signupName);
    write(emailAddressFieldBy,email);
    click(signUpButtonBy);
}
public void verifyUserCannotSignInWithExistingCredentials(){
    Assert.assertTrue(waitVisible(errorMessageBySignInWithExistingEmail));
}


}
