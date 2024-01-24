package registrationFunctionality;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF009 {

	WebDriver driver;

	@Test(priority = 1)
	public void testRegisterFunctionalityWithExistingAccount() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);

		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		Thread.sleep(3000);
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();

		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Piyush");

		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Ramteke");

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("piyushr219@gmail.com");

		WebElement phone = driver.findElement(By.id("input-telephone"));
		phone.sendKeys("9908765348");

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("12345");

		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys("12345");

		WebElement noNewsletter = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='0']"));
		noNewsletter.click();

		WebElement privacyPolicy = driver.findElement(By.name("agree"));
		privacyPolicy.click();

		Thread.sleep(3000);

		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();

		String expAccCreationErrorMessage = "Warning: E-Mail Address is already registered!";
		WebElement accCreaErrorMessage = driver
				.findElement(By.xpath("//div[@id='account-register']/div[1]"));
		String actAccCreationErrorMessage = accCreaErrorMessage.getText();
		Assert.assertEquals(actAccCreationErrorMessage, expAccCreationErrorMessage);

	}

	@Test(priority = 2)
	public void tearDown() {
		driver.quit();
	}

}
