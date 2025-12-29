package tests;

import base.BaseTest;
import base.OldBaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest2 extends OldBaseTest {

    @Test(priority = 1)
    public void test() {
//        LoginPage loginPage = new LoginPage(page);
//        HomePage homePage = new HomePage(page);

        test.info("Navigating to Login Page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Adding Username");
        loginPage.addUsername("Admin");

        test.info("Adding Password");
        loginPage.addPassword("admin123");

        test.info("Clicking Login Button");
        loginPage.clickLoginButton();

        test.info("Checking HomePage");
        homePage.clickTimeLink();

        test.info("All Steps Completed");
    }

    @Test(priority = 2)
    public void AllInOneMethod() {
//      LoginPage loginPage = new LoginPage(page);
//      HomePage homePage = new HomePage(page);

        test.info("Navigating to Login Page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Completing Login Process");
        loginPage.login("Admin", "admin123");

        test.info("Checking HomePage");
        homePage.clickTimeLink();

        assertEquals(homePage.getTimeLinkText(), "Time", "Time link text mismatch");

        test.info("All Steps Completed");
    }
}
