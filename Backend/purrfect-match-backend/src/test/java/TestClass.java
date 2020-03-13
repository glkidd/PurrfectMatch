import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void Test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("localhost:3000");

        // Navigate to contact page
        driver.findElement(By.id("contactLink")).click();

        driver.findElement(By.id("firstName")).sendKeys("name");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }
}