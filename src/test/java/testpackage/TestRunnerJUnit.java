package testpackage;

import cucumber.api.CucumberOptions;
import org.fluentlenium.adapter.cucumber.FluentCucumber;
import org.junit.runner.RunWith;

@RunWith(FluentCucumber.class)
@CucumberOptions(
    tags = "@google-main-tests",
    features = "src/test/resources/feature_files",
    glue = {""})
public class TestRunnerJUnit {

}