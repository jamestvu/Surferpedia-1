/**
 * Initializes the page with 3 surfers.
 * @author Jonathan Ortal
 *
 */
import play.GlobalSettings;
import play.Play;
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
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    String name = "Administrator";
    
    if (!UserInfoDB.adminDefined()) {
      UserInfoDB.defineAdmin(name, adminEmail, adminPassword);
      //Original 3 surfers
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
      
      //10 Female Surfers
      biotext =
          "Growing up in Hawaii, Megan quickly became one of the 'beach boys' and worked her way to a spot on the World Championship Tour ranks in 1998. She has been on the WCT ever since and in 2000 she was runner up for the world title. She has had many victories both in and out of the water. In October 2004 Megan won the WCT Rip Curl Malibu Pro and shot from 14th to 9th in the ratings. In 2002, she won the WCT Figueira Pro in Portugal, and in 2001 she won the WCT Roxy Pro in Fiji. Throughout her career she has had 5 other WCT victories.";
      
      SurferDB.addSurfer(new SurferFormData("Megan Abubo", "Haleiwa, HI", 
          "(2001) World Champion runner-up title", 
          "http://3.bp.blogspot.com/-nl_EJz88h5Q/UY_1lxtsUaI/AAAAAAAAAGU/MwFmaI4E598/s1600/MeganAbubo.jpg",
          "http://i515.photobucket.com/albums/t357/BrEezEbaby08/Celebs/meganabubo.jpg", 
          biotext, "meganabubo", "Female", "Regular", "USA"));
      
      biotext = "Lisa Andersen (born March 8, 1969, in [New York]) is a four-time world surfing champion from the United States. She won four titles in a row from 1994 to 1997. ASP Rookie of the year in 1987. Named by Sports Illustrated for Women as one of the 100 'Greatest Sportswomen of the Century'. Named 1998 Female Athlete of the Year by Conde'Nast Sports for Women magazine. Six time winner of Surfer Magazine's Readers Poll. She won the US amateur surfing title in 1987 and turned professional the following year. From 1994 to 1997 she won successive women's world titles before injury forced her to stop competing. She returned to the sport in 2000. She is married to Tim Shannon and has two children, Erica and Mason.";
      
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
      
      biotext = "Freida Zamba is a four-time world surfing champion from the United States. She won three titles in a row from 1984 to 1986, then won again in 1988. She currently lives in north-east Florida. Frieda Zamba was the youngest female to win a pro tour contest and the youngest surfing world champion ever. She went on to win three titles in a row and then fought back to win a fourth. Outright dangerous in small to mid-size surf, Zamba crossed the performance chasm that separated male and female surfers in the 80’s and, based solely on performance, is regarded by many as the greatest female surfer ever.";
      
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
      
      //10 Male Surfers
      //1
      biotext = "John John Florence , the oldest of three children, grew up in Hale'iwa, in an ocean-side house at the Banzai Pipeline. He resides with his mother, Alexandra, and his two younger brothers Nathan and Ivan. He was introduced to surfing by Alexandra, who is a surfer herself. Florence claims he rode a surf board at the age of six months, wearing a life vest on his father John's board;[1] he was riding on his own by the age of three. He is known now for his spectacular aerial abilities";
      SurferDB.addSurfer(new SurferFormData("John John Florence", "Honolulu, HI", 
          "2003 1st NSSA Nationals Open Mini Grom, the 2005 1st NSSA Nationals Open Boy's, the 2005 NSSA Open Boys and the Explorer Menehune Champion", 
          "http://a.espncdn.com/combiner/i?img=/photo/2013/0817/as_surf_jjf_2048.jpg&w=1200",
          "http://aloharemedy.com/wp-content/uploads/2013/04/john-john-florence_fe.jpg", 
          biotext, "johnflorence", "Male", "Goofy", "USA"));
      //2
      biotext = "In addition to the ASP tour, Slater has also competed in the X-Games (in 2003 and 2004). After " 
          + "earlier being awarded the title prematurely as a result of a miscalculation by the ASP, on November 6, 2011" 
          + " Slater officially won his eleventh ASP world title at the Rip Curl Pro Search San Francisco, by winning his"
          + " 4th round heat. In May 2005, in the final heat of the Billabong Tahiti Pro contest at Teahupo'o, Slater "
          + "became the first surfer ever to be awarded two perfect scores for a total 20 out of 20 points under the ASP "
          + "two-wave scoring system. (The corresponding honor under the previous three-wave system belongs to fellow "
          + "American Shane Beschen who achieved the feat in 1996.) He did it again on June 2013 at the quarter finals "
          + "at the Volcom Fiji Pro with two perfect ten waves, only the fourth person in history to do so.[3] Since "
          + "1990, Slater has been sponsored primarily by surfwear industry giant Quiksilver.[4] He exclusively rides "
          + "Channel Islands surfboards equipped with his own signature series of FCS fins.";
      SurferDB.addSurfer(new SurferFormData("Kelly Slater",
          "Cocoa Beach, Florida",
          "ASP World Tour Champion (11 times), Boost Mobile Pro (1st Place, 2007)",
          "http://costaricasurfing.org/wp-content/uploads/2013/07/Kelly-Slater-1.jpg",
          "http://www.athletepromotions.com/blog/wp-content/uploads/2013/08/kelly-slater.jpg",
          biotext,
          "kellyslater",
          "Male",
          "Regular",
          "USA"));
      //3
      biotext = "Adrian 'Ace' Buchan (born 21 September 1982, Avoca Beach, Australia) is a professional Australian surfer. He was introduced to the ocean by his father at age four and since then he has won numerous World Junior Championships in the under 16 and 18 divisions. He is sponsored by Hurley International, JS Industries, Dragon eyewear, Gorilla Grip, \"Surf Dive 'n' Ski\" and \"Zentrom Quantum technology\".";
      SurferDB.addSurfer(new SurferFormData("Adrian 'Ace' Buchan",
          "Avoca Beach, Australia",
          "2008 Quick Silver Pro France, 2013 Billabong Pro Teahupoo",
          "http://craigsand.com/wp-content/uploads/galleries/post-1266/full/IMG_9095.jpg",
          "http://cdn.c.photoshelter.com/img-get/I00008XoRjT2xhAo/s/860/860/Adrian-Buchan-Joli-FT5830.jpg",
          biotext,
          "adrianbuchan",
          "Male",
          "Goofy",
          "Australia"));
      //4
      biotext = "Adriano \"Mineirinho\" De Souza (born February 13, 1987) is a Brazilian professional surfer who competes on the Association of Surfing Professionals Men's World Tour";
      SurferDB.addSurfer(new SurferFormData("Adriano \"Mineirinho\" De Souza",
          "Guaruja, Sao Paulo, Brasil",
          "2013 Rip Curl Pro Bells Beach, 2011 Rip Curl Pro Portugal",
          "http://2.bp.blogspot.com/-3VpAuI6MB2w/UZp5mgbUjjI/AAAAAAAB2Fk/Liz91pgSomQ/s1600/240509SF36-copie.jpg",
          "http://4.bp.blogspot.com/-QH0CyNqHvTs/UZp5rVm69_I/AAAAAAAB2H0/Goh27iKVwJM/s1600/adriano-de-souza-portrait.jpg",
          biotext,
          "adrianodesouza",
          "Male",
          "Regular",
          "Brasil"));
      //5
      biotext = "Philip Andrew Irons (July 24, 1978 – November 2, 2010) was an American professional surfer. Irons learned to surf on the dangerous and shallow reefs of the North Shore in Kauai, Hawaii. He and his family hosted the Annual Irons Brothers Pinetrees Classic, a contest for youngsters. The Governor of Hawaii declared February 13 forever \"Andy Irons Day\". He is the only surfer to have won a title at every venue on the ASP calendar.\nIrons died on November 2, 2010. He was found lying in bed on his back with the sheets pulled up to his chin, by two hotel staff after he had failed to respond to knock on the door and they went in to investigate. The Tarrant County Medical Examiner's Office concludes that Irons died from a cardiac arrest due to a severe blockage of a main artery of the heart. The official autopsy report lists also a second cause of death as “acute mixed drug ingestion”, listing alprazolam, methadone, benzoylecgonine (a metabolite of cocaine) and traces of methamphetamine as the drugs found in Andy`s body at the time of his death. Initial press releases cited Dengue fever as the cause of Irons' death; however, the autopsy report conducted by the Tarrant County Medical Examiner's office were negative for Dengue and other flavivirus. It is unclear why rumors that Dengue fever contributed to Irons' death proliferated";
      SurferDB.addSurfer(new SurferFormData("Philip Andrew Irons",
          "Kuai, Hawaii",
          "2013 Rip Curl Pro Bells Beach, 2011 Rip Curl Pro Portugal",
          "http://2.bp.blogspot.com/-3VpAuI6MB2w/UZp5mgbUjjI/AAAAAAAB2Fk/Liz91pgSomQ/s1600/240509SF36-copie.jpg",
          "http://4.bp.blogspot.com/-QH0CyNqHvTs/UZp5rVm69_I/AAAAAAAB2H0/Goh27iKVwJM/s1600/adriano-de-souza-portrait.jpg",
          biotext,
          "philipirons",
          "Male",
          "Regular",
          "USA"));
      //6
      biotext = "Bede Durbidge (born 23 February 1983) is an Australian professional surfer. He is one of the most promising surfers of the ASP World Tour. Durbo, Bej and The White Fijian are his nicknames";
      SurferDB.addSurfer(new SurferFormData("Bede Durbridge",
          "Brisbane, Queensland",
          "2008 Hang Loose Santa Catarina, 2007 Rip Curl Pipeline Masters, 2006 Boost Mobile Pro",
          "http://a4.espncdn.com/combiner/i?img=/photo/2013/0926/as_surf_jordy_2048.jpg&w=1200",
          "http://s3.rockstarenergy.com/cache/384x475-RESIZE-100/2013/01/bede-durbidge-profile.jpg",
          biotext,
          "bededurbridge",
          "Male",
          "Regular",
          "Australia"));
      //7
      biotext = "A 2-year-old Ben Bourgeois told his mother flatly, \"I wanna be a surfer.\" And he hasn't wavered since. Far from being blessed with an ideal surfing environment or an inordinate amount of natural talent, he used the attributes he was given -- a supportive family and a will to succeed -- and rose to the elite in competitive surfing, the Top 44 in the world, restoring Wrightsville Beach's place on the international map.";
      SurferDB.addSurfer(new SurferFormData("Ben Bourgeois",
          "Ocean City, New Jersey",
          "1995 Quiksilver World Grommet Contest",
          "http://cdn.business.transworld.net/files/2008/05/04/ben-bourgeois-surf.jpg",
          "http://a3.espncdn.com/photo/2009/0430/as_surf_benny_shower_630.jpg",
          biotext,
          "benbourgeois",
          "Male",
          "Goofy",
          "USA"));
      //8
      biotext = "It's impossible to picture Australian surf history without Bob McTavish. In a nation where the surfing culture slumbered for years beyond the Californian Malibu explosion, McTavish was one of the first to awaken. His willingness to devote himself to what seemed an outlandish outlaw sport paid off for the millions of Aussies who followed him -- and other such single-minded souls -- into the surf.";
      SurferDB.addSurfer(new SurferFormData("Bob McTavish",
          "Mackay, Northern Queensland",
          "1966 World Contest",
          "http://www.surf-shop.org/wp-content/uploads/2009/12/IMG_9700.jpg",
          "http://epikoo.com/sites/default/files/bob3.jpg",
          biotext,
          "bobmctavish",
          "Male",
          "Goofy",
          "Australia"));
      //9
      biotext = "Martinez began surfing at age 6. When he was old enough, he joined the National Scholastic Surfing Association (NSSA) where he went on to win a record seven national titles. After several injury prone years he joined the Association of Surfing Professionals in 2005. His first major title as a professional was the O'Neill Coldwater Classic in 2005. He joined the World Championship Tour in 2006, finishing the year with No. 5 ranking which earned him Rookie of the Year honors with wins in Teahupoo and Mundaka.[2] He also won in Mundaka in 2007 and In May 2009, Bobby won the Billabong Pro Tahiti.";
      SurferDB.addSurfer(new SurferFormData("Bobby Martinez",
          "Santa Barbara, California",
          "Top 10 finisher on the ASP World Tour 2010",
          "http://billabong.africanmediacentre.com/BBong_Pro_EMK09JBay/High_Res_Images/BB9%20-%20EMK%20-%20World%20Tour%20Stars/Bilp9%20-%20Bobby%20Martinez/Bobby%20Action1%20-Steve%20Robertson-ASP-CI%20via%20Getty%20Images.jpg",
          "http://cdn.surf.transworld.net/files/2010/01/45.jpg",
          biotext,
          "bobbymartinez",
          "Male",
          "Goofy",
          "USA"));
      //10
      biotext = "Duke Paoa Kahinu Mokoe Hulikohola Kahanamoku (August 24, 1890 – January 22, 1968) was a Hawaiian competition swimmer who was also known as an actor, lawman, early beach volleyball player and businessman credited with spreading the sport of surfing.[1] Kahanamoku was a five-time Olympic medalist in swimming.";
      SurferDB.addSurfer(new SurferFormData("Duke Kahanamoku",
          "Honolulu, Hawaii",
          "3 Gold Medals and 2 Silver Medals in the Olympics for Swimming/Water Polo",
          "http://www.hawaiipictureoftheday.com/wp-content/uploads/2012/04/honolulu-surfer-bartlett-wm.jpg",
          "http://upload.wikimedia.org/wikipedia/commons/8/8b/Duke_P._Kahanamoku_(LOC)_(06652).jpg",
          biotext,
          "dukekahanamoku",
          "Male",
          "Regular",
          "USA"));
      
      //Groms ---------------------------------------------------------------------------------------------
      //1
      biotext = "Madison has found plenty of success in the Mid Atlantic in the 2013 season. At the Nags Head event 3 in chest high surf, she cashed in on the fun waves posting the top wave score and won both the Open & Explorer Womens";
      SurferDB.addSurfer(new SurferFormData("Madison Huckabee",
          "Wrightsville Beach, North Carolina",
          "Open & Explorer Womens",
          "http://www.nssa.org/upload/thumb_150x150_madisoncrop.jpg",
          "http://www.nssa.org/upload/thumb_150x150_madisoncrop.jpg",
          biotext,
          "madisonhuckabee",
          "Grom",
          "Regular",
          "USA"));
      //2
      biotext = "Many young surfers have the potential to make an impact on our sport, but none look more poised to do so"
          + " than Jake Marshall. Raised on the rippable beachbreaks and reefs of San Diego North County, Jake has developed "
          + "a solid base of smooth rail work as well as the kind of flair that few 14-year-old surfers can match. His progression "
          + "is due in no small part to the numerous world-class talents in his neighborhood that have taught him a thing or"
          + " two about tearing Seaside apart. see Rob Machado, Josh Kerr, Damien Hobgood, and Taylor Knox out all the time,"
          + " and its really fun to surf with guys on that level look at them and think, thats how I have to surf if I want"
          + " to make the Tour one day.That really helps me push my limits, hes had remarkable success in a jersey, including"
          + " a recent win at the U.S. Surfing Championships at Lower Trestles. But while surf stardom seems inevitable for "
          + "Jake, hes still just a kid, and knows where his priorities should be. surf and try to improve all the time, but "
          + "I still put a lot of emphasis on school, know that education is really important, and if surfing doesnt work out,"
          + " its always good to have a backup plan";
      
      SurferDB.addSurfer(new SurferFormData("Jake Marshall",
          "Encinitas, California",
          "13-14 SW Open Season,",
          "http://www.surfingamerica.org/wp-content/uploads/2011/01/JakeMarshall_MG_3530-3.jpg",
          "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/JakeMarshall01-677x442.jpg",
          biotext,
          "jakemarshall",
          "Grom",
          "Regular",
          "USA"));
      //3
      biotext = "Without a doubt, Tyler has HB’s infamous southside wired. Not only did the Newport standout win his first Nationals here in 2011 triumphing in the Open Mini Groms, but he stamped his authority at this weekend’s SW Open event 2 taking an impressive win in the hotly contested Juniors division.";
      SurferDB.addSurfer(new SurferFormData("Tyler Gunter",
          "Newport Beach, California",
          "2008,2009 WSA Championships, 2011 Nationals Mini groms",
          "http://atwatercollection.com/images/tg1.png",
          "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2012/11/tyler-gunter.jpg",
          biotext,
          "tylergunter",
          "Grom",
          "Regular",
          "USA"));
      //4
      biotext = "Contest results don’t get more perfect than this! In small, challenging conditions at the Mid Atlantic Outer Banks event in Nags Head, East Coast Champion Luke Gordon put forth one heck of a stellar performance winning Open Mens, Open Juniors, Explorer Juniors & Explorer Boys";
      SurferDB.addSurfer(new SurferFormData("Luke Gordon",
          "Pawleys Island, South Carolina",
          "Rip Curl GromSearch National Championships, Nags Head",
          "http://i.cdn-surfline.com/surfnews/images/2012/10_october/SAPrime_AC/full/LukeGordon_AM7H6993.jpg",
          "http://www.surfline.com/surfnews/images/2012/05_may/SAPrime_Nags/full/LukeGordon_IMG_2533.jpg",
          biotext,
          "lukegordon",
          "Grom",
          "Regular",
          "USA"));
      //5
      biotext = "Mahina came out firing on all cylinders in her debut contest of the 2013-14 NSSA Hawaii season with a double win in the Open & Explorer Womens divisions at the Lahaina Harbor contest. She was pushing the level with her powerful turns in each heat. Mahina continues to show that she is one of the most talented and dynamic young female surfers in the nation.";
      SurferDB.addSurfer(new SurferFormData("Mahina Maeda",
          "Sunset Beach, Hawaii",
          "2013-14 NSSA Hawaii season with a double win in the Open & Explorer Womens divisions",
          "http://www.nssa.org/upload/thumb_200x150_photo%20%281%29.jpg",
          "http://www.sexwax.com/riders/mahina_maeda_sw_web_2%281%29.jpeg",
          biotext,
          "mahinamaeda",
          "Grom",
          "Regular",
          "USA"));
      //6
      biotext = "Malia put together a huge year taking 3 conference titles in Open Girls, Explorer Girls & Womens. She sealed the Open Girls in perfect surf at Lowers and the Explorer titles in small peaks at Crystal Pier. Her surfing has shown big improvement and versatility as proven by her victories in diverse conditions";
      SurferDB.addSurfer(new SurferFormData("Malia Osterkamp  ",
          "San Clemente, California",
          "Open Girls, Explorer Girls & Womens",
          "http://www.nssa.org/upload/thumb_200x150_mosterkampsow5-13.jpg",
          "http://www.surfsss.org/wp-content/uploads/2012/05/malia_osterkamp.jpg",
          biotext,
          "maliaosterkamp",
          "Grom",
          "Regular",
          "USA"));
      //7
      biotext = "   Seth capitalized on the fun 2-4 foot surf at Kewalos during the Hawaii Regional Championships. He claimed 3 titles in Open Juniors, Explorer Juniors & the premier Open Mens. Look out for Seth at the Nationals after this dominating performance";
      SurferDB.addSurfer(new SurferFormData("Seth Moniz",
          "Honolulu, Hawaii",
          "2013 King of the Groms,3 titles in Open Juniors, Explorer Juniors & the premier Open Mens",
          "http://1.bp.blogspot.com/_Xid45Cz66D8/SxTNWmFgAOI/AAAAAAAAAf4/zKIrCYtxw-M/s1600/seth:spenc:backd09.jpg",
          "http://www.novusswell.com/wp-content/uploads/2012/05/Screen-shot-2012-05-06-at-11.25.10-AM.png",
          biotext,
          "sethmoniz",
          "Grom",
          "Regular",
          "USA"));
      //8
      biotext = "Tommy put on a monster of a performance to kick off the 13/14 Gold Coast Season taking double wins in event 1 in the Menehuene & Boys divisions. He returned the next day for event 2 and backed it up with another Menehuene win earning a huge 18.8 total score in the final-the highest of the weekend";
      SurferDB.addSurfer(new SurferFormData("Tommy McKeown",
          "Oxnard, California",
          "13/14 Gold Coast Season taking double wins in event 1 in the Menehuene & Boys divisions",
          "http://b.vimeocdn.com/ts/259/046/259046810_640.jpg",
          "http://www.nssa.org/upload/thumb_200x150_photo%288%29.jpg",
          biotext,
          "tommymckeown",
          "Grom",
          "Regular",
          "USA"));
      //9
      biotext = "Noah was pushing the performance envelope at the Newport Open surfing well beyond his years. The kid was on fire unleashing man hacks, airs, big carves and even pulled into a few clean barrels winning all of his heats and taking his second straight Open Boys victory";
      SurferDB.addSurfer(new SurferFormData("Noah Hill",
          "Lahaina, Hawaii",
          "Open Boys,2013",
          "https://fbcdn-sphotos-a-a.akamaihd.net/hphotos-ak-ash3/p480x480/555819_10152731956140125_281550280_n.jpg",
          "http://www.oneillclothing.com/blog/wp-content/uploads/2013/07/noah_5.jpg",
          biotext,
          "noahhill",
          "Grom",
          "Regular",
          "USA"));
      //10
      biotext = "Sam is the newest hot grom on the rise in the Norcal territory. At the Northwest doubleheader at Santa Cruz’s Pleasure Point & the Hook, he took command of the Boy’s division winning both finals. His surfing has greatly progressed this year as noted by his 4 straight win.";
      SurferDB.addSurfer(new SurferFormData("Sam Coffey",
          "Santa Cruz, California",
          "Santa Cruz Boys division",
          "http://www.nssa.org/photogallery/gallery/2012-13_SEASON/SolomonSamNWSC3-13web.jpg",
          "http://www.santacruzwaves.com/wordpress/wp-content/uploads/428b3a623c406a01f2a4360fbbcceb96.jpg",
          biotext,
          "samcoffey",
          "Grom",
          "Regular",
          "USA"));
      
    }
  }
}
