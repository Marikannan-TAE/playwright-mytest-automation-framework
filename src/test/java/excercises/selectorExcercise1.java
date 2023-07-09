package excercises;

import com.microsoft.playwright.*;

public class selectorExcercise1 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

        //text locator - "has-text()"
        System.out.println(page.locator("h2:has-text('New Customer')").textContent());

        Locator login = page.locator("form#form-login button:has-text('Login')");
        System.out.println(login.textContent());
        login.click();
        browser.close();

        playwright.close();

    }
}
