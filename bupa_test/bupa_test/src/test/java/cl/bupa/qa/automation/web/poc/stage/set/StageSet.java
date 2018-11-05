package cl.bupa.qa.automation.web.poc.stage.set;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cl/bupa/qa/automation/web/poc/definition",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ReportePruebasBCP.html" }
)
public class StageSet {
}
