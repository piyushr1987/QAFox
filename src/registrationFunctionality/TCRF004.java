package registrationFunctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF004 {

	WebDriver driver;

	@Test(priority = 1)
	public void testRegisterFunctionalityWithAllErrorMessages() throws InterruptedException {
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

		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();

		WebElement firstNameMessage = driver
				.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"));
		String actFirstNameErrMessage = firstNameMessage.getText();
		String expFirstNameErrMessage = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(actFirstNameErrMessage, expFirstNameErrMessage, "please enter correct error message");

		WebElement lastNameMessage = driver
				.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div"));
		String actLastNameErrMessage = lastNameMessage.getText();
		String expLastNameErrMessage = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(actLastNameErrMessage, expLastNameErrMessage, "please enter correct error message");

		WebElement emailMessage = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"));
		String actEmailErrMessage = emailMessage.getText();
		String expEmailErrMessage = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(actEmailErrMessage, expEmailErrMessage, "please enter correct error message");

		WebElement telephoneMessage = driver
				.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"));
		String actTelephoneErrMessage = telephoneMessage.getText();
		String expTelephoneErrMessage = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(actTelephoneErrMessage, expTelephoneErrMessage, "please enter correct error message");

		WebElement passwordMessage = driver
				.findElement(By.xpath("//input[@id='input-password']/following-sibling::div"));
		String actPasswordErrMessage = passwordMessage.getText();
		String expPasswordErrMessage = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(actPasswordErrMessage, expPasswordErrMessage, "please enter correct error message");

	}

	@Test(priority = 2)
	public void tearDown() {
		driver.quit();
	}
}
