import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

public class TestClass {

    @Test
    public void TestContactPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        // Navigate to contact page
        driver.findElement(By.id("contactLink")).click();

        // Type name "Bob" into firstNameField
        driver.findElement(By.id("firstNameField")).findElement(By.xpath("./input")).sendKeys("Bob");

        // Type name "Lincoln" into lastNameField
        driver.findElement(By.id("lastNameField")).findElement(By.xpath("./input")).sendKeys("Lincoln");

        // Select "yes" for
        new Select(driver.findElement(By.id("shelterEmployeeSelectionBox")).findElement(By.xpath("./select")))
                .selectByIndex(1);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }

}