package controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.Index;
import views.html.Login;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.html.Updates;
import models.Surfer;
import models.SurferDB;
import models.UpdateDB;
import models.UserInfo;
import models.UserInfoDB;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.formdata.FootstyleTypes;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  
  /**
   * Returns the index page with the carousel. 
   * @return The Surferpedia home page. 
   */
  // @Security.Authenticated(Secured.class)  
  public static Result index() {
    /**
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    //System.out.println(isLoggedIn + " " + userInfo.getEmail());    
    if (isLoggedIn) {
      return ok(Index.render("Home", isLoggedIn, userInfo));
    }
    */
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    return ok(Index.render("Home", isLoggedIn, userInfo));
  }
  
  @Security.Authenticated(Secured.class)  
  public static Result updates() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);    
    return ok(Updates.render("Updates", isLoggedIn, userInfo, UpdateDB.getUpdate()));
  }
  
  /**
   * Returns the bio page of the surfer.
   * @param slug The slug of the surfer.
   * @return The page of the surfer.
   */
  public static Result getSurfer(String slug) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);    
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render(formData, "Surfer", isLoggedIn, userInfo));
  }
  
  /**
   * Removes surfer from the database.
   * @param slug The slug of the surfer to delete.
   * @return The index page.
   */
  @Security.Authenticated(Secured.class)  
  public static Result deleteSurfer(String slug) {
    Surfer surfer = SurferDB.getSurfer(slug);
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    
    Date curr = new Date();
    String date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(curr);
    UpdateDB.addUpdate(date, surfer.getName(), "Delete");
    
    SurferDB.deleteSurfer(slug);
    return ok(Index.render("Home", isLoggedIn, userInfo));
  }  
  
  /**
   * Manages a surfer's information.
   * Passes the boolean 'true' to the manageSurfer page because a slug already exists.
   * @param slug The slug of the surfer to manage. 
   * @return The new surfer form page, pre filled with the surfer's information.
   */
  @Security.Authenticated(Secured.class)  
  public static Result manageSurfer(String slug) {
    slug = slug.trim();
    String surfType = SurferDB.getSurfer(slug).getSurferType();
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(surfType);
    List<String> footTypeList = FootstyleTypes.getFootTypes();
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);    
    
    Date curr = new Date();
    String date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(curr);
    UpdateDB.addUpdate(date, data.name, "Edit");

    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
        
    return ok(ManageSurfer.render(formData, surferTypeMap, footTypeList, true, "Edit", isLoggedIn, userInfo));
   }
  
  /**
   * Returns add new surfer page.
   * Passes the boolean 'false' to the manageSurfer page because a slug may not exist.
   * @return The add surfer page.
   */  
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
    List<String> footTypeList = FootstyleTypes.getFootTypes();
    
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    
    return ok(ManageSurfer.render(formData, surferTypeMap, footTypeList, false, "Create", isLoggedIn, userInfo));
  }  
  
  /**
   * Handles post of the form data.
   * @return The newly added surfer page.
   */
  @Security.Authenticated(Secured.class)  
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      List<String> footTypeList = FootstyleTypes.getFootTypes();      
      
      UserInfo userInfo = UserInfoDB.getUser(request().username());
      Boolean isLoggedIn = (userInfo != null);
      
      return badRequest(ManageSurfer.render(formData, surferTypeMap, footTypeList, false, "Post", isLoggedIn, userInfo));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      Date curr = new Date();
      String date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(curr);
      UpdateDB.addUpdate(date, data.name, "Create");
      
      UserInfo userInfo = UserInfoDB.getUser(request().username());
      Boolean isLoggedIn = (userInfo != null);
      
      return ok(ShowSurfer.render(formData, "Post", isLoggedIn, userInfo));  
    }
  }

  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
}
