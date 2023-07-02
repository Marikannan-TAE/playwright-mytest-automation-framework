package excercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchRealBrowsers {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        /*BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("msedge");    //setChannels method is used to Launch real browsers instead of browser Engines
        lp.setHeadless(false);*/
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://uat.ech.tio.systems/semarchy/login.do");
    }
}
