package SetTribeAdmissionForm;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Navigate to the login page
		driver.get("http://127.0.0.1:5500/SETTRIBE%20CODE/002.SETTRIBE%20LOGIN%20PAGE%20IN%20CSS.HTML");

		// Find the username, password, captcha, and login button elements
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("admin");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("admin");

		WebElement captchaField = driver.findElement(By.id("captchaInput"));
//        captchaField.sendKeys(Keys.ENTER);

		WebElement dynamicCaptcha = driver.findElement(By.id("captcha"));
		String captchaValue = dynamicCaptcha.getText(); // Assuming captcha is a text field
		captchaField.sendKeys(captchaValue);

		WebElement loginButton = driver.findElement(By.xpath("/html/body/div/form/input[4]"));
		loginButton.click();
		Thread.sleep(2000);

		Alert alt = driver.switchTo().alert();
		alt.accept();

		if (driver.getCurrentUrl()
				.equals("http://127.0.0.1:5500/SETTRIBE%20CODE/003.SETTRIBE%20ADMISSION%20FORM%20IN%20CSS.HTML")) {
			System.out.println("Login successful!");
		} else {
			// Handle incorrect login
			WebElement errorMessage = driver.findElement(By.id("errorMessage"));
			System.out.println("Login failed. Error message: " + errorMessage.getText());
		}

		// Close the browser
		driver.quit();
	}
}
