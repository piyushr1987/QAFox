package registrationFunctionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.redbus.in/");
		Thread.sleep(3000);

		WebElement datePicker = driver.findElement(By.xpath("//div[@id='onwardCal']"));
		datePicker.click();

		String expDate = "12";
		String expMonthYear = "Apr 2024";

		while (true) {
			WebElement monthYear = driver.findElement(By.xpath("//div[contains(@class,'DayNavigator__C')]/div[2]"));
			String actMonthYear = monthYear.getText();

			if (actMonthYear.contains(expMonthYear)) {
				List<WebElement> allDates = driver.findElements(By.xpath(
						"//div[contains(@class,'DayTilesWrapper')]//div[contains(@class,'DayTiles__CalendarDaysBlock')]"));
				for (WebElement dates : allDates) {
					String calanderDate = dates.getText();
					if (calanderDate.equalsIgnoreCase(expDate)) {
						dates.click();
						break;
					}
				}
				break;
			} else {
				WebElement nextButton = driver
						.findElement(By.xpath("//div[contains(@class,'DayNavigator__C')]/div[3]"));
				nextButton.click();
			}

		}

	}

}
