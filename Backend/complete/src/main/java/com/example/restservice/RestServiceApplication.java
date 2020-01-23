package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        // Can run in http://localhost:8083/greeting
        SpringApplication app = new SpringApplication(RestServiceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE SuccessStory IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE SuccessStory(" + "id SERIAL, imageName VARCHAR(255), name VARCHAR(255), "
                + "age VARCHAR(255), storyText VARCHAR(255), breed VARCHAR(255),"
                + "gender VARCHAR(255), adoptionDate VARCHAR(255), owner VARCHAR(255))");

        List<Object[]> successStories = new ArrayList<>();

        Object[] obj = new Object[] { "1", "cat.jpg", "Fluffles", "4", "Cute cat with a personality.", "Persian", "M",
                "10-24-2016", "Bob" };
        successStories.add(obj);

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.update(
                "INSERT INTO SuccessStory(id, imageName, name, "
                        + "age, storyText, breed, gender, adoptionDate, owner) VALUES (?,?,?,?,?,?,?,?,?)",
                successStories.get(0));
    }
}
