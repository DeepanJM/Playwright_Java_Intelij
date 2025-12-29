package tests;

import base.BaseTest;
import base.OldBaseTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FirstTest extends OldBaseTest {

    @Test
    public void VerifyTitle(){
        page.navigate("https://google.com");

//        //Optional: Handle cookie popup
//        if (page.isVisible("button:has-text('Accept all'))")){
//            page.click("button:has-text('Accept all'))");
//        }
        System.out.println("The Page Title is " + page.title());
    }
}
