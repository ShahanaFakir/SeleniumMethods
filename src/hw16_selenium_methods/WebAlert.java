package hw16_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebAlert {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(enabled = true, priority = 1)
	public void acceptWebAlertTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("The text of the Alert is: " + alert.getText());
		alert.accept();

	}

	@Test(enabled = true, priority = 2)
	public void dismissWebAlertTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space(text())='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		// The text of the Alert is: I am a JS Confirm
		// PASSED: acceptWebAlertTest
		// PASSED: dismissWebAlertTest

	}

	@AfterTest
	public void closingBrowser() {
		driver.quit();
	}

}
