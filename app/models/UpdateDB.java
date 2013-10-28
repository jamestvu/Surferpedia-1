package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates a database keeping track of the updates.
 * 
 * @author AJ
 *
 */
public class UpdateDB {

  private static Map<String, String> surferPage = new HashMap<>();
  private static Map<String, String> surferTimes = new HashMap<>();
  
  
  /**
   * Adds an update to the updates page.
   * 
   * @param time the time of the action
   * @param name the name of the surfer
   * @param pageType what kind of page is acticve
   */
  public static void addUpdate(String time, String name, String pageType) {
    surferPage.put(name, pageType);
    surferTimes.put(time, name);
  }
  
  /**
   * Returns the Time and name of the surfer.
   * @return surferTimes
   */
  public static Map<String, String> returnTime() {
    return surferTimes;
  }
  
  /**
   * Returns the Surfer page and surfer name.
   * @return surferPage
   */
  public static Map<String, String> pageTypes() {
    return surferPage;
  }
}
