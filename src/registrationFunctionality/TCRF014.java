package registrationFunctionality;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TCRF014 {

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
	public void testRegisterFunctionalityMandatoryField() throws InterruptedException, IOException {

		WebElement firstNameLabel = driver.findElement(By.xpath("//label[@for='input-firstname']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String actualFirstNameAsterickContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNameLabel);
		Assert.assertTrue(actualFirstNameAsterickContent.contains("*"));
		String actualFirstNameAsterickColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstNameLabel);
		Assert.assertEquals(actualFirstNameAsterickColor, "rgb(255, 0, 0)");

		WebElement lastNameLabel = driver.findElement(By.xpath("//label[@for='input-lastname']"));
		String actualLastNameAsterickContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", lastNameLabel);
		Assert.assertTrue(actualLastNameAsterickContent.contains("*"));
		String actualLastNameAsterickColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", lastNameLabel);
		Assert.assertEquals(actualLastNameAsterickColor, "rgb(255, 0, 0)");

		WebElement emailLabel = driver.findElement(By.xpath("//label[@for='input-email']"));
		String actualEmailAsterickContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", emailLabel);
		Assert.assertTrue(actualEmailAsterickContent.contains("*"));
		String actualEmailAsterickColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", emailLabel);
		Assert.assertEquals(actualEmailAsterickColor, "rgb(255, 0, 0)");

		WebElement telephoneLabel = driver.findElement(By.xpath("//label[@for='input-telephone']"));
		String actualTelephoneAsterickContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", telephoneLabel);
		Assert.assertTrue(actualTelephoneAsterickContent.contains("*"));
		String actualTelephoneAsterickColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", telephoneLabel);
		Assert.assertEquals(actualTelephoneAsterickColor, "rgb(255, 0, 0)");

		WebElement passwordLabel = driver.findElement(By.xpath("//label[@for='input-password']"));
		String actualPasswordAsterickContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", passwordLabel);
		Assert.assertTrue(actualPasswordAsterickContent.contains("*"));
		String actualPasswordAsterickColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", passwordLabel);
		Assert.assertEquals(actualPasswordAsterickColor, "rgb(255, 0, 0)");

		WebElement passwordConfirmLabel = driver.findElement(By.xpath("//label[@for='input-confirm']"));
		String actualPasswordConfirmAsterickContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",
				passwordConfirmLabel);
		Assert.assertTrue(actualPasswordConfirmAsterickContent.contains("*"));
		String actualPasswordConfirmAsterickColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",
				passwordConfirmLabel);
		Assert.assertEquals(actualPasswordConfirmAsterickColor, "rgb(255, 0, 0)");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
