package tests;

import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HeaderPage;
import utils.FileUtils;

import java.io.IOException;

public class ContactFormTest extends BaseTest{
    private ContactFormTest (){}
    HeaderPage headerPage = new HeaderPage();
    ContactPage contactPage = new ContactPage();

    @Test
    public void submitContactInformation() throws IOException {
        headerPage.clickOnContactUsButton();
        String filePath = FileUtils.createTestFile();
        contactPage.writeContactName(properties.getValue("contactName"));
        contactPage.writeContactEmail(properties.getValue("email"));
        contactPage.writeSubject(properties.getValue("subject"));
        contactPage.writeMessage(properties.getValue("message"));
        contactPage.uploadFileInContactForm(filePath);
        contactPage.clickOnSubmit();
        contactPage.acceptAlertInContactForm();
        contactPage.verifyFormIsSubmitted();
    }

    @Test
    public void submitInvalidContactEmail() throws IOException {
        headerPage.clickOnContactUsButton();
        contactPage.writeContactName(properties.getValue("contactName"));
        contactPage.writeContactEmail(properties.getValue("invalidEmail"));
        contactPage.clickOnSubmit();
        contactPage.verifyErrorMessageInContactFormForInvalidEmail();


    }
}
