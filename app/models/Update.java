package models;
/**
 * 
 * 
 *
 */
public class Update {
  
  private String time;
  private String name;
  private String page;  
  
  /**
   * Creates a new contact.
   * @param id The ID.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public Update(String time, String name, String page) {
    this.setTime(time);
    this.setName(name);
    this.setPage(page);
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }
  
}
