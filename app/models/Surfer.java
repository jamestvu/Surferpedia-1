package models;
/**
 * 
 */
public class Surfer {
  
  private String name;
  private String home;
  private String awards;
  private String carouselURL;
  private String bioURL;
  private String bio;
  private String slug;
  private String surferType;
  
  public Surfer(String name, String home, String awards, String carouselURL, String bioURL,
                String bio, String slug, String surferType) {
    
    this.setName(name);
    this.setHome(home);
    this.setAwards(awards);
    this.carouselURL = carouselURL;
    this.setBioURL(bioURL);
    this.setBio(bio);
    this.setSlug(slug);
    this.setSurferType(surferType);
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  public String getCarouselURL() {
    return carouselURL;
  }

  public void setCarouselURL(String carouselURL) {
    this.carouselURL = carouselURL;
  }

  public String getBioURL() {
    return bioURL;
  }

  public void setBioURL(String bioURL) {
    this.bioURL = bioURL;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getSurferType() {
    return surferType;
  }

  public void setSurferType(String surferType) {
    this.surferType = surferType;
  }
  
}
