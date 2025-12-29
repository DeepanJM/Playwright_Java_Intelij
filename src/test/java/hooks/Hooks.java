package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void beforeScenario(Scenario scenario) {
        BaseTest.init(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            BaseTest.test.fail("Scenario Failed");
        } else {
            BaseTest.test.pass("Scenario Passed");
        }
        BaseTest.tearDown();
    }
}
