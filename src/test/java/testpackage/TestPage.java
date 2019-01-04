package testpackage;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("http://www.google.co.uk")
public class TestPage extends FluentPage {

  @FindBy(xpath = "//*[contains(@class, \"gLFyf gsfi\")]")
  FluentWebElement googleSearchBar;
  @FindBy(name = "btnK")
  FluentWebElement googleSearchButton;

  @Override
  public void isAt() {
    awaitForPageLoad(5);
    await().atMost(5, SECONDS)
        .untilPredicate(fluentControl -> window().title().contains("Google"));
  }

  private void awaitForPageLoad(Integer timeInSeconds) {
    await().atMost(timeInSeconds, SECONDS).untilPage().isLoaded();
  }

  private void searchForWord(String word){
    googleSearchBar.fill().with("hello");
    googleSearchButton.click();
  }

}
