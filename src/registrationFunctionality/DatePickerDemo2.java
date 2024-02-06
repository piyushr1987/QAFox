package registrationFunctionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/");
		Thread.sleep(3000);

		WebElement closeButton = driver.findElement(By.xpath("//span[contains(@class,'logSprite icClose')]"));
		closeButton.click();

		WebElement datePicker = driver.findElement(By.xpath("//div[contains(@class,'sc-12foipm-34')][3]"));
		datePicker.click();

		String expDate = "12";
		String expMonthYear = "Apr 2024";

		while (true) {
			WebElement monthYear = driver
					.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']"));
			String actMonthYear = monthYear.getText();

			if (actMonthYear.contains(expMonthYear)) {
				List<WebElement> allDates = driver
						.findElements(By.xpath("//div[@class='DayPicker-Months']/div[1]//div[@class='DayPicker-Day']"));
				for (WebElement dates : allDates) {
					String calanderDate = dates.getText();
					if (calanderDate.equalsIgnoreCase(expDate)) {
						dates.click();
						break;
					}
				}
				break;
			} else {
				WebElement nextButton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				nextButton.click();
			}

		}
		;
		WebElement done = driver.findElement(By.xpath("//span[contains(@class,'fswTrvl__')][2]"));
		done.click();

	}

}
