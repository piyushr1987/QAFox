package registrationFunctionality;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF007 {

	WebDriver driver;

	@Test(priority = 1)
	public void testDifferentNavigationWaysOfRegisterFunctionality() throws InterruptedException {
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
		Thread.sleep(3000);
		WebElement myAccount1 = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount1.click();

		WebElement login = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]"));
		login.click();

		WebElement continueButton = driver
				.findElement(By.xpath("(//div[@id='content']//div[@class='col-sm-6'][1])//a"));
		continueButton.click();

		WebElement myAccount2 = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount2.click();

		WebElement login1 = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]"));
		login1.click();

		WebElement lnkRegister = driver
				.findElement(By.xpath("//div[contains(@class,'list-group')]/a[text()='Register']"));
		lnkRegister.click();

		WebElement registerAccount = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actRegAccText = registerAccount.getText();
		String expRegAccText = "Register Account";

		Assert.assertEquals(actRegAccText, expRegAccText);

	}

	@Test(priority = 2)
	public void tearDown() {
		driver.quit();
	}

}
