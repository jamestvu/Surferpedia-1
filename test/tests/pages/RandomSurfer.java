package tests.pages;

import static org.fest.assertions.Assertions.assertThat;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;

public class RandomSurfer extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public RandomSurfer(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/login";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Surfer");
  }
  
  public void randomSurfer() {
    find("#nav").click();
    find("#navButton").click();
    find("#randomSurfer").click();      
  }
  
}
