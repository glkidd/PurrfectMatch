package com.purrfectmatch.restservice.Search;

import lombok.Data;

@Data
class SearchRequest {
    
    enum Species {
        CAT,
        DOG,
        OTHER,
        UNSET
    }
    
    enum Gender {
        MALE,
        FEMALE,
        OTHER,
        UNSET
    }
    
    enum SortMethod {
        RISK,
        DAYS,
        AGE
    }
    
    enum SortDir {
        ASC,
        DESC
    }
    
    private Species species;
    private boolean filterRisk;
    private String filterAge;
    private Gender filterGender;
    private String filterLocation;
    
    private SortMethod sortBy;
    private SortDir sortDirection;
    
    private int page;
    
    private SearchRequest() {}
    public SearchRequest(Species species, boolean filterRisk, String filterAge, Gender filterGender, String filterLocation, SortMethod sortBy, SortDir sortDir, int page) {
        this();
        this.species = species;
        this.filterRisk = filterRisk;
        this.filterAge = filterAge;
        this.filterGender = filterGender;
        this.filterLocation = filterLocation;
        
        this.sortBy = sortBy;
        this.sortDirection = sortDir;
        this.page = page;
        
    }

}