package registrationFunctionality;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TCRF012 {

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
	public void testRegisterFunctionalityUsingKeyboardKeys() throws InterruptedException, IOException {
		Actions act = new Actions(driver);
		
		for(int i=1;i<=23;i++)
		{
			act.sendKeys(Keys.TAB).perform();
		}
		
		act.sendKeys("Piyush")
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		
		.sendKeys("Ramteke")
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))

		.sendKeys(getSaltString() + "@gmail.com")
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		
		.sendKeys("909876")
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		
		.sendKeys("12345")
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		
		.sendKeys("12345")
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		
		.sendKeys(Keys.ARROW_LEFT)
		.pause(Duration.ofSeconds(2))
		
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		 
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		 
		.sendKeys(Keys.SPACE)
		.pause(Duration.ofSeconds(2))
		 
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		 
		.sendKeys(Keys.ENTER).build().perform();
	
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/success";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);

		WebElement memberPrivilege = driver.findElement(By.xpath("//div[@id='content']/p[2]"));
		String actMemberPrivilegeText = memberPrivilege.getText();
		String expMemberPrivilegeText = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		Assert.assertEquals(actMemberPrivilegeText, expMemberPrivilegeText);

		WebElement anyQuestions = driver.findElement(By.xpath("//div[@id='content']/p[3]"));
		String actAnyQuestionsText = anyQuestions.getText();
		String expAnyQuestionsText = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		Assert.assertEquals(actAnyQuestionsText, expAnyQuestionsText);

		WebElement confirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[4]"));
		String actConfirmationMessageText = confirmationMessage.getText();
		String expConfirmationMessageText = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		Assert.assertEquals(actConfirmationMessageText, expConfirmationMessageText);

		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(
				"C:\\Users\\piyush ramteke\\eclipse-workspace\\E workplace\\QAFox.com\\Screenshot\\screenshot"
						+ timestamp + ".png");
		FileUtils.copyFile(srcFile, desFile);

	}

	@AfterMethod
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
