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
  /** The slug field. */
  public String slug = "";

  /** Required for form instantiation. */
  public SearchFormData() {
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
