package registrationFunctionality;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TCRF025 {

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
	public void testRegisterFunctionalityWithVariousAttributes() throws IOException {

		WebElement breadcrumb = driver.findElement(
				By.xpath("//div[@class='container']//nav[@id='menu']//ul[contains(@class,'nav navbar-nav')]"));
		Assert.assertTrue(breadcrumb.isDisplayed());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\piyush ramteke\\eclipse-workspace\\E workplace\\QAFox.com\\Screenshot\\breadcrumb.png");
		FileUtils.copyFile(src, des);

		WebElement pageHeading = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actPageHeading = pageHeading.getText();
		String expPageHeading = "Register Account";
		Assert.assertEquals(actPageHeading, expPageHeading);

		String actURL = driver.getCurrentUrl();
		String expURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(actURL, expURL);

		String actTitle = driver.getTitle();
		String expTitle = "Register Account";
		Assert.assertEquals(actTitle, expTitle);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}
}
