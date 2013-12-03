package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * Provides in-memory repository for the Surfer data.
 * @author Jonathan Ortal
 * 
 */

public class SurferDB {

  /**
   * Adds a new surfer to the "database".
   * @param formData The surfer data
   * @return The created surfer
   */
  public static void addSurfer(SurferFormData formData){
    String slug = formData.slug;
    String country = formData.country;
    
    if (slugExists(slug)) {
      //throw new RuntimeException("slug exists");
      Surfer.find().where().eq("slug", slug).findUnique().delete();
      Surfer surfer = new Surfer(formData.name, formData.home, formData.awards, formData.carouselURL,
          formData.bioURL, formData.bio, formData.slug, formData.surferType,
          formData.foot, country);
      surfer.save();
    }
    else {
      Surfer surfer = new Surfer(formData.name, formData.home, formData.awards, formData.carouselURL,
          formData.bioURL, formData.bio, formData.slug, formData.surferType,
          formData.foot, country);      
      surfer.save();
    }
  }
  
  /**
   * Returns the list of surfers.
   * @return A list of surfers.
   */
  public static List<Surfer> getSurfers() {
    return Surfer.find().all();
  }
  
  /**
   * Returns Surfer with associated slug.
   * @param slug The slug.
   * @return The retrieved Slug.
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = Surfer.find().byId(slug);
    if (surfer == null) {
      throw new RuntimeException("Invalid ID: " + slug);
    }
    return surfer;
  }
  
  /**
   * Delete a surfer.
   * @param slug The slug of the surfer to delete.
   */
  public static void deleteSurfer(String slug) {
    Surfer.find().where().eq("slug", slug).findUnique().delete();
  }
  
  /**
   * Checks if a slug exists.
   * @param slug the slug.
   * @return true if slug exists.
   */
  public static boolean slugExists(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique() != null;
  }
}
