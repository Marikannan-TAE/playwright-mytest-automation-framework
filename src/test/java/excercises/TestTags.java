package excercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class TestTags {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com/");
        List<String> AmazonText = page.locator("text=Amazon").allInnerTexts();
        List<String> AmazonHasText = page.locator("a:has-text('Amazon')").allInnerTexts();

        AmazonHasText.stream().forEach(e-> System.out.println(e));
        System.out.println(AmazonHasText.size());

       /* for(int i=1; i< AmazonText.size(); i++){
            System.out.println(AmazonText.get(i));

        }*/
    }
}
