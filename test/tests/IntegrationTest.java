package tests;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import tests.pages.IndexPage;
import tests.pages.LoginPage;
import tests.pages.NewSurferPage;
import tests.pages.SearchResultsPage;
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

  // Test to see that the index page is loaded.
  @Test
  public void testIndexRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }

  // Test login/logout functions.
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        
        // Login.
        loginPage.login();

        // Logout.
        loginPage.logout();
        
        // Confirm logout.
        assertThat(loginPage.isLoggedOut()).isTrue();        
      }
    });
  }

  // Test CRUD operations.
  @Test
  public void testCrud() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);

        browser.goTo(loginPage);
        // Login.
        loginPage.login();

        // Navigate to create new surfer page.
        browser.goTo(newSurferPage);
        
        // Confirm on create new surfer page.
        newSurferPage.isAt();
        
        // Create new surfer.
        newSurferPage.makeSurfer("Test Surfer", "Home", "USA", "", "Goofy", "http://img.png", "http://img.png",
            "test bio", "testslug", "Male");
        
        // Confirm that the surfer was created.
        assertThat(browser.pageSource()).contains("Test Surfer");
        
        // Test edit function for newly created surfer.
        newSurferPage.editSurfer();
        // Confirm changes.
        assertThat(browser.pageSource()).contains("something else");
        
        // Test delete function.
        newSurferPage.deleteSurfer();
        
        // Confirm deletion.
        browser.goTo("http://localhost:3333/surfer/testslug/");
        assertThat(browser.pageSource()).contains("Action not found");

      }
    });
  }
  
  // Test search widget
  @Test
  public void testSearchWidget() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        SearchResultsPage searchPage = new SearchResultsPage(browser.getDriver(), PORT);
        searchPage.searchAll();
        searchPage.isAt();
        //Search all should contain Joyce Hoffman
        assertThat(browser.pageSource()).contains("Joyce Hoffman");
      }
    });
  }

  // Test login/logout functions.
  @Test
  public void testPagination() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        SearchResultsPage searchPage = new SearchResultsPage(browser.getDriver(), PORT);
        searchPage.searchAll();
        searchPage.isAt();

        //Testing the pagination
        assertThat(browser.pageSource()).contains("Joyce Hoffman");
        searchPage.nextPage();


        assertThat(!(browser.pageSource()).contains("Joyce Hoffman"));
        assertThat(browser.pageSource()).contains("Sam Coffey");
        searchPage.previousPage();
        assertThat(!(browser.pageSource()).contains("Sam Coffey"));
        assertThat(browser.pageSource()).contains("Joyce Hoffman");
      }
    });
  }
}
