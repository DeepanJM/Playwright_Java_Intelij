package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    protected LoginPage loginPage;
    protected HomePage homePage;


    @BeforeMethod
    public void setUp(Method method){
        //Reporting
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        //Playwright Setup
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();

        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        //Reporting Logic
        if (result.getStatus() == ITestResult.FAILURE){
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else{
            test.skip("Test Skipped");
        }
        extent.flush();

        //Browser Cleanup
        if(browser != null) browser.close();
        if(playwright !=null) playwright.close();
    }
}
