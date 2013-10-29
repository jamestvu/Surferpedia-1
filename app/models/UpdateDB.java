package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates a database keeping track of the updates.
 * 
 * @author AJ
 *
 */
public class UpdateDB {

  private static List<Update> updates = new ArrayList<>();
  
  /**
   * Adds an update to the updates page.
   * @param time the time of the action
   * @param name the name of the surfer
   * @param pageType what kind of page is active
   */
  public static Update addUpdate(String time, String name, String pageType) {
    Update update = new Update(time, name, pageType);
    updates.add(update);
    return update;
  }

  public static List<Update> getUpdate() {
    return updates;
  }

}
