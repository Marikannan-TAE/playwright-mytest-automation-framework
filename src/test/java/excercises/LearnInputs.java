package excercises;

import com.microsoft.playwright.*;

public class LearnInputs {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/edit");

        page.locator("#fullName").type("MK Test");
        Locator locator = page.locator("#join");
        locator.press("End");
        locator.type("  man");
        locator.press("Tab");
        String value = page.locator("id=getMe").getAttribute("value");
        System.out.println(value);
        page.locator("#clearMe").clear();

    }
}
