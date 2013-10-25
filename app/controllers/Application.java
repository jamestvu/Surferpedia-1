package controllers;

import java.util.Map;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import models.SurferDB;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the index page with the carousel. 
   * @return The Surferpedia home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to Surferpedia."));
  }
  
  /**
   * Returns the bio page of the surfer.
   * @param slug The slug of the surfer.
   * @return The page of the surfer.
   */
  public static Result getSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render(formData));
  }
  
  /**
   * Removes surfer from the database.
   * @param slug The slug of the surfer to delete.
   * @return The index page.
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(""));
  }  
  
  /**
   * Manages a surfer's information.
   * @param slug The slug of the surfer to manage.
   * @return The new surfer form page, pre filled with the surfer's information.
   */
  public static Result manageSurfer(String slug) {
    slug = slug.trim();
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, surferTypeMap));
   }
  
  /**
   * Returns add new surfer page.
   * @return The add surfer page.
   */  
  public static Result newSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
    return ok(ManageSurfer.render(formData, surferTypeMap));
  }  
  
  /**
   * Handles post of the form data.
   * @return The newly added surfer page.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render(formData, surferTypeMap));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      return ok(ShowSurfer.render(formData));  
    }
  }
}
