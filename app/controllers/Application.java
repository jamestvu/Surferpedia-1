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
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  
  public static Result showSurf() {
    return ok(ShowSurfer.render(SurferDB.getSurfers()));
  }
  /**
   * Returns new surfer page.
   * @return The add surfer page.
   */
  
  public static Result newSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
    return ok(ManageSurfer.render(formData, surferTypeMap));
  }
  
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render(formData, surferTypeMap));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      return ok(ManageSurfer.render(formData, surferTypeMap));  
    }
  }
}
