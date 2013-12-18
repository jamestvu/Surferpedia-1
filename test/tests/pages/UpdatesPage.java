package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class UpdatesPage extends FluentPage {
  private String url;
  
  /**
   * Create the UpdatesPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public UpdatesPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/updates";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  // Confirms create surfer page by checking the title.
  @Override
  public void isAt() {
    assertThat(title()).containsIgnoringCase("updates");
  }
  
  public void isNotAt() {
    assertThat(title()).containsIgnoringCase("Login");
  }
  
}
