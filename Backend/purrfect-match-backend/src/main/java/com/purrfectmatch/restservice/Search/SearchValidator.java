package com.purrfectmatch.restservice.Search;

import com.purrfectmatch.restservice.ValidationException;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class SearchValidator {
    public static void validateAgeFilter(String filter) throws ValidationException {
        final Set<String> allowedValues = Stream.of("", "< 1 year", "1-3 years", "4 years", "5+ years")
                .collect(Collectors.toCollection(HashSet::new));
        if (!allowedValues.contains(filter)) {
            throw new ValidationException("Age filter value is invalid: " + filter);
        }
    }
    
    public static void validateLocationFilter(String filter) throws ValidationException {
        // match strings of exactly 5 digits, note that \A is start of input and \z is end of input.
        if (!filter.matches("\\A[0-9]{5}\\z")) {
            throw new ValidationException("Zip code is invalid: " + filter);
        }
    }
    
    public static void validateSortFilter(SearchRequest.SortMethod method, SearchRequest.SortDir dir) throws ValidationException {
        // Sort by days or risk needs to be ascending
        if (method == null) {
            throw new ValidationException("Sort method can not be null");
        }
        if (dir == null) {
            throw new ValidationException("Sort direction can not be null");
        }
        if ((method == SearchRequest.SortMethod.DAYS || method == SearchRequest.SortMethod.RISK) && dir == SearchRequest.SortDir.DESC) {
            throw new ValidationException("Invalid sort order for " + method.toString());
        }
    }
    
    public static void validatePage(int pageNum) throws ValidationException {
        if (pageNum < 0) {
            throw new ValidationException("Invalid page number " + String.valueOf(pageNum));
        }
    }
    
    public static void validateSearchRequest(SearchRequest req) throws ValidationException {
        validateAgeFilter(req.getFilterAge());
        validateLocationFilter(req.getFilterLocation());
        validateSortFilter(req.getSortBy(), req.getSortDirection());
        validatePage(req.getPage());
    }
}