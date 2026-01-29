package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductListPage extends BasePage{

    private final By productItem1By = By.cssSelector(".product-image-wrapper");
    private final By addToCartButtonBy =  By.cssSelector(".product-overlay .add-to-cart");;
    private final By messageAddedBy = By.cssSelector(".modal-title.w-100");
    private final By productSearchFieldBy = By.id("search_product");
    private final By submitSearchButtonBy = By.id("submit_search");
    private final By productItemBy = By.xpath("//p[contains(text(),'Sleeveless Dress')]");
    private final By checkoutMessageUnhappyPathBy = By.xpath("//p[contains(text(),'Register / Login account to proceed on checkout.')]");
    private final By registerOrLoginButtonBy = By.xpath("//u[contains(text(),'Register / Login')]");
    private final By viewCartInModalBy = By.xpath("//u[contains(text(),'View Cart')]");



    public void addItemToCart(){
        scrollIntoView(productItem1By);
        hoverToElement(productItem1By);
        click(addToCartButtonBy);
    }
    public void verifyAddToCartConfirmationMessage(){
        Assert.assertTrue(waitVisible(messageAddedBy));
    }

    public void clickOnViewCartInModal(){
        waitClickable(viewCartInModalBy);
        click(viewCartInModalBy);

    }

    public void verifyUserMustLoginOrRegisterToPlaceTheOrder(){
        Assert.assertTrue(waitVisible(checkoutMessageUnhappyPathBy));
        Assert.assertTrue(waitClickable(registerOrLoginButtonBy));
    }
    public void clickOnTheRegisterLoginButton(){
        click(registerOrLoginButtonBy);
    }
    public void productSearch(String product){
        write(productSearchFieldBy,product);
        click(submitSearchButtonBy);
    }
    public void verifyProductIsFound(){
        Assert.assertTrue(waitVisible(productItemBy));
    }

}
