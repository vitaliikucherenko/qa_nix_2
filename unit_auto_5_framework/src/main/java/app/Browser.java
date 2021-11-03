package app;

import configBrowser.BrowserDao;
import configBrowser.ConfigProperties;
import util.ResourceUtil;
import java.util.Map;

public class Browser {
    private DaoType temp;
    private Object options;
    private BrowserDao browserDao;

    public Object getBrowserType(){
        if (temp == null) {
            Map<String, String> map = ResourceUtil.getResource("browser.properties");
            temp = DaoType.init(map.get("type"));
        }
            switch (temp) {
                case chrome: {
                 /* Configuration.browser = "chrome";
                    options = new ChromeOptions();
                    Configuration.startMaximized = true;*/
                    if (browserDao == null) {
                        browserDao = new ConfigProperties();
                        browserDao.createChrome(browserDao);
                    }
                } break;
                case edge : {
                   /* Configuration.browser = "edge";
                    options = new EdgeOptions();
                    Configuration.startMaximized = true;*/
                    if (browserDao == null) {
                        browserDao = new ConfigProperties();
                        browserDao.createEdge(browserDao);
                    }
                } break;
            }
        return browserDao;
    }
}
