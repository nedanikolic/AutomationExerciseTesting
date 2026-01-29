package pages;

import org.openqa.selenium.By;
import org.testng.Assert;


public class HeaderPage extends BasePage{

    private final By signupLoginButtonBy = By.xpath("//a[@href='/login']");
    private final By logOutButtonBy = By.xpath("//a[contains(text(),'Logout')]");
    private final By productListButtonBy = By.xpath("//a[@href='/products']");
    private final By contactUsButtonBy = By.xpath("//a[@href='/contact_us']");
    private final By deleteAccountButtonBy = By.cssSelector(".fa.fa-trash-o");
    private final By messageAccountDeletedBy = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private final By viewCartButtonBy = By.xpath("//a[@href='/view_cart']");



    public void clickSignUpLogin(){
        click(signupLoginButtonBy);
    }
    public void verifyUserIsLoggedIn(){
        Assert.assertTrue(waitClickable(logOutButtonBy));
    }
    public void verifyUserIsLoggedOut(){
        Assert.assertTrue(waitClickable(signupLoginButtonBy),"User is not logged in.");
    }
    public void logOut(){
        click(logOutButtonBy);
        waitClickable(signupLoginButtonBy);
    }
    public void clickOnPLButton(){
            click(productListButtonBy);
    }
    public void clickOnContactUsButton(){
        waitClickable(contactUsButtonBy);
        click(contactUsButtonBy);
    }
    public void deleteAccount(){
        waitClickable(deleteAccountButtonBy);
        click(deleteAccountButtonBy);
    }
    public void verifyAccountIsDeleted(){
        Assert.assertTrue(waitVisible(messageAccountDeletedBy));
    }
    public void clickOnCartButton(){
        click(viewCartButtonBy);
    }
    public void verifyUserIsRegistered(){
        Assert.assertTrue(waitClickable(logOutButtonBy));
        Assert.assertTrue(waitClickable(deleteAccountButtonBy));
    }
}
