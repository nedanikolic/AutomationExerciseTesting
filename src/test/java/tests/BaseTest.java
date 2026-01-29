package tests;

import factories.DriverFactory;
import factories.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;


public class BaseTest {
    protected BaseTest (){}
    protected PropertiesReader properties;


    @BeforeMethod
    public void configure() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        DriverManager.setDriver(driver);
        properties = PropertiesReader.getInstance("src/main/resources/config.properties");
        DriverManager.getDriver().navigate().to("https://automationexercise.com/");

    }

    @AfterMethod
    public void quit(){
        DriverManager.getDriver().quit();
        DriverManager.unload();

    }


}
