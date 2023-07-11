package excercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleElementExcercise {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.automationexercise.com/products");

        //Searching visible links
        List<String> linkText = page.locator("a:visible").allInnerTexts();
        for(int i=1; i< linkText.size(); i++)
        {
            System.out.println(linkText.get(i));
        }

        //Count of "Add To Cart" button
        int countOfAddToCart = page.locator("xpath=//a[text()=\"Add to cart\"] >> visible=true").count();
        System.out.println(countOfAddToCart);
    }
}
