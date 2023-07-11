package excercises;

import com.microsoft.playwright.*;

public class iFrameExcercise1 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();

        //Locating the element inside the iframe by frameLocator
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("input[name='RESULT_TextField-1']").fill("Test");

        //Submitting the form before filling mandatory values
        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("//input[@id='FSsubmit']").click();

        //Error message is expected > Capturing the error message by iframe locator & Printing the Error message
        String ErrorMessage = page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#FSForm>div.form_table.invalid>div").textContent();
        System.out.println("Error message is: " + ErrorMessage);
        playwright.close();
    }
}
