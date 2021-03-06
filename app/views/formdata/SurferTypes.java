package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents surfer types.
 */

public class SurferTypes {
  
  private static String[] types = {"Male", "Female", "Grom"};
  
  /**
   * Returns an initialized Map of surfer types (when no type is selected).
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
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
    Map<String, Boolean> typeMap = SurferTypes.getTypes();
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
    return SurferTypes.getTypes().keySet().contains(surfType);
  }
}
