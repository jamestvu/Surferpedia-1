package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Surfer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import play.data.validation.ValidationError;

/**
 * 
 * Backing class for form data.
 * 
 */

public class SurferFormData {
      
  /** Name form field. **/
  public String name = ""; 
  /** Hometown form field. **/
  public String home = ""; 
  /** Awards form field. **/
  public String awards = ""; 
  /** Carousel image URL form field. **/
  public String carouselURL = "";
  /** Bio URL form field. **/
  public String bioURL = "";
  /** Bio form field. **/
  public String bio = "";
  /** Slug form field. **/
  public String slug = "";
  /** Surfer type form field. **/
  public String surferType = "";
  
  
  /** No argument constructor. **/
  public SurferFormData() {
    // no arg constructor
  }
  
  /**
   * Constructor for initializing purposes.
   * @param name The name.
   * @param home The home town.
   * @param awards The awards or titles.
   * @param carouselURL The URL for the carousel image.
   * @param bioURL The URL for the bio image.
   * @param bio The bio text.
   * @param slug The slug.
   * @param surferType The type of surfer.
   */
  
  public SurferFormData(String name, String home, String awards, String carouselURL, String bioURL,
                         String bio, String slug, String surferType) {
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.surferType = surferType;
  }

  /**
   * Constructor for surfer's page.
   * @param surfer The surfer's information.
   */
  
  public SurferFormData(Surfer surfer) {
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.carouselURL = surfer.getCarouselURL();
    this.bioURL = surfer.getBioURL();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.surferType = surfer.getSurferType();
  }

  /**
   * Validates form input by the user.
   * All fields except for awards must be non-empty.
   * Slug must be unique on creation, and must be read-only on edits.
   * Slug must be only letters and digits.
   * Type must be either "Male", "Female", or "Grom"
   * @return null if no errors, list of ValidationErrors if there are errors.
   */
  
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
        
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }

    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is required."));
    }

    if (carouselURL == null || carouselURL.length() == 0) {
      errors.add(new ValidationError("carouselURL", "Carousel URL is required."));
    }


    if (bioURL == null || bioURL.length() == 0) {
      errors.add(new ValidationError("bioURL", "Bio URL is required."));
    }

    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "Bio paragraph is required."));
    }


    /**
     * Slug validation. Checks if there any special characters and throws and error if there are any.
     * Special characters are anything that is not alphanumeric.
     */
    Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(slug);
    boolean b = m.find();
    
    if (b) {
      errors.add(new ValidationError("slug", "Surfer slug contains illegal characters. Only alphanumeric characters"
          + " are allowed."));
    }
    
    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required."));
    }
    
    if (!SurferTypes.isType(surferType)) {
      errors.add(new ValidationError("surferType", "Surfer type is invalid"));      
    }
    
    return errors.isEmpty() ? null : errors;
  }
  
}