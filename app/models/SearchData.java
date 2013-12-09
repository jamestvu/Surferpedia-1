package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * A simple representation of a user. 
 * @author James Vu
 */

@Entity
public class SearchData extends Model {
 
  private static final long serialVersionUID = 5L;  
  
  
  private String searchText;
  private String genderType;
  private String country;
  @Id
  private String slug;
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for products.
   */
  public static Finder<String, SearchData> find() {
    return new Finder<String, SearchData>(String.class, SearchData.class);
  }

  
  /**
   * Creates a new SearchData instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   * @param slug The slug.
   */
  public SearchData(String searchText, String genderType, String country, String slug) {
    this.setSearchText(searchText);
    this.setGenderType(genderType);
    this.setCountry(country);
    this.setSlug(slug);
  }

  /**
   * @return the searchText
   */
  public String getSearchText() {
    return searchText;
  }

  /**
   * @param searchText the searchText to set
   */
  public void setSearchText(String searchText) {
    this.searchText = searchText;
  }

  /**
   * @return the genderType
   */
  public String getGenderType() {
    return genderType;
  }

  /**
   * @param genderType the genderType to set
   */
  public void setGenderType(String genderType) {
    this.genderType = genderType;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }
  

}
