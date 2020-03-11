import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

public class TestClass {

    @Test
    public void TestContactPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        // Navigate to contact page
        driver.findElement(By.id("contactLink")).click();

        // Type name "Bob" into element w/id firstNameField
        driver.findElement(By.id("firstNameField")).findElement(By.xpath("./input")).sendKeys("Bob");

        // Type name "Lincoln" into element w/id lastNameField
        driver.findElement(By.id("lastNameField")).findElement(By.xpath("./input")).sendKeys("Lincoln");

        // Select "yes" for
        new Select(driver.findElement(By.id("shelterEmployeeSelectionBox")).findElement(By.xpath("./select")))
                .selectByIndex(1);

        // Type email "tgorer@calpoly.edu" into element w/id emailAddressField
        driver.findElement(By.id("emailAddressField")).findElement(By.xpath("./input")).sendKeys("tgorer@calpoly.edu");

        // Type subject "Success Stories Page Bug" into element w/id subjectField
        driver.findElement(By.id("subjectField")).findElement(By.xpath("./input")).sendKeys("Success Stories Page Bug");

        // Type subject message into element w/id messageField
        driver.findElement(By.id("messageField")).findElement(By.xpath("./textarea"))
                .sendKeys("I ran into a bug on the success stories page when I tried to click on one of the animals.");

        // Click the submit button.
        driver.findElement(By.id("submitButton")).findElement(By.xpath("./button")).click();

        // Click the close modal button.
        driver.findElement(By.className("modal-close")).click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }

}