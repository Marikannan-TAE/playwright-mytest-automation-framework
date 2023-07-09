package excercises;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.List;

public class selectMultiElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        /* Tracing */
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        Page page = context.newPage();
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

        Locator countryOptions = page.locator("#Form_getForm_Country option");
      /*  *//*Printing all dropdown values by normal for loop*//*
        for (int i = 0; i < countryOptions.count(); i++) {
            String text = countryOptions.nth(i).textContent();
            System.out.println(text);
        }*/

        List<String> OptionsText = countryOptions.allInnerTexts();
        /*Printing all values by list*/
        /*for(String e: OptionsText){
            System.out.println(e);
        }*/

        /*lambda expression*/
        OptionsText.forEach(element -> System.out.println(element));

        /*Closing the tracing*/
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));


    }
}
