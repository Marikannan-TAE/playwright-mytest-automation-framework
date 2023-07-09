package excercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOMExcercise2 {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/iframe-in-shadow-dom/");

        //Page --> DOM --> iFrame --> Shadow DOM --> elements
        page.locator("div#app2 input#pizza").fill("Test");


    }
}
