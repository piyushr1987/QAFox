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

public class TCRF013 {

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
	public void testRegisterFunctionalityPlaceholders() throws InterruptedException, IOException {

		WebElement firstName = driver.findElement(By.id("input-firstname"));
		String actFirstNamePlaceholder = firstName.getAttribute("placeholder");
		String expFirstNamePlaceholder = "First Name";
		Assert.assertEquals(actFirstNamePlaceholder, expFirstNamePlaceholder);

		WebElement lastName = driver.findElement(By.id("input-lastname"));
		String actLastNamePlaceholder = lastName.getAttribute("placeholder");
		String expLastNamePlaceholder = "Last Name";
		Assert.assertEquals(actLastNamePlaceholder, expLastNamePlaceholder);

		WebElement email = driver.findElement(By.id("input-email"));
		String actEmailPlaceholder = email.getAttribute("placeholder");
		String expEmailPlaceholder = "E-Mail";
		Assert.assertEquals(actEmailPlaceholder, expEmailPlaceholder);

		WebElement phone = driver.findElement(By.id("input-telephone"));
		String actTelephonePlaceholder = phone.getAttribute("placeholder");
		String expTelephonePlaceholder = "Telephone";
		Assert.assertEquals(actTelephonePlaceholder, expTelephonePlaceholder);

		WebElement password = driver.findElement(By.id("input-password"));
		String actPasswordPlaceholder = password.getAttribute("placeholder");
		String expPasswordPlaceholder = "Password";
		Assert.assertEquals(actPasswordPlaceholder, expPasswordPlaceholder);

		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		String actConfirmPasswordPlaceholder = confirmPassword.getAttribute("placeholder");
		String expConfirmPasswordPlaceholder = "Password Confirm";
		Assert.assertEquals(actConfirmPasswordPlaceholder, expConfirmPasswordPlaceholder);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
