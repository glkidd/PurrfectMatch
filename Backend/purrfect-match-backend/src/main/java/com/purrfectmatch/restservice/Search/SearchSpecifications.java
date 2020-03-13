package com.purrfectmatch.restservice.Search;

import org.springframework.data.jpa.domain.Specification;

import com.purrfectmatch.restservice.Cats.Cat;
import com.purrfectmatch.restservice.Gender;
import java.time.LocalDate;

public class SearchSpecifications {
    
    public static <T> Specification<T> nop() {
        return (root, query, cb) -> {
            return cb.conjunction(); // Always true, apparently.
        };
    }
    
    public static <T> Specification<T> filterAtRisk() {
        return (root, query, cb) -> {
            return cb.isNotNull(root.get("euthanizeDate"));
        };
    }
    
    public static <T> Specification<T> filterByGender(Gender gender) {
        return (root, query, cb) -> {
            return cb.equal(root.get("gender"), gender);
        };
    }
    
    public static <T> Specification<T> filterByAge(LocalDate minBirthday, LocalDate maxBirthday) {
        Specification<T> minFilter = minBirthday == null ? nop() : (root, query, cb) -> {
            return cb.greaterThan(root.get("bday"), minBirthday);
        };
        
        Specification<T> maxFilter = maxBirthday == null ? nop() : (root, query, cb) -> {
            return cb.lessThan(root.get("bday"), maxBirthday);
        };
        
        return Specification.where(minFilter).and(maxFilter);
    }
}