package registrationFunctionality;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TCRF023 {

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
	public void testRegisterFunctionalityWithNavigateToOtherPages() throws IOException, InterruptedException {

		WebElement loginPage = driver.findElement(By.linkText("login page"));
		loginPage.click();

		String actURL = driver.getCurrentUrl();
		String expURL = "https://tutorialsninja.com/demo/index.php?route=account/login";
		Assert.assertEquals(actURL, expURL);

		WebElement privacyPolicy = driver.findElement(By.linkText("Privacy Policy"));
		privacyPolicy.click();

		WebElement privacyPolicyText = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actText = privacyPolicyText.getText();
		String expText = "Privacy Policy";
		Assert.assertEquals(actText, expText);
		driver.navigate().back();

		WebElement forgotPassword = driver
				.findElement(By.xpath("//a[contains(@class,'list-group-item')][text()='Forgotten Password']"));
		forgotPassword.click();

		WebElement forgotPasswordText = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actForgotPasswordText = forgotPasswordText.getText();
		String expForgotPasswordText = "Forgot Your Password?";
		Assert.assertEquals(actForgotPasswordText, expForgotPasswordText);

		WebElement laptopAndNotebook = driver.findElement(By.xpath("//nav[@id='menu']//li[@class='dropdown'][2]"));
		Actions act = new Actions(driver);
		act.moveToElement(laptopAndNotebook).build().perform();
		Thread.sleep(3000);
		WebElement windows = driver.findElement(By.xpath("//a[normalize-space()='Windows (0)']"));
		windows.click();
		WebElement windowText = driver.findElement(By.xpath("//div[@id='content']/h2"));
		String actWindowText = windowText.getText();
		String expWindowText = "Windows";
		Assert.assertEquals(actWindowText, expWindowText);

		WebElement shoppingCart = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='Shopping Cart']"));
		shoppingCart.click();
		WebElement shoppingCartText = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actShoppingCartText = shoppingCartText.getText();
		String expShoppingCartText = "Shopping Cart";
		Assert.assertEquals(actShoppingCartText, expShoppingCartText);

		WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
		contactUs.click();

		String actContactURL = driver.getCurrentUrl();
		String expContactURL = "https://tutorialsninja.com/demo/index.php?route=information/contact";
		Assert.assertEquals(actContactURL, expContactURL);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}
}
