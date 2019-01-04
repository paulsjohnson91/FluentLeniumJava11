package testpackage;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    tags = "@google-main-tests",
    features = "src/test/resources/feature_files",
    glue = {""})
public class TestRunner extends AbstractTestNGCucumberTests {

}