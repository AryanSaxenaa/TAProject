import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class register {
/*************  ✨ Codeium Command ⭐  *************/
/**
 * Main method for automating the registration process on a web application.
 * It initializes the Chrome WebDriver, navigates to the registration page,
 * fills out the registration form with test data, submits the form, and handles
 * any alert popups indicating the registration status. Finally, it closes the browser.
 *
 * @param args command-line arguments (not used in this method)
 */

/******  e8d00f03-45c1-4257-9108-255bf5dd13cd  *******/
    public static void main(String[] args) {
        // Set ChromeDriver path (Update according to your system)
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/register");

        // Fill out the registration form
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Test User21234");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Testuser322@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@12334");
        driver.findElement(By.xpath("//input[@placeholder='Role (optional)']")).sendKeys("Developer23");
        driver.findElement(By.xpath("//input[@placeholder='Title (optional)']")).sendKeys("Software33 Engineer");

        WebElement adminCheckbox = driver.findElement(By.name("isAdmin"));
        if (!adminCheckbox.isSelected()) {
            adminCheckbox.click();
        }

        // Submit the form
        driver.findElement(By.xpath("//button[text()='Register']")).click();

        // ✅ Handle alert popup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Popup Message: " + alert.getText()); // Print popup message
            alert.accept(); // Click OK/Close the alert
            System.out.println("Registration Successful!");
        } catch (Exception e) {
            System.out.println("Registration Failed! No alert found.");
        }

        // Close the browser
//        driver.quit();
    }
}