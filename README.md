# PurrfectMatch

## Travis CI:
https://travis-ci.com/fuzzything44/PurrfectMatch.svg?token=iUGHcFiNn7eYsBwfpF1C&branch=master

## Steps to run the application:

1. Navigate to the backend in the `Backend/purrfect-match-backend` directory and run `./gradlew bootRun`. The backend should run on port 8080.
2. Navigate to the frontend in the `purrfect-match` directory and run `npm start`. The frontend should run on port 3000.

## Backend Scripts:

In the backend directory `Backend/purrfect-match-backend`, run:

## `./gradlew bootRun`

This will lauch the backend on port 8080 (as coded in RestServiceApplication.java)

## `./gradlew test`

This will run the Selenium acceptance tests. Please make sure that the frontend is running first (via `npm start` in the frontend `purrfect-match` directory).

## Frontend Scripts:

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

In the frontend directory `purrfect-match`, you can run:

### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the Jest testing suite.

### `npm run snap`

Updates the Jest snapshot tests.


### Other Links:

Static Source Code Analysis Report: https://sonarcloud.io/dashboard?id=fuzzything44_PurrfectMatch

Testing Strategy Document: https://docs.google.com/document/d/1z0P4YRyq59UNlns6R-Qfw-GGfIXZKqM5RGmSV4rejWk/edit

Unit/Integration Tests Coverage Report: https://drive.google.com/open?id=1h5C5dzIUg0SRMCNr3pdympkkHmIkvUG7
Unit/Integration Tests Location: `purrfect-match/test`

Acceptance Tests Spec: https://docs.google.com/document/d/13LgOD3Ayk71mmsvvbPXy7AsTqPeL-3LrnpMCO4T0ua0/edit
Acceptance Test File: located at `Backend/purrfect-match-backend/src/test/java`