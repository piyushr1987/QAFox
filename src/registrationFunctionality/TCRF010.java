package registrationFunctionality;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TCRF010 {

	WebDriver driver;

	@Test(priority = 1, dataProvider = "InvalidEmail")
	public void testRegisterFunctionalityUsingInavlidEmail(String wrongEmail) throws InterruptedException, IOException {
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
		email.sendKeys(wrongEmail);

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

		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(
				"C:\\Users\\piyush ramteke\\eclipse-workspace\\E workplace\\QAFox.com\\Screenshot\\screenshot"
						+ timestamp + ".png");
		FileUtils.copyFile(srcFile, desFile);

		String expURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(actURL, expURL);

	}

	@Test(priority = 2)
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "InvalidEmail")
	public String[] invalidData() {
		String[] invalidEmails = { " amotoori@", "amotoori@gmail", "amotoori@gmail.", "amotoori" };
		return invalidEmails;
	}

}
