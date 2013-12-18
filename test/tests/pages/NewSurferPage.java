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
public class NewSurferPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewSurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/new";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  // Confirms create surfer page by checking the title.
  @Override
  public void isAt() {
    assertThat(title()).containsIgnoringCase("create");
  }
  
  public void isNotAt() {
    assertThat(title()).containsIgnoringCase("Login");
  }
  
  // Create surfer.
  public void makeSurfer(String name, String home, String country, String awards, String foot,
      String carouselUrl, String bioUrl, String bio, String slug, String surferType) {
    fill("#name").with(name);
    fill("#home").with(home);
    fill("#country").with(country);
    fill("#awards").with(awards);
    find("input", withId(foot)).click();
    fill("#carouselURL").with(carouselUrl);
    fill("#bioURL").with(bioUrl);
    fill("#bio").with(bio);
    fill("#slug").with(slug);    
    find("select", withId("surferType")).find("option", withId(surferType)).click();
    submit("#surferSubmit");
  }
  
  // Edit newly created surfer by modifying the home field.
  public void editSurfer() {
    find("#edit").click();
    // Confirm edit surfer page by checking the url.
    assertThat(getUrl().contains("edit"));
    // Change home field to something else.
    fill("#home").with("something else");
    submit("#surferSubmit");
  }
  
  // Delete added surfer.
  public void deleteSurfer() {
    find("#delete").click();
    find("#modalDelete").click();
  }
}
