package excercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOMExcercise {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        //Page --> DOM --> Shadow-DOM --> Elements
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing");
        //page.locator("book-app[apptitle='BOOKS'] div[class='icon']").click();
        String testContent = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(testContent);
    }
}
