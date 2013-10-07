package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Page1;
import views.html.eddie;
import views.html.joyce;
import views.html.jake;
import views.html.mho;
import views.html.malia;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns page for Eddie Aikau.
   * @return The eddie page.
   */
  public static Result page1() {
    return ok(eddie.render("Welcome to Page1."));
    
  }
  /**
   * Returns page for Joyce Hoffman
   * @return The joyce page
   */
  public static Result page2() {
    return ok(joyce.render("Welcome to Page1."));
    
  }
  /**
   * Returns page for Jake Marshal
   * @return The jake page.
   */
  public static Result page3() {
    return ok(jake.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page for Micheal Ho.
   * @return The mho page.
   */
  public static Result mho() {
    return ok(mho.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page for Micheal Ho.
   * @return The mho page.
   */
  public static Result malia() {
    return ok(malia.render("Welcome to Page1."));
    
  }

}
