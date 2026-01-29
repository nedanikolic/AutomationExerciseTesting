package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ContactPage extends BasePage{

    private final By contactNameFieldBy = By.name("name");
    public final By contactEmailFieldBy = By.name("email");
    private final By subjectFieldBy = By.name("subject");
    private final By messageFieldBy = By.id("message");
    private final By chooseFileButtonBy = By.name("upload_file");
    private final By submitButtonBy = By.name("submit");
    private final By successMessageBy = By.cssSelector(".status.alert.alert-success");
    private final By messageDetailsSubmittedBy = By.cssSelector(".status.alert.alert-success");


    public void writeContactName(String contactName){
    write(contactNameFieldBy,contactName);
    }
    public void writeContactEmail(String contactEmail){
        write(contactEmailFieldBy,contactEmail);
    }
    public void writeSubject(String subject){
        write(subjectFieldBy,subject);
    }
    public void writeMessage(String message){
        write(messageFieldBy,message);
    }
    public void uploadFileInContactForm(String filePath){
        uploadFile(filePath,chooseFileButtonBy);
    }
    public void clickOnSubmit(){
        click(submitButtonBy);
    }
    public void acceptAlertInContactForm(){
        acceptAlert();
        waitVisible(successMessageBy);
    }
    public void verifyErrorMessageInContactFormForInvalidEmail(){
        String validationMessage = getTooltipText(contactEmailFieldBy);
        Assert.assertTrue(validationMessage.contains("@"));
    }
    public void verifyFormIsSubmitted(){
        Assert.assertTrue(waitVisible(messageDetailsSubmittedBy));
    }




}
