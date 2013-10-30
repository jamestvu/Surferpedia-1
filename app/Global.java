/**
 * Initializes the page with 3 surfers.
 * @author Jonathan Ortal
 *
 */
import play.GlobalSettings;
import models.SurferDB;
import views.formdata.SurferFormData;
import play.Application;

/**
 * Global settings for the application, for testing purposes.
 * @author Jonathan Ortal 
 */
public class Global extends GlobalSettings {
  
  /**
   * Initializes the database with three surfers.
   * @param app The surfer application.
   */
  public void onStart(Application app) {
    
    String biotext = "Edward Ryan Makua Hanai Aikau (May 4, 1946 - March 17, 1978) was a well-known "
        + "Hawaiian lifeguard and surfer. As the first lifeguard at Waimea Bay on the island of Oahu, "
        + "he saved many lives and became well known as a big-wave surfer in his own right.";
    
    SurferDB.addSurfer(new SurferFormData("Eddie Aikau", "Haleiwa, HI", "Lifeguard of the Year", 
                                           "https://s3.amazonaws.com/tribeca_cms_production/uploads/uploads/film/"
                                          + "photo_1/51471ed0c07f5d4659000002/large_Hawaiian_2_PUBS.jpg",
                                           "http://s4.hubimg.com/u/2241487_f260.jpg", 
                                           biotext, 
                                           "eddieaikau", 
                                           "Male", "Regular"));
   
    biotext = "Joyce Hoffman (born 1946/47) is an American surfer, considered a woman's pioneer "
        + "in her sport.She is often regarded as the first female international surfing star and "
        + "was one the first inductees of the International Surfing Hall of Fame.";
    
    SurferDB.addSurfer(new SurferFormData("Joyce Hoffman", "Dana Point, CA", 
        "First female to surf the Banzai Pipeline in Hawaii, 1968", 
        "http://www.surfingwalkoffame.com/images/woman/Hoffman.jpg",
        "http://media.hamptonroads.com/cache/files/images/blogs/128341.jpg",
        biotext, "joycehoffman", "Female", "Regular"));

    biotext = "What sets Jake apart from the current crop of young talent is his drive to excel in "
        + "his surfing, and whatever else he takes aim at. He's fiercely competitive, winning the "
        + "Under-12 division at the Surfing America Championships at Trestles last summer as the youngest "
        + "member of the USA team. But his focus isn't limited to competitive surfing. Jake is a straight-A "
        + "student, and takes better care of himself than most seasoned pros with a strict vegetarian diet "
        + "and a daily yoga regimen. With such a solid base already established, he should have no trouble moving "
        + "up through the ranks in the coming years.";
    
    SurferDB.addSurfer(new SurferFormData("Jake Marshall", "Encinitas, CA", 
        "Winner of the Under-12 Division, Surfing America Championships", 
        "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/JakeMarshall01-677x442.jpg",
        "http://www.surfingamerica.org/wp-content/uploads/2011/01/JakeMarshall_AM7H9425-2.jpg", 
        biotext, "jakemarshall", "Grom", "Regular"));
    
  }
}
