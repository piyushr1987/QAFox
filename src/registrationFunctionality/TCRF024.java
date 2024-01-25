package registrationFunctionality;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TCRF024 {

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
	public void testRegisterFunctionalityWithPasswordField() {

		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Priyanka");

		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Sonone");

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys(getSaltString() + "@gmail.com");

		WebElement telephone = driver.findElement(By.id("input-telephone"));
		telephone.sendKeys("7276901234");

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("12345");

		WebElement yesNewsletter = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
		yesNewsletter.click();

		WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicy.click();

		WebElement btnContinue = driver.findElement(By.xpath("//input[@type='submit']"));
		btnContinue.click();

		WebElement passwordConErrorMsg = driver
				.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div"));
		String actPasswordConErrorMsg = passwordConErrorMsg.getText();
		String expPasswordConErrorMsg = "Password confirmation does not match password!";
		Assert.assertEquals(actPasswordConErrorMsg, expPasswordConErrorMsg);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

	protected static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
}
