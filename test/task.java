
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class task {
    public static void main(String[] args) {
    	// Set GeckoDriver path
//        System.setProperty("webdriver.gecko.driver", "/home/mankirat/Downloads/geckodriver");

        // Initialize Firefox WebDriver
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:3000/log-in");
            driver.manage().window().maximize();

            // Login
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='email@example.com']")));
            emailInput.sendKeys("aryansaxenaalig@gmail.com");
            WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='your password']"));
            passwordInput.sendKeys("Abcd");
            WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Submit']"));
            loginButton.click();
            
            // Wait for login success
            wait.until(ExpectedConditions.urlContains("/dashboard"));
            
            // Navigate to tasks page
            driver.get("http://localhost:3000/tasks");
            
            // Click 'Create Task' button
            WebElement createTaskButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create Task']")));
            createTaskButton.click();
            
            // Wait for the modal to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/h2[1]"))); // Replace with actual modal class name
            
            // Fill in task details
            WebElement taskTitle = driver.findElement(By.xpath("//input[@placeholder='Task Title']")); // Update the name as per JSX
            taskTitle.sendKeys("New Task");
            WebElement stage  = driver.findElement(By.xpath("//span[normalize-space()='TODO']"));
            stage.click();
            driver.findElement(By.xpath("//span[normalize-space()='IN PROGRESS']")).click();
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]")).click();

            driver.findElement(By.xpath("//span[normalize-space()='MEDIUM']")).click();
            // Submit task
            WebElement submitButton = driver.findElement(By.xpath("//span[normalize-space()='Submit']"));
            submitButton.click();
            
            // Verify task creation
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Task created successfully.')]")));
            driver.navigate().refresh();
            System.out.println("✅ Task Created Successfully!");
        } catch (Exception e) {
            System.out.println("❌ Test Failed: " + e.getMessage());
        } finally {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }

    }
}