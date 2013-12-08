package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the Search form.
 */
public class SearchFormData {

  /** The search text. */
  public String searchText = "";
  /** Grom/Male/Female. */
  public String genderType = "";
  /** The country field. */
  public String country = "";

  /** Required for form instantiation. */
  public SearchFormData() {
  }
  
  public SearchFormData(String searchText, String genderType, String country) {
    this.searchText = searchText;
    this.genderType = genderType;
    this.country = country;
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

  /**
   * Validates Form<SearchFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {
    /*
    List<ValidationError> errors = new ArrayList<>();
    
    if (!UserInfoDB.isValid(email, password)) {
      errors.add(new ValidationError("email", ""));
      errors.add(new ValidationError("password", ""));      
    }
    
    return (errors.size() > 0) ? errors : null;
    */
    return null;
  }

}
