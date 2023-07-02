package excercises;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.sun.jdi.ByteValue;

import java.util.List;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://testsheepnz.github.io/BasicCalculator.html");
        page.locator("#number1Field").type("5");
        page.locator("#number2Field").type("10");

        /*Select dropdown box*/
        Locator selectDD=page.locator("#selectOperationDropdown");
        Locator options = selectDD.locator("option");

        selectDD.selectOption(new SelectOption().setValue(String.valueOf(3)));
        selectDD.selectOption(new SelectOption().setIndex(2));
        //selectDD.selectOption(new SelectOption().setIndex(2));
        int countops = options.count();
        selectDD.selectOption(new SelectOption().setIndex(countops-1));



        page.locator("#calculateButton").click();

        List<String> allInnerText = (List<String>) options.allInnerTexts();
        allInnerText.forEach(i -> System.out.println(i));


        String result = page.locator("#numberAnswerField").inputValue();
        System.out.println(result);

        Thread.sleep(2000);
         page.locator("#clearButton").click();
         Thread.sleep(3000);

playwright.close();

    }
}
