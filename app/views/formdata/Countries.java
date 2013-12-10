package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Surfer;
import models.SurferDB;

/**
 * Represents surfer types.
 */

public class Countries {

  /**
   * Method that retrieves the list of all countries used in the Database.
   * @return list of countries.
   */
  public static List<String> getTypesFromDB() {
    ArrayList<String> types = new ArrayList<String>();
    List<Surfer> surfers = SurferDB.getSurfers();
    for(Surfer surfer : surfers) {
      if (!types.contains(surfer.getCountry())) {
        types.add(surfer.getCountry());
      }
    }
    return types;
  }
  /**
   * Returns an initialized Map of surfer types (when no type is selected).
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : getTypesFromDB()) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * Returns a Map of the selected surfer type.
   * @param surfType The type of surfer.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes(String surfType) {
    Map<String, Boolean> typeMap = Countries.getTypes();
    if (isType(surfType)) {
      typeMap.put(surfType,  true);
    }
    return typeMap;
  }

  /**
   * Returns true if surfType is valid type.
   * @param surfType The surfer type.
   * @return True if valid, else false.
   */
  public static boolean isType(String surfType) {
    return Countries.getTypes().keySet().contains(surfType);
  }
}
