package registrationFunctionality;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF005 {

	WebDriver driver;

	@Test(priority = 1)
	public void testRegisterFunctionalityBySelectingYesNewsletter() throws InterruptedException {
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
		email.sendKeys(getSaltString() + "@gmail.com");

		WebElement phone = driver.findElement(By.id("input-telephone"));
		phone.sendKeys("9908765348");

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("12345");

		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys("12345");

		WebElement yesNewsletter = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='1']"));
		yesNewsletter.click();

		WebElement privacyPolicy = driver.findElement(By.name("agree"));
		privacyPolicy.click();

		Thread.sleep(3000);

		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();

		String expHeading = "Your Account Has Been Created!";
		WebElement heading = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actHeading = heading.getText();
		Assert.assertEquals(actHeading, expHeading);

		WebElement btnContinue = driver.findElement(By.xpath("//a[text()='Continue']"));
		btnContinue.click();

		WebElement newsletter = driver.findElement(By.xpath("//div[@id='content']//ul[4]//a"));
		newsletter.click();

		try {
			Assert.assertTrue(yesNewsletter.isSelected());
		} catch (Exception e) {

		}

	}

	@Test(priority = 2)
	public void tearDown() {
		driver.quit();
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
