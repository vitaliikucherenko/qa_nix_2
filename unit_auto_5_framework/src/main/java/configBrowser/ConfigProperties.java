package configBrowser;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;


public class ConfigProperties implements BrowserDao {
    private final ChromeOptions chromeOptions = new ChromeOptions();
    private final EdgeOptions edgeOptions = new EdgeOptions();

    @Override
    public void createChrome(BrowserDao browserDao) {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        //chromeOptions.addArguments("-incognito");
        clearBrowserCookies();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);
        Configuration.browserCapabilities = capabilities;
    }

    @Override
    public void createEdge(BrowserDao browserDao) {
       /* DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("ms:inPrivate", true);
        edgeOptions.merge(capabilities);
        Configuration.browser = "edge";*/
        clearBrowserCookies();
        edgeOptions.setCapability("ms:inPrivate", true);
        Configuration.startMaximized = true;
    }
}
