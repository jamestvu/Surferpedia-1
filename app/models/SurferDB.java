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

  private static Map<String, Surfer> surfers = new HashMap<>();

  /**
   * Adds a new surfer to the "database".
   * @param formData The surfer data
   * @return The created surfer
   */
  public static Surfer addSurfer(SurferFormData formData) {
    String slug = formData.slug;
    Surfer surfer = new Surfer(formData.name, formData.home, formData.awards, formData.carouselURL,
                               formData.bioURL, formData.bio, formData.slug, formData.surferType);
    surfers.put(slug, surfer);
    return surfer;
  }

  /**
   * Returns the list of surfers.
   * @return A list of surfers.
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Returns Surfer with associated slug.
   * @param slug The slug.
   * @return The retrieved Slug.
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
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
    surfers.remove(slug);
  }
}
