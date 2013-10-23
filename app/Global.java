/**
 * Initializes the page with 3 surfers.
 * @author Jonathan Ortal
 *
 */
import play.GlobalSettings;
import models.SurferDB;
import views.formdata.SurferFormData;
import play.Application;

/**
 * 
 */
public class Global extends GlobalSettings {
  
  public void onStart(Application app) {
    
    SurferDB.addSurfer(new SurferFormData("Eddie Aikau", "Home", "Lifeguard Master", "carousel image URL",
                                          "bio image URL", "bio text", "slug id 1", "Male"));

    SurferDB.addSurfer(new SurferFormData("Eddie Bikau", "Home", "Lifeguard Master", "carousel image URL",
        "bio image URL", "bio text", "slug id 2", "Male"));

    SurferDB.addSurfer(new SurferFormData("Eddie Cikau", "Home", "Lifeguard Master", "carousel image URL",
        "bio image URL", "bio text", "slug id 3", "Male"));
    
  }
}
