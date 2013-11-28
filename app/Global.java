/**
 * Initializes the page with 3 surfers.
 * @author Jonathan Ortal
 *
 */
import play.GlobalSettings;
import models.SurferDB;
import models.UserInfoDB;
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

    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    
    String biotext = "Edward Ryan Makua Hanai Aikau (May 4, 1946 - March 17, 1978) was a well-known "
        + "Hawaiian lifeguard and surfer. As the first lifeguard at Waimea Bay on the island of Oahu, "
        + "he saved many lives and became well known as a big-wave surfer in his own right.";
    
    SurferDB.addSurfer(new SurferFormData("Eddie Aikau", "Haleiwa, HI", "Lifeguard of the Year", 
                                           "https://s3.amazonaws.com/tribeca_cms_production/uploads/uploads/film/"
                                          + "photo_1/51471ed0c07f5d4659000002/large_Hawaiian_2_PUBS.jpg",
                                           "http://s4.hubimg.com/u/2241487_f260.jpg", 
                                           biotext, 
                                           "eddieaikau", 
                                           "Male", "Regular", "USA"));
   
    biotext = "Joyce Hoffman (born 1946/47) is an American surfer, considered a woman's pioneer "
        + "in her sport.She is often regarded as the first female international surfing star and "
        + "was one the first inductees of the International Surfing Hall of Fame.";
    
    SurferDB.addSurfer(new SurferFormData("Joyce Hoffman", "Dana Point, CA", 
        "First female to surf the Banzai Pipeline in Hawaii, 1968", 
        "http://www.surfingwalkoffame.com/images/woman/Hoffman.jpg",
        "http://media.hamptonroads.com/cache/files/images/blogs/128341.jpg",
        biotext, "joycehoffman", "Female", "Regular", "USA"));

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
        biotext, "jakemarshall", "Grom", "Regular", "USA"));
    
    biotext =
        "Growing up in Hawaii, Megan quickly became one of the 'beach boys' and worked her way to a spot on the World Championship Tour ranks in 1998. She has been on the WCT ever since and in 2000 she was runner up for the world title. She has had many victories both in and out of the water. In October 2004 Megan won the WCT Rip Curl Malibu Pro and shot from 14th to 9th in the ratings. In 2002, she won the WCT Figueira Pro in Portugal, and in 2001 she won the WCT Roxy Pro in Fiji. Throughout her career she has had 5 other WCT victories.";
    
    SurferDB.addSurfer(new SurferFormData("Megan Abubo", "Haleiwa, HI", 
        "(2001) World Champion runner-up title", 
        "http://3.bp.blogspot.com/-nl_EJz88h5Q/UY_1lxtsUaI/AAAAAAAAAGU/MwFmaI4E598/s1600/MeganAbubo.jpg",
        "http://i515.photobucket.com/albums/t357/BrEezEbaby08/Celebs/meganabubo.jpg", 
        biotext, "meganabubo", "Female", "Regular", "USA"));
    
    biotext = "Lisa Andersen (born March 8, 1969, in [New York])[1] is a four-time world surfing champion from the United States. She won four titles in a row from 1994 to 1997. ASP Rookie of the year in 1987. Named by Sports Illustrated for Women as one of the 100 'Greatest Sportswomen of the Century'. Named 1998 Female Athlete of the Year by Conde'Nast Sports for Women magazine. Six time winner of Surfer Magazine's Readers Poll. She won the US amateur surfing title in 1987 and turned professional the following year. From 1994 to 1997 she won successive women's world titles before injury forced her to stop competing. She returned to the sport in 2000. She is married to Tim Shannon and has two children, Erica and Mason.";
    
    SurferDB.addSurfer(new SurferFormData("Lisa Andersen", "San Clemente, CA", 
        "Four-time world surfing champion, ASP Rookie of the Year (1987)", 
        "http://www.freaksurfmag.com/Images/lisa-andersen.jpg",
        "http://www.sports-wired.com/women/images/Lisa_Andersen/603.jpg", 
        biotext, "lisaandersen", "Female", "Regular", "USA"));
    
    biotext = "Christa Alves of Cocoa Beach has been doing nothing but winning. In four short years of competition, she’s put more first place trophies on her shelf than most career competitors. At 17, Christa has quickly jumped rank from budding amateur to promising pro. Unlike most of the names listed above Christa isn’t a lifelong surfer, she found her ocean muse six years ago. ";
    
    SurferDB.addSurfer(new SurferFormData("Christa Alves", "Cocoa Beach, FL", 
        "", 
        "http://4.bp.blogspot.com/_yzNMmCQCiFo/TPV9RI5-DEI/AAAAAAAAARI/HBAaOe_xDAw/s640/Christa+Alves+surf.jpg",
        "http://1.bp.blogspot.com/_yzNMmCQCiFo/TPV9QtdsYUI/AAAAAAAAARE/ErijrLYPLrs/s640/christa+alves+babe.jpg", 
        biotext, "Christa Alves", "Female", "Regular", "USA"));
    
    biotext = "Freida Zamba is a four-time world surfing champion from the United States. She won three titles in a row from 1984 to 1986, then won again in 1988.[1] She currently lives in north-east Florida. Frieda Zamba was the youngest female to win a pro tour contest and the youngest surfing world champion ever. She went on to win three titles in a row and then fought back to win a fourth. Outright dangerous in small to mid-size surf, Zamba crossed the performance chasm that separated male and female surfers in the 80’s and, based solely on performance, is regarded by many as the greatest female surfer ever.";
    
    SurferDB.addSurfer(new SurferFormData("Freida Zamba", "Flagler Beach, FL", 
        "Four-time ASP World Surfing Champion, Five-time Surfer Poll Awards, East Coast Surfer Hall of Fame", 
        "http://www.jettygirl.com/features/images/gallery_16/frieda.zamba.02.jpg",
        "http://www.eastcoastwahines.com/archives/images/photos/freida_sm.jpg", 
        biotext, "freidazamba", "Female", "Goofy", "USA"));
    
    biotext = "Rochelle Ballard is a professional female surfer who and veteran of the Association of Surfing Professional’s (ASP) World Championship Tour. She is considered the best female tube rider in the world and has been a pioneer to the advancement of women’s surfing in the past two decades. Ballard's mastery of big waves and support of women's surfing rank her among the surfing most elite. She also co-founded International Women's Surfing (IWS) and has appeared in several movies and television shows, most notably Step Into Liquid, Blue Crush, and Beyond the Break. In 2012 she won first in the Women's Division ISA World Masters Surfing Championship.";

    SurferDB.addSurfer(new SurferFormData("Rochelle Ballard", "Montebello, CA", 
        "Women's Division ISA World Masters Surfing Champion (2012)", 
        "http://www.surfscience.com/images/stories/TheSurfLife/LifeAsASurfer/rochelle%20ballard%20surfing%20yoga.jpg",
        "http://surfintoyoga.com/wp-content/uploads/2011/03/ro-bio21.jpg", 
        biotext, "rochelleballard", "Female", "Regular", "USA"));

    biotext = "Wendy Botha need only be referred to as an outstanding competitive surfer. She surfed with a stylish, confident approach that became the bane of even the best women (and some men) surfers of the era. She competed all over the world and even shut down Frieda Zamba’s seemingly unstoppable campaign to rule professional surfing. She went on to literally dominate the 1989 season with an insane 7 wins, and when all was said and done, had secured 4 world titles. That said, to quote Jerry Seinfeld, Botha “also possesses all the other qualities prized by the superficial male” which led to a nude photo spread in Australian Playboy, stirring up mixed emotions among surfers worldwide. For a girl described as having a “naturally nervous disposition,” Wendy Botha has carved a rather wide notch into the history of women’s surfing.";
    
    SurferDB.addSurfer(new SurferFormData("Wendy Botha", "East London, South Africa", 
        "Four-time Word Surfing Champion (1987, 1989, 1991-92)", 
        "http://www.surfline.com/surfaz/images/botha_wendy/chang_wbotha2.jpg",
        "http://www.surfline.com/surfaz/images/botha_wendy/chang_wbotha_port.jpg", 
        biotext, "wendybotha", "Female", "Regular", "South Africa"));
    
    biotext = "Mary Ann Hawkins was the undisputed standout woman surfer of the 1930s, winning the Pacific Coast Women’s Surfboard Championship in 1938, 1939 and 1940. She was also attractive, prompting one surf journalist to write that she had “the figure and looks of a movie star” and was “grace personified in the water.” From 1938 to 1940, Mary Ann reigned as the women’s division champion of the Pacific Coast Surfboard Championships, and was also the paddleboard champion. In the late 1930s, aquaplaning was also a popular sport in southern California. The Catalina Aquaplane Race was a 44-mile pull from Avalon, on Catalina Island, to Hermosa Beach, and Mary Ann won that, as well.";
    
    SurferDB.addSurfer(new SurferFormData("Mary Ann Hawkins", "Pasadena, CA", 
        "Pacific Coast Women's Surferboard Champion (1938-40)", 
        "http://4.bp.blogspot.com/-Y1LcljbXRBw/UWI1e3aiEqI/AAAAAAAAGeU/cyFBXmAH3SQ/s1600/blake_mary&bud1.JPG",
        "http://thebluegrassspecial.com/archive/2011/august2011/imagesaugust2011/first-women-1953.jpg", 
        biotext, "maryanhawkins", "Female", "Regular", "USA"));
    
    biotext = "Many still think that watching the top female pros is the miracle cure for insomnia. There are exceptions, but in general, the girls aren't exactly going balls out. In the mid-'70s, women were still trying to prove that they deserved a tour, and graceful daredevils such as Lynne Boyer and Margo Oberg stepped up to the plate in waves of consequence. Oberg not only dominated womens' surfing over three decades, she was considered worth watching by even the most hardened sexists. When little Oberg was five, the Godfreys moved from Pennsylvania to the affluent beach scene of La Jolla. She rode rubber rafts, played competitive tennis and began surfing at age 10 to be a part of the fad. But in her debut contest, she knew she was on to something. As the youngest competitor, she took out the Open Womens division. The same year, she won a coed Menehune event and her future was written. By the time Oberg reached High school, her resume spoke for itself: she was coached by her idol Mike Doyle, learned strategy from Corky Carroll and based her style on that of Skip Frye. At the age of 15, she won the 1968 World Contest, the Western Surfing Association's Women's title and the Surfer Poll.";
    
    SurferDB.addSurfer(new SurferFormData("Margo Oberg", "Poipu, HI", 
        "Three-time World Champion", 
        "http://www.surfline.com/surfaz/images/oberg_margo/chang_moberg2.jpg",
        "http://www.surfline.com/surfaz/images/oberg_margo/barbour_moberg_port.jpg", 
        biotext, "margooberg", "Female", "Regular", "USA"));
    
    biotext = "Once known as 'Gidget' for her grommethood antics along the Sydney, Australia, beach where she grew up, Layne Beachley has developed into the finest power surfer and most committed competitor of her generation. When it comes to Y2K-style personal empowerment -- and tow surfing off Phantom Reef -- Beachley has no serious rivals among today's extraordinary crop of women pro surfers.";
    
    SurferDB.addSurfer(new SurferFormData("Layne Beachley", "Sydney, Australia", 
        "Seven-time World Surfing Champion", 
        "http://www.surfline.com/surfaz/images/beachley_layne/russi_lbeachley2.jpg",
        "http://www.surfline.com/surfaz/images/beachley_layne/chang_lbeachley_port.jpg", 
        biotext, "laynebeachley", "Female", "Regular", "Australia"));
    
    biotext = "Bethany Hamilton has become a source of inspiration to millions through her story of faith, determination, and hope. Born into a family of surfers on February 8, 1990, on the island of Kauai, Hawaii, Bethany began surfing at a young age. At the age of eight, Bethany entered her first surf competition, the Rell Sun Menehune event on Oahu, where she won both the short and long board divisions. This sparked a love for surf competition within her spirit.";
    
    SurferDB.addSurfer(new SurferFormData("Bethany Hamilton", "Kauai, HI", 
        "NSSA National Champion (2005)", 
        "http://3.bp.blogspot.com/-O__hUWUwkZ0/UKPl2EZ0Y2I/AAAAAAAAABs/qxInyzkSCCU/s1600/Bethany+Meilani+Hamilton4.jpg",
        "http://static.grindtv.com/images/1/00/30/88/81/308881.jpg", 
        biotext, "bethanyhamilton", "Female", "Regular", "USA"));
        
  }
}
