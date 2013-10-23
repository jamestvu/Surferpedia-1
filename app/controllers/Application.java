package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Eddie;
import views.html.Joyce;
import views.html.Jake;
import views.html.Mho;
import views.html.Malia;
import views.html.KalaniDavid;

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
    return ok(Eddie.render("Welcome to Page1."));
    
  }
  /**
   * Returns page for Joyce Hoffman.
   * @return The joyce page
   */
  public static Result page2() {
    return ok(Joyce.render("Welcome to Page1."));
    
  }
  /**
   * Returns page for Jake Marshal.
   * @return The jake page.
   */
  public static Result page3() {
    return ok(Jake.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page for Micheal Ho.
   * @return The mho page.
   */
  public static Result mho() {
    return ok(Mho.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page for Malia.
   * @return The mho page.
   */
  public static Result malia() {
    return ok(Malia.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page for Kalani Daivd.
   * @return The kalanidavid page.
   */
  public static Result kalanidavid() {
    return ok(KalaniDavid.render("Welcome to Page1."));
    
  }

}
