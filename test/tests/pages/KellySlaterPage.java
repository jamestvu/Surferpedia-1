package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements index page behavior.  
 * @author James Vu
 */
public class KellySlaterPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public KellySlaterPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/surfer/kellyslater";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  // Tests to see if on the index page by finding the carousel.
  @Override
  public void isAt() {
    assertThat(!find("Kelly Slater").isEmpty());
  }
  


}
