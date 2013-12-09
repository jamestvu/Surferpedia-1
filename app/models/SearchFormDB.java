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
    String surferType = formData.get().genderType;
    String country = "";
    String slug = formData.get().slug;

    SearchData searchData = new SearchData(name, surferType, country, slug);

    // List<SearchData> searchList = new ArrayList<>();
    
    // clear previous data
    while (SearchData.find().all().size() != 0) {
      for (int i = 0; i < SearchData.find().all().size(); i++) {    
        SearchData.find().all().get(i).delete();
      }
    }

    // if everything is null, return full list
    if (name.isEmpty() && surferType.isEmpty()) {
      for (int i = 0; i < surfers.size(); i++) {
        searchData = new SearchData(surfers.get(i).getName(), surfers.get(i).getSurferType(), 
            surfers.get(i).getCountry(), surfers.get(i).getSlug());
            searchData.save();
      }      
    }
       
    else if (!name.isEmpty() && surferType.isEmpty()) {
      for (int i = 0; i < surfers.size(); i++) {
        if (surfers.get(i).getName().toLowerCase().contains(name)) {        
        searchData = new SearchData(surfers.get(i).getName(), surfers.get(i).getSurferType(), 
            surfers.get(i).getCountry(), surfers.get(i).getSlug());
        searchData.save();
      }      
      }
    }
    else {
    // create search list
    for (int i = 0; i < surfers.size(); i++) {
      /**
      if (surfers.get(i).getName() == null && surfers.get(i).getSurferType() == null) {
        searchData = new SearchData(surfers.get(i).getName(), surfers.get(i).getSurferType(), 
            surfers.get(i).getCountry(), surfers.get(i).getSlug());
        searchData.save();
        break;
      }
      */
      // if search not null and type not null
      if (surfers.get(i).getName().toLowerCase().contains(name) && surfers.get(i).getSurferType().equals(surferType)) {
        searchData = new SearchData(surfers.get(i).getName(), surfers.get(i).getSurferType(), 
                                    surfers.get(i).getCountry(), surfers.get(i).getSlug());
        searchData.save();
        }
      }
    }
    
    return SearchData.find().all();         
  }
  
  public static List<SearchData> getSearch() {
    return SearchData.find().all();
  }

}
