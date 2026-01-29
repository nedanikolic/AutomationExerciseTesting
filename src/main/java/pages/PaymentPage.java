package pages;

import org.openqa.selenium.By;
import org.testng.Assert;


public class PaymentPage extends BasePage{

    private final By nameOnCardFieldBy = By.name("name_on_card");
    private final By cardNumberFieldBy= By.name("card_number");
    private final By cvcFieldBy = By.name("cvc");
    private final By expiryMonthFieldBy = By.name("expiry_month");
    private final By expiryYearFieldBy = By.name("expiry_year");
    private final By payAndConfirmOrderButtonBy = By.id("submit");
    private final By messageOrderPlacedBy = By.xpath("//b[contains(text(),'Order Placed!')]");

    public void fillOutThePaymentForm(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear){
        write(nameOnCardFieldBy,nameOnCard);
        write(cardNumberFieldBy,cardNumber);
        write(cvcFieldBy,cvc);
        write(expiryMonthFieldBy,expiryMonth);
        write(expiryYearFieldBy,expiryYear);
        click(payAndConfirmOrderButtonBy);
    }
    public void verifyOrderIsPlaced(){
        Assert.assertTrue(waitVisible(messageOrderPlacedBy));
    }
}
