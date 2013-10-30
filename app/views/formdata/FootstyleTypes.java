package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents surfer types.
 */

public class FootstyleTypes {
  
  private static String[] types = {"Regular", "Goofy"};
  
  /**
   * Returns an initialized Map of surfer types (when no type is selected).
   * @return The surfer type map.
   */
  public static List<String> getFootTypes() {
    List<String> footList = new ArrayList<>();
    for (String type : types) {
      footList.add(type);
    }
    return footList;
  }
  
  /**
   * Returns a List of the selected surfer type.
   * @param surfType The type of foot.
   * @return The foot type list.
   */
  public static List<String> getFootTypes(String footstyleType) {
    List<String> footList = FootstyleTypes.getFootTypes();
    footList.add(footstyleType);
    return footList;
  }

}
