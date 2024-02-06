package registrationFunctionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/datepicker/");
		Thread.sleep(3000);

		driver.switchTo().frame(0);

		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.click();

		String expDate = "12";
		String expMonth = "May";
		String expYear = "2025";

		while (true) {
			WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			String actMonth = month.getText();

			WebElement year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			String actYear = year.getText();

			if (actMonth.equalsIgnoreCase(expMonth) && actYear.equalsIgnoreCase(expYear)) {
				List<WebElement> allDates = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement dates : allDates) {
					String calanderDate = dates.getText();
					if (calanderDate.equalsIgnoreCase(expDate)) {
						dates.click();
						break;
					}
				}
				break;
			} else {
				WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
				nextButton.click();
			}

		}

	}
}
