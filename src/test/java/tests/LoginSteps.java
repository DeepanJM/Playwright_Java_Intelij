package tests;

import base.BaseTest;
import io.cucumber.java.en.*;
import static org.testng.Assert.assertEquals;

public class LoginSteps extends BaseTest {
    @Given("user navigates to the login page")
    public void navigateToLoginPage() {
        test.info("Navigating to Login Page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @When("user logs in with username {string} and password {string}")
    public void login(String username, String password) {
        test.info("Logging in");
        loginPage.login(username, password);
    }
    @Then("user should see the Time link")
    public void verifyTimeLink() {
        test.info("Verifying Time link");
        assertEquals(homePage.getTimeLinkText(), "Time");
    }
    @And("user clicks the Time link")
    public void clickTimeLink() {
        test.info("Clicking Time link");
        homePage.clickTimeLink();
    }
}
