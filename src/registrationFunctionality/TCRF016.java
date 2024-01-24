package registrationFunctionality;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TCRF016 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
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
	}

	@Test
	public void testRegisterFunctionalityWithSpaces() throws InterruptedException, IOException {

		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("  ");

		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("  ");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("  ");

		WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
		telephone.sendKeys("     ");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("    ");

		WebElement conPassword = driver.findElement(By.xpath("//input[@name='confirm']"));
		conPassword.sendKeys("    ");

		WebElement yesRadioButton = driver
				.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
		yesRadioButton.click();

		WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
		agree.click();
		Thread.sleep(3000);
		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		btnContinue.click();

		WebElement WarningMessageForFirstName = driver
				.findElement(By.xpath("//input[@name='firstname']/following-sibling::div"));
		String actWarningMessageForFirstName = WarningMessageForFirstName.getText();
		String expWarningMessageForFirstName = "First Name must be between 1 and 32 characters!";

		Assert.assertEquals(actWarningMessageForFirstName, expWarningMessageForFirstName);

		WebElement WarningMessageForLastName = driver
				.findElement(By.xpath("//input[@name='lastname']/following-sibling::div"));
		String actWarningMessageForLastName = WarningMessageForLastName.getText();
		String expWarningMessageForLastName = "Last Name must be between 1 and 32 characters!";

		Assert.assertEquals(actWarningMessageForLastName, expWarningMessageForLastName);

		WebElement WarningMessageEmail = driver.findElement(By.xpath("//input[@name='email']/following-sibling::div"));
		String actWarningMessageForEmail = WarningMessageEmail.getText();
		String expWarningMessageForEmail = "E-Mail Address does not appear to be valid!";

		Assert.assertEquals(actWarningMessageForEmail, expWarningMessageForEmail);

		WebElement WarningMessageTelephone = driver
				.findElement(By.xpath("//input[@name='telephone']/following-sibling::div"));
		String actWarningMessageForTelephone = WarningMessageTelephone.getText();
		String expWarningMessageForTelephone = "Telephone must be between 3 and 32 characters!";

		Assert.assertEquals(actWarningMessageForTelephone, expWarningMessageForTelephone,
				"Telephone accepting spaces..hence test case is failed");

		WebElement WarningMessagePassword = driver
				.findElement(By.xpath("//input[@name='password']/following-sibling::div"));
		String actWarningMessageForPassword = WarningMessagePassword.getText();
		String expWarningMessageForPassword = "Password must be between 4 and 20 characters!";

		Assert.assertEquals(actWarningMessageForPassword, expWarningMessageForPassword);
		
		String actPassword = "    ";
		Assert.assertEquals(actPassword, "    ", "actual and expected password is not matched");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}
}
