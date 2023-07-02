package excercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnAlerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

        page.navigate("https://letcode.in/alert");

        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();
        });
        page.locator("#accept").click();

        playwright.close();
    }
}
