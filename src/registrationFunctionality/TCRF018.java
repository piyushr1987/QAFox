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

public class TCRF018 {

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
	public void testRegisterFunctionalityWithAllFieldSizes() throws InterruptedException, IOException {

		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		String actDimensionFirstName = firstName.getSize().toString();
		String expDimensionFirstName = "(701, 34)";
		Assert.assertEquals(actDimensionFirstName, expDimensionFirstName);

		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		String actDimensionLastName = lastName.getSize().toString();
		String expDimensionLastName = "(701, 34)";
		Assert.assertEquals(actDimensionLastName, expDimensionLastName);

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		String actDimensionEmail = email.getSize().toString();
		String expDimensionEmail = "(701, 34)";
		Assert.assertEquals(actDimensionEmail, expDimensionEmail);

		WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
		String actDimensionTelephone = telephone.getSize().toString();
		String expDimensionTelephone = "(701, 34)";
		Assert.assertEquals(actDimensionTelephone, expDimensionTelephone);

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		String actDimensionPassword = password.getSize().toString();
		String expDimensionPassword = "(701, 34)";
		Assert.assertEquals(actDimensionPassword, expDimensionPassword);

		WebElement conPassword = driver.findElement(By.xpath("//input[@name='confirm']"));
		String actDimensionConPassword = conPassword.getSize().toString();
		String expDimensionConPassword = "(701, 34)";
		Assert.assertEquals(actDimensionConPassword, expDimensionConPassword);

		WebElement yesRadioButton = driver
				.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
		String actDimensionYesRadioButton = yesRadioButton.getSize().toString();
		String expDimensionYesRadioButton = "(13, 13)";
		Assert.assertEquals(actDimensionYesRadioButton, expDimensionYesRadioButton);

		WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
		String actDimensionAgree = agree.getSize().toString();
		String expDimensionAgree = "(13, 13)";
		Assert.assertEquals(actDimensionAgree, expDimensionAgree);

		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		String actDimensionBtnContinue = btnContinue.getSize().toString();
		String expDimensionBtnContinue = "(77, 34)";
		Assert.assertEquals(actDimensionBtnContinue, expDimensionBtnContinue);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}
}
