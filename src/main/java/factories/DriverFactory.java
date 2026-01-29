package factories;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

    public DriverFactory() {
    }
    public static WebDriver createDriver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                BrowserMobProxy proxy = new BrowserMobProxyServer();
                proxy.start(0);

                // Block common ad hosts and vignettes
                proxy.blacklistRequests(".*doubleclick.net.*", 404);
                proxy.blacklistRequests(".*googlesyndication.com.*", 404);
                proxy.blacklistRequests(".*pagead.*", 404);
                proxy.blacklistRequests(".*adservice.google.com.*", 404);
                proxy.blacklistRequests(".*vignette.*", 404);

                // Create Selenium proxy config
                Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
                ChromeOptions options = new ChromeOptions();
                options.setProxy(seleniumProxy);
                options.addArguments("--start-maximized",
                        "--ignore-certificate-errors",
                        "--ignore-ssl-errors",
                        "--disable-popup-blocking",
                        "--disable-notifications");
               return new ChromeDriver(options);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("unsupported browser");
        }

    }
}
