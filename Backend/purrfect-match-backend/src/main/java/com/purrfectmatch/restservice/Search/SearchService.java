package com.purrfectmatch.restservice.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.stereotype.Service;

import com.purrfectmatch.restservice.Cats.CatRepository;
import com.purrfectmatch.restservice.Cats.Cat;
import com.purrfectmatch.restservice.Dogs.DogRepository;
import com.purrfectmatch.restservice.Dogs.Dog;
import com.purrfectmatch.restservice.OtherAnimal.OtherAnimalRepository;
import com.purrfectmatch.restservice.OtherAnimal.OtherAnimal;
import org.springframework.data.jpa.domain.Specification;

import com.purrfectmatch.restservice.Gender;

import java.util.List;
import java.time.LocalDate;

@Service
public class SearchService {
    @Autowired
    CatRepository cats;
    @Autowired
    DogRepository dogs;
    @Autowired
    OtherAnimalRepository other;
    
    public static final int PAGE_SIZE = 25;
    
    public List<Cat> getCats(SearchRequest req) {
        Specification<Cat> filters = SearchSpecifications.nop();
        
        // Force filter by risk if sort by risk chosen, as apparently we can't put nulls last?
        if (req.isFilterRisk() || req.getSortBy() == SearchRequest.SortMethod.RISK) {
            filters = Specification.where(filters).and(SearchSpecifications.filterAtRisk());
        }
        
        switch (req.getFilterAge()) {
            case "< 1 year":
                filters = Specification.where(filters).and(SearchSpecifications.filterByAge(
                        LocalDate.now().minusYears(1), 
                        null));
                break;
            case "1-3 years":
                filters = Specification.where(filters).and(SearchSpecifications.filterByAge(
                        LocalDate.now().minusYears(3), 
                        LocalDate.now().minusYears(1)));
                break;
            case "4 years":
                filters = Specification.where(filters).and(SearchSpecifications.filterByAge(
                        LocalDate.now().minusYears(5), 
                        LocalDate.now().minusYears(3)));
                break;
            case "5+ years":
                filters = Specification.where(filters).and(SearchSpecifications.filterByAge(
                        null, 
                        LocalDate.now().minusYears(5)));
                break;
            default:
        }

        // Ugly, but we have 2 types of gender enums (one needs the unset value)
        switch (req.getFilterGender()) {
            case MALE:
                filters = Specification.where(filters).and(SearchSpecifications.filterByGender(Gender.MALE));
                break;
            case FEMALE:
                filters = Specification.where(filters).and(SearchSpecifications.filterByGender(Gender.FEMALE));
                break;
            case OTHER:
                filters = Specification.where(filters).and(SearchSpecifications.filterByGender(Gender.OTHER));
                break;
            case UNSET:
                break;
        }

        String sortColumn = null;
        switch (req.getSortBy()) {
            case RISK:
                sortColumn = "euthanizeDate";
                break;
            case AGE:
                sortColumn = "bday";
                break;
            case DAYS:
                sortColumn = "dateArrived";
                break;
            default:
                sortColumn = "No sort provided (somehow)? Oops!";
        }
        Order sorter = (new Order(req.getSortDirection() == SearchRequest.SortDir.ASC ? Sort.Direction.ASC : Sort.Direction.DESC,
                           sortColumn)).nullsLast();
        
        Pageable paging = PageRequest.of(req.getPage(), PAGE_SIZE, Sort.by(sorter));        
        Page<Cat> pagedResult = cats.findAll(filters, paging);
        return pagedResult.getContent();
        
    }
    
}