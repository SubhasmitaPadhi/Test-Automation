package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "src/test/java/StepDefination",
        //tags = "@SmokeTest",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html"},
        monochrome = true
)
public class TestRunner {
}