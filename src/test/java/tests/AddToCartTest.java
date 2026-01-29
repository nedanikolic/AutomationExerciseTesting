package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductListPage;

public class AddToCartTest extends BaseTest{
    private AddToCartTest (){}
    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();
    ProductListPage productListPage = new ProductListPage();
    CartPage cartPage = new CartPage();

    @Test
    public void addToCart(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("email"), properties.getValue("password") );
        headerPage.clickOnPLButton();
        productListPage.addItemToCart();
        productListPage.verifyAddToCartConfirmationMessage();
    }

    @Test
    public void emptyCart(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("email"), properties.getValue("password") );
        headerPage.clickOnPLButton();
        productListPage.addItemToCart();
        productListPage.clickOnViewCartInModal();
        cartPage.removeProductFromCart();
        cartPage.verifyCartIsEmpty();
    }

}
