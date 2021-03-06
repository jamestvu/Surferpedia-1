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
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  // Tests to see if on the index page by finding the carousel.
  @Override
  public void isAt() {
    assertThat(!find("#carousel").isEmpty());
  }
  
  // Search method
  public void searchAll() {
    find("#searchSubmit").click();
  }
  
  // Logout method.
  public void logout() {
    find("#navButton").click();
    find("#logout").click();        
  }
  
  // Confirm logged out.
  public boolean isLoggedOut() {
    return find("#logout").isEmpty();
  }

}
