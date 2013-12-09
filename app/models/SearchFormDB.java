package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import play.data.Form;
import views.formdata.SearchFormData;
import views.formdata.SurferFormData;

/**
 * Provides in-memory repository for the search form data.
 * @author Jonathan Ortal
 */

public class SearchFormDB {

  /**
   * Adds a matched surfer to the search list.
   * @param formData The search data
   * @return the list of matches
   */
  public static List<SearchData> addSearch(Form<SearchFormData> formData) {
    List<Surfer> surfers = SurferDB.getSurfers();
        
    String name = formData.get().searchText;
    String surferType = "";
    String country = "";
    String slug = formData.get().slug;

    SearchData searchData = new SearchData(name, surferType, country, slug);

    // List<SearchData> searchList = new ArrayList<>();
    
    // clear previous data
    System.out.println("before: " + SearchData.find().all().size());

    while (SearchData.find().all().size() != 0) {
    for (int i = 0; i < SearchData.find().all().size(); i++) {    
      //if (SearchData.find().all().size() != 0) {
        System.out.println(i + ". " + SearchData.find().all().get(i).getSearchText());
        SearchData.find().all().get(i).delete();
      //}
    }
    }
    
    for (int i = 0; i < surfers.size(); i++) {
      if (surfers.get(i).getName().toLowerCase().contains(name)) {
        searchData = new SearchData(surfers.get(i).getName(), surfers.get(i).getSurferType(), 
                                    surfers.get(i).getCountry(), surfers.get(i).getSlug());
        searchData.save();
      }
    }
        
    return SearchData.find().all();         
  }
    /**
    else {
      for (int i = 0; i < surfers.size(); i++) {
        searchData = new SearchData(surfers.get(i).getName(), surfers.get(i).getSurferType(), 
            surfers.get(i).getCountry(), surfers.get(i).getSlug());        
        searchData.save();
      }
    }
    return SearchData.find().all();
  }
  **/
  
  public static void delSearch() {
    if (SearchData.find().all().size() != 0) {
      for (int i = 0; i < SearchData.find().all().size(); i++) {
        SearchData.find().all().clear();
        System.out.println("baleeted");
      }
    }
  }
  
  public static List<SearchData> getSearch() {
    return SearchData.find().all();
  }

}
