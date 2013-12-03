package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
/**
 * 
 */
@Entity
public class Surfer extends Model {
  
  private static final long serialVersionUID = 1L;

  private String name;
  private String home;
  private String awards;
  @Lob
  private String carouselURL;
  @Lob
  private String bioURL;
  @Lob
  private String bio;
  @Id
  private String slug;
  private String surferType;
  private String foot;
  private String country;
  
  @ManyToOne
  private UserInfo userInfo;
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for products.
   */
  public static Finder<String, Surfer> find() {
    return new Finder<String, Surfer>(String.class, Surfer.class);
  }
  
  /**
   * Creates a new surfer.  
   * @param name The name of the surfer.
   * @param home The home town of the surfer.
   * @param awards The awards/titles of the surfer.
   * @param carouselURL The URL of the surfer's carousel image.
   * @param bioURL The URL of the surfer's bio image.
   * @param bio The surfer's bio.
   * @param slug The surfer's slug.
   * @param surferType The surfer's type.
   */
  public Surfer(String name, String home, String awards, String carouselURL, String bioURL,
                String bio, String slug, String surferType, String foot, String country) {
    
    this.setName(name);
    this.setHome(home);
    this.setAwards(awards);
    this.carouselURL = carouselURL;
    this.setBioURL(bioURL);
    this.setBio(bio);
    this.setSlug(slug);
    this.setSurferType(surferType);
    this.setFoot(foot);
    this.setCountry(country);
  }

  /**
   * @return The surfer's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the surfer's name.
   * @param name The surfer's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The surfer's home town.
   */
  public String getHome() {
    return home;
  }

  /**
   * Sets the surfer's home town.
   * @param home The surfer's home town.
   */
  public void setHome(String home) {
    this.home = home;
  }

  /**
   * @return The surfer's awards/titles.
   */
  public String getAwards() {
    return awards;
  }

  /**
   * Sets the surfer's awards/titles.
   * @param awards The surfer's awards/titles.
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }

  /**
   * @return The surfer's carousel image URL.
   */
  public String getCarouselURL() {
    return carouselURL;
  }

  /**
   * Sets the surfer's carousel image URL.
   * @param carouselURL The surfer's carousel image URL.
   */
  public void setCarouselURL(String carouselURL) {
    this.carouselURL = carouselURL;
  }

  /**
   * @return The surfer's bio image URL.
   */
  public String getBioURL() {
    return bioURL;
  }

  /**
   * Sets the surfer's bio image URL.
   * @param bioURL The surfer's bio image URL.
   */
  public void setBioURL(String bioURL) {
    this.bioURL = bioURL;
  }

  /**
   * @return The surfer's bio.
   */
  public String getBio() {
    return bio;
  }

  /**
   * Sets the surfer's biographical information.
   * @param bio The surfer's bio.
   */
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   * @return The surfer's slug
   */
  public String getSlug() {
    return slug.trim();
  }

  /**
   * Sets the surfer's slug, or identification for this database.
   * @param slug The surfer's slug.
   */
  public void setSlug(String slug) {
    this.slug = slug.trim();
  }

  /**
   * @return The type of surfer (Male, Female, or Grom).
   */
  public String getSurferType() {
    return surferType;
  }

  /**
   * Sets the surfer's type.
   * @param surferType The type of surfer.
   */
  public void setSurferType(String surferType) {
    this.surferType = surferType;
  }

  public String getFoot() {
    return foot;
  }

  public void setFoot(String foot) {
    this.foot = foot;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
    
    /**
     * Check various country abbreviations/spellings here.
     */    
    switch (country.toLowerCase()) {
      case "usa":
        this.country = "United States";
        break;
      case "cn":
        this.country = "China";
        break;
      case "jp":
        this.country = "Japan";
        break;
      case "fr":
        this.country = "France";
        break;
      case "ca":
        this.country = "Canada";
        break;
      case "br":
        this.country = "Brazil";
        break;
      case "de":
        this.country = "Germany";
        break;
      case "ws":
        this.country = "Samona";
        break;
      case "gu":
        this.country = "Guam";
        break;
    }
  }

  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }


}
