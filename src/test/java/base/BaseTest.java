package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentManager;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static LoginPage loginPage;
    protected static HomePage homePage;

    public static void init(String scenarioName) {
        extent = ExtentManager.getInstance();
        test = extent.createTest(scenarioName);
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    public static void tearDown() {
        extent.flush();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
