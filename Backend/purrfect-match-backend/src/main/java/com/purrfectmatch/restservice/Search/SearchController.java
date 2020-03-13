package com.purrfectmatch.restservice.Search;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.purrfectmatch.restservice.ValidationException;

import java.util.Date;



import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SearchController {
    @Autowired
    SearchService service;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public ResponseEntity search(@RequestBody SearchRequest req) {
        
        try {
            SearchValidator.validateSearchRequest(req);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(getInfoFromDb(req)); 
        } catch (ValidationException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        
    }
    
    private ResponseEntity getInfoFromDb(SearchRequest req) {
        switch (req.getSpecies()) {
            case CAT:
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(service.getCats(req));
            case DOG:
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Searching for dogs is not supported. ");
            case OTHER:
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Searching for other animals is not supported.");
            default:
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Searching for all types of pets at once is not supported. ");
        }
    }
}
