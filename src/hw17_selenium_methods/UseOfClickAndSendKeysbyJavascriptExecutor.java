package hw17_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UseOfClickAndSendKeysbyJavascriptExecutor {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void requestOfAppointmentTest() throws InterruptedException {
		WebElement requestAnAppointment = driver.findElement(
				By.xpath("//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']"));
		wait.until(ExpectedConditions.visibilityOf(requestAnAppointment)).click();
		driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys("Polina Martinez", Keys.RETURN);
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
