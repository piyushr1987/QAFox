package registrationFunctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCRF001 {

	WebDriver driver;

	@Test(priority = 1)
	public void testRegisterFunctionality() throws InterruptedException {
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
		email.sendKeys(createNewEmail());

		WebElement phone = driver.findElement(By.id("input-telephone"));
		phone.sendKeys("9908765348");

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("12345");

		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys("12345");

		WebElement privacyPolicy = driver.findElement(By.name("agree"));
		privacyPolicy.click();

		WebElement continueButton = driver.findElement(By.xpath("//input[@Value='Continue']"));
		continueButton.click();

		// verify user is login or not
		WebElement myAccount1 = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount1.click();

		WebElement logOut = driver.findElement(By.linkText("Logout"));
		Assert.assertTrue(logOut.isDisplayed());

		String actURL = driver.getCurrentUrl();
		String expURL = "https://tutorialsninja.com/demo/index.php?route=account/success";

		Assert.assertEquals(actURL, expURL);

		String expHeading = "Your Account Has Been Created!";
		WebElement heading = driver.findElement(By.xpath("//div[@id='content']/h1"));
		String actHeading = heading.getText();
		Assert.assertEquals(actHeading, expHeading);

		WebElement congrulation = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[1]"));
		String actCongMessage = congrulation.getText();
		String expCongMessage = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(actCongMessage, expCongMessage);

		WebElement membershipPrivilege = driver
				.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[2]"));
		String actmembershipPrivilegeMessage = membershipPrivilege.getText();
		String expmembershipPrivilegeMessage = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		Assert.assertEquals(actmembershipPrivilegeMessage, expmembershipPrivilegeMessage);

		WebElement anyQuestions = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[3]"));
		String actAnyQuestions = anyQuestions.getText();
		String expAnyQuestions = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		Assert.assertEquals(actAnyQuestions, expAnyQuestions);

		WebElement confirmationEmail = driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[4]"));
		String actConfirmationEmail = confirmationEmail.getText();
		String expConfirmationEmail = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		Assert.assertEquals(actConfirmationEmail, expConfirmationEmail);

		WebElement contactUsLink = driver.findElement(By.linkText("contact us"));
		Assert.assertTrue(contactUsLink.isDisplayed());

		WebElement continueButtonElement = driver.findElement(By.xpath("//a[text()='Continue']"));
		continueButtonElement.click();

		String actPageTitle = driver.getTitle();
		String expPageTitle = "My Account";
		Assert.assertEquals(actPageTitle, expPageTitle);

	}

	@Test(priority = 2)
	public void tearDown() {
		driver.quit();
	}

	public static String createNewEmail() {
		Date date = new Date();
		String email = date.toString().replace("  ", " _ ").replace(" : ", " _ ") + " @gmail.com ";
		return email;

	}

}
