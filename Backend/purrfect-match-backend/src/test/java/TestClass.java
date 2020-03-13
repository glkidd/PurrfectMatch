import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

public class TestClass {

    @Test
    public void TestContactPageAsEmployee() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to contact page
        driver.findElement(By.id("contactLink")).click();

        // Type name "Bob" into element w/id firstNameField
        driver.findElement(By.id("firstNameField")).findElement(By.xpath("./input")).sendKeys("Bob");

        // Type name "Lincoln" into element w/id lastNameField
        driver.findElement(By.id("lastNameField")).findElement(By.xpath("./input")).sendKeys("Lincoln");

        // Select "yes"
        new Select(driver.findElement(By.id("shelterEmployeeSelectionBox")).findElement(By.xpath("./select")))
                .selectByIndex(1);

        // Type email "user@woodshumanesociety.org" into element w/id emailAddressField
        driver.findElement(By.id("emailAddressField")).findElement(By.xpath("./input"))
                .sendKeys("user@woodshumanesociety.org");

        // Type subject "Success Stories Page Bug" into element w/id subjectField
        driver.findElement(By.id("subjectField")).findElement(By.xpath("./input")).sendKeys("Success Stories Page Bug");

        // Type subject message into element w/id messageField
        driver.findElement(By.id("messageField")).findElement(By.xpath("./textarea"))
                .sendKeys("I ran into a bug on the success stories page when I tried to click on one of the animals.");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the submit button.
        driver.findElement(By.id("submitButton")).findElement(By.xpath("./button")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestSuccessStoriesPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to success stories page
        driver.findElement(By.id("successStoriesLink")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click a button with class name "compactView."
        driver.findElement(By.className("compactView")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestSearchResultsPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        // Navigate to search page, hacky way to do it, but works.
        driver.get(driver.findElement(By.id("catLink")).getAttribute("href"));

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click a button with class name "compactView."
        driver.findElement(By.className("compactSearch")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestContactPageAsNonEmployee() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to contact page
        driver.findElement(By.id("contactLink")).click();

        // Type name "Bob" into element w/id firstNameField
        driver.findElement(By.id("firstNameField")).findElement(By.xpath("./input")).sendKeys("Bob");

        // Type name "Lincoln" into element w/id lastNameField
        driver.findElement(By.id("lastNameField")).findElement(By.xpath("./input")).sendKeys("Lincoln");

        // Select "no"
        new Select(driver.findElement(By.id("shelterEmployeeSelectionBox")).findElement(By.xpath("./select")))
                .selectByIndex(2);

        // Type email "tgorer@calpoly.edu" into element w/id emailAddressField
        driver.findElement(By.id("emailAddressField")).findElement(By.xpath("./input")).sendKeys("tgorer@calpoly.edu");

        // Type subject "Success Stories Page Bug" into element w/id subjectField
        driver.findElement(By.id("subjectField")).findElement(By.xpath("./input")).sendKeys("Success Stories Page Bug");

        // Type subject message into element w/id messageField
        driver.findElement(By.id("messageField")).findElement(By.xpath("./textarea"))
                .sendKeys("I ran into a bug on the success stories page when I tried to click on one of the animals.");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the submit button.
        driver.findElement(By.id("submitButton")).findElement(By.xpath("./button")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestAddSuccessStory() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to success stories page
        driver.findElement(By.id("successStoriesLink")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click a button with class name "submissionBoxButton."
        driver.findElement(By.className("submissionBoxButton")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.findElement(By.id("nameField")).findElement(By.xpath("./input")).sendKeys("Alex");
        driver.findElement(By.id("petNameField")).findElement(By.xpath("./input")).sendKeys("Fuzzles");
        driver.findElement(By.id("breedField")).findElement(By.xpath("./input")).sendKeys("Siberian Husky");
        driver.findElement(By.id("ageField")).findElement(By.xpath("./input")).sendKeys("2");
        driver.findElement(By.id("genderField")).findElement(By.xpath("./input")).sendKeys("Male");
        driver.findElement(By.id("dateOfAdoptionField")).findElement(By.xpath("./input")).sendKeys("7/21/2019");
        driver.findElement(By.id("storyField")).findElement(By.xpath("./textarea")).sendKeys("An amazing puppy!");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestNavigateToDogUnderConstructionPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to dog under construction page
        driver.findElement(By.id("dogLink")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestNavigateToOtherUnderConstructionPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to dog under construction page
        driver.findElement(By.id("otherLink")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.close();
    }

    @Test
    public void TestSuccessStoriesRecentlyAdoptedPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        // Navigate to success stories page
        driver.findElement(By.id("successStoriesLink")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click a button with class name "compactView."
        driver.findElement(By.id("recentAdoptList")).findElement(By.className("compactView")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        driver.close();
    }
}