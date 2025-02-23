import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class login {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Global wait for elements
        driver.get("http://localhost:3000/log-in");

        // Locate and fill the email input field
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='email@example.com']"));
        emailField.sendKeys("testuser@example.com");
        Thread.sleep(1500); // Slow down execution
        
        // Locate and fill the password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='your password']"));
        passwordField.sendKeys("Test@123");
        Thread.sleep(1500); // Slow down execution
        
        // Click the Submit button using a more robust selector (class-based)
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Thread.sleep(1000);
        submitButton.click();

        // Wait for success message or dashboard redirection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        try {
            // Check if user is redirected to the dashboard
            wait.until(ExpectedConditions.urlContains("/dashboard"));
            System.out.println("Login Successful! Redirected to Dashboard.");
        } catch (TimeoutException e) {
            try {
                // Check if an error message is displayed
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-error")));
                System.out.println("Login Failed: " + errorMessage.getText());
            } catch (Exception ex) {
                System.out.println("Login Failed! No error message displayed.");
            }
        }
        
        // Close the browser after some delay
        Thread.sleep(3000);
        driver.quit();
    }
}
