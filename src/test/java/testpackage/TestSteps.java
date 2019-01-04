package testpackage;

import cucumber.api.java.en.Given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSteps extends FluentCucumberTest {

  @Page
  TestPage testPage;

  @Override
  public WebDriver newWebDriver() {
      Optional<Path> chromeDriverPath = Optional.empty();
      try {
        String driverPath = "/src/test/resources/webdriver";
        if (!Files.exists(Paths.get(driverPath))) {
          driverPath = driverPath.substring(driverPath.indexOf("/")).substring(1);
        }
        chromeDriverPath = Files.walk(Paths.get(driverPath))
            .filter(Files::isRegularFile)
            .filter(path -> path.endsWith("chromedriver"))
            .findFirst();
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (chromeDriverPath.isPresent()) {
        System.setProperty("webdriver.chrome.driver",
            chromeDriverPath.get().toAbsolutePath().toString());
      } else {
        throw new IllegalStateException("Chrome driver binary not found");
      }
    return new ChromeDriver();
  }



  @Given("^the operator is on the google home page$")
  public void the_operator_navigates_to_google() {
    goTo(testPage);
    testPage.isAt();
  }




}
