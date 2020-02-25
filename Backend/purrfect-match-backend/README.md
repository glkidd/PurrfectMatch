# PurrfectMatch
Description:
We are able to use both these ports in our project
Website URL: http://localhost:8080/greeting
Website URL: http://localhost:8083/greeting

			Running the Backend
pwd:Desktop/PurrfectMatchGit/PurrfectMatch/Backend/complete


Important Terminal Commands:
./gradlew build
This builds the application
./gradlew bootRun
	-This allows the gradle project to run
Control+C
	-Kills the Spring Boot Application
kill $(lsof -ti:8080)
	-kills the commands that is running

Other Terminal Commands that aren’t as important:
gradle --stop
Stops all the Daemon processes
./gradlew build
This builds the application
lsof -ti:8080
	-This checks the PID’s that are running
kill $(lsof -ti:8080)
	-kills the commands that is running


Background:
https://start.spring.io/
This is how to set up Spring projects quickly but we wouldn’t need it because it is already pushed.

Notes:
Daemon processes that uses the Spring Boot Application will automatically terminate themselves after 3 hours of inactivity or less. 
Gradle Documentation:
https://www.vogella.com/tutorials/Gradle/article.html
