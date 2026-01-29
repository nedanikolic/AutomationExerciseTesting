package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends BasePage{
    private final By messageCartIsEmptyBy = By.xpath("//*[text()='Cart is empty!']");
    private final By removeButtonBy = By.cssSelector(".cart_quantity_delete");
    private final By placeOrderButtonBy = By.xpath("//a[contains(text(),'Place Order')]");
    private final By proceedToCheckOutButtonBy = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By deleteProductButtonBy= By.xpath("//a[@class='cart_quantity_delete']");


    public void removeProductFromCart(){
        waitClickable(removeButtonBy);
        click(removeButtonBy);
    }

    public void verifyCartIsEmpty(){
        Assert.assertTrue(waitVisible(messageCartIsEmptyBy));
    }
    public void placeTheOrder(){
        waitClickable(proceedToCheckOutButtonBy);
        click(proceedToCheckOutButtonBy);
        scrollIntoView(placeOrderButtonBy);
        click(placeOrderButtonBy);
    }
    public void placeTheOrderNotLoggedIn(){
        waitClickable(proceedToCheckOutButtonBy);
        click(proceedToCheckOutButtonBy);
    }
    public void verifyCartIsNotEmptyAfterLoginOrRegister(){
        Assert.assertTrue(waitClickable(deleteProductButtonBy));
    }
}
