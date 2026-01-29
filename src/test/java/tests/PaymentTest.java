package tests;


import org.testng.annotations.Test;
import pages.*;


public class PaymentTest extends BaseTest{
    private PaymentTest(){}

    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();
    ProductListPage productListPage = new ProductListPage();
    PaymentPage paymentPage = new PaymentPage();
    CartPage cartPage = new CartPage();

    @Test
    public void proceedWithPayment(){
        headerPage.clickSignUpLogin();
        loginPage.login(properties.getValue("email"), properties.getValue("password") );
        headerPage.clickOnPLButton();
        productListPage.addItemToCart();
        productListPage.clickOnViewCartInModal();
        cartPage.placeTheOrder();
        paymentPage.fillOutThePaymentForm(properties.getValue("nameOnCard"),properties.getValue("cardNumber"),
                properties.getValue("cvc"),properties.getValue("expiryMonth"),properties.getValue("expiryYear"));
        paymentPage.verifyOrderIsPlaced();
    }

    @Test
    public void placeTheOrderWithoutLoggingIn(){
        headerPage.clickOnPLButton();
        productListPage.addItemToCart();
        productListPage.clickOnViewCartInModal();
        cartPage.placeTheOrderNotLoggedIn();
        productListPage.verifyUserMustLoginOrRegisterToPlaceTheOrder();
    }

    @Test
    public void verifyIfGuestCartPersistsWhenUserLogIn(){
        placeTheOrderWithoutLoggingIn();
        productListPage.clickOnTheRegisterLoginButton();
        loginPage.login(properties.getValue("email"), properties.getValue("password") );
        headerPage.verifyUserIsLoggedIn();
        headerPage.clickOnCartButton();
        cartPage.verifyCartIsNotEmptyAfterLoginOrRegister();
    }
}
