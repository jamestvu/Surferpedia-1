package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Surfer;
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
   * @param name
   * @param home
   * @param awards
   * @param carouselURL
   * @param bioURL
   * @param bio
   * @param slug
   * @param surferType
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
   * All fields must not be empty.
   * Telephone must be 12 characters.
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


    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required."));
    }

    if (!SurferTypes.isType(surferType)) {
      errors.add(new ValidationError("surferType", "Surfer type is invalid"));      
    }

    return errors.isEmpty() ? null : errors;
  }
  
}