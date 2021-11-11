package app;

import configBrowser.BrowserDao;
import configBrowser.ConfigProperties;
import util.ResourceUtil;

import java.util.Map;

public class Browser {
    private BrowserTypes temp;
    private Object options;
    private BrowserDao browserDao;

    public Object getBrowserType() {
        if (temp == null) {
            Map<String, String> map = ResourceUtil.getResource("browser.properties");
            temp = BrowserTypes.init(map.get("type"));
        }
        switch (temp) {
            case chrome: {
                if (browserDao == null) {
                    browserDao = new ConfigProperties();
                    browserDao.createChrome(browserDao);
                }
            }
            break;
            case edge: {
                if (browserDao == null) {
                    browserDao = new ConfigProperties();
                    browserDao.createEdge(browserDao);
                }
            }
            break;
        }
        return browserDao;
    }
}
