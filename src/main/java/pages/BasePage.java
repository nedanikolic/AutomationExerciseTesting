package pages;

import factories.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    
    public WebDriver getDriverInstance(){
        return DriverManager.getDriver();
    }

    public void scrollIntoView (By elementBy){
        JavascriptExecutor js = (JavascriptExecutor) getDriverInstance();
        js.executeScript("arguments[0].scrollIntoView(true);", getDriverInstance().findElement(elementBy));
    }

    public boolean waitClickable(By elementBy){
        boolean isClickable = false;
        WebElement element = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elementBy));
        if(element.isEnabled()){
            isClickable = true;
        }
        return isClickable;
    }
    public boolean waitVisible(By elementBy){
        boolean isVisible = false;
        WebElement element = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        if(element.isEnabled()||element.isDisplayed()){
            isVisible = true;
        }
        return isVisible;
    }

public void click(By elementBy){
        scrollIntoView(elementBy);
        waitClickable(elementBy);
        getDriverInstance().findElement(elementBy).click();
}
public void write(By elementBy, String text){
        scrollIntoView(elementBy);
        waitClickable(elementBy);
        getDriverInstance().findElement(elementBy).clear();
        getDriverInstance().findElement(elementBy).sendKeys(text);
}
    public void acceptAlert(){
        Alert alert = getDriverInstance().switchTo().alert();
        alert.accept();

    }
    public void uploadFile(String filePath, By elementBy){
        WebElement upload = getDriverInstance().findElement(elementBy);
        upload.sendKeys(filePath);
    }
    public String getTooltipText(By elementBy) {
        WebElement email = getDriverInstance().findElement(elementBy);
        JavascriptExecutor js = (JavascriptExecutor) getDriverInstance();
        return (String) js.executeScript(
                "return arguments[0].validationMessage;", email);
    }
    public void hoverToElement(By elementBy){
        WebElement element = getDriverInstance().findElement(elementBy);
        Actions actions = new Actions(getDriverInstance());
        actions.moveToElement(element).perform();
    }
    public void selectByValue (By elementBy, String value){
        Select element = new Select(getDriverInstance().findElement(elementBy));
        element.selectByValue(value);
    }
    public void selectByVisibleText(By elementBy, String text){
        Select element = new Select(getDriverInstance().findElement(elementBy));
        element.selectByVisibleText(text);
    }


}
