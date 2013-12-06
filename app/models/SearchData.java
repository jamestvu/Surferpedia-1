package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple representation of a user. 
 * @author James Vu
 */

public class SearchData {
 
  private static final long serialVersionUID = 5L;  
  
  private String searchText;
  private String genderType;
  private String country;
  
  /**
   * Creates a new SearchData instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public SearchData(String searchText, String genderType, String country) {
    this.setSearchText(searchText);
    this.setGenderType(genderType);
    this.setCountry(country);
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
  

}
