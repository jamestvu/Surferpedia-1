package tests;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import tests.pages.LoginPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the two pages can be displayed.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:" + PORT);
        assertThat(browser.pageSource()).contains("surferpedia");
      }
    });
  }

  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        // System.out.println("http://localhost:3333/login");
        browser.goTo("http://localhost:3333/login");
        loginPage.login();
      }
    });
  }  
  
}