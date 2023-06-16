package excercises;

import com.microsoft.playwright.*;

public class Assignment1 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");

        //Assignment -1
        /* 1. Enter a message into form 1
         * 2. Click "Get checked Value" button
         * 3. Will get the message, need to print the message into console */

        page.locator("//input[@placeholder='Please enter your Message']").type("Hello Playwright");
        page.locator("#showInput").click();
        /*Getting a values by using Javascript executor - page.evalute
        and storing into a string*/
        String value = (String) page.evaluate("document.querySelector('#message').valueOf().textContent");
        System.out.println(value);

        //Assignment -2
        /* 1. Enter numbers into input box 1 and input box 2
        *  2. Click "Get Sum" button and calculate the values
        *  3. Values will be listed under Result. get the result and print into console
        * */

        page.locator("#sum1").type("10");
        page.locator("#sum2").type("120");
        page.locator("#gettotal > button").click();
        String result=(String) page.evaluate("document.querySelector(\"#addmessage\").valueOf().textContent");
        System.out.println(result);
    }
}
