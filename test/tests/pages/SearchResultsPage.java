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
public class SearchResultsPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public SearchResultsPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/search";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  // Tests to see if on the index page by finding the carousel.
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Search Results");
  }
  
  public void nextPage() {
    find("#page3").click();
  }
  
  public void previousPage() {
    find("#page1").click();
  }
  // Search method
  public void searchAll() {
    find("#navButton").click();
    find("#searchSubmit").click();
  }
  


}
