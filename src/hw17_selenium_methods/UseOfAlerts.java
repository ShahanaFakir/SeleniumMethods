package hw17_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UseOfAlerts {

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
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(enabled = true, priority = 1)
	public void acceptTheAlertJSAlert() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println("The text of the Alert is: " + alert.getText());
		alert.accept();
	}

	@Test(enabled = true, priority = 2)
	public void acceptTheAlertJSConfirm() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println("The text of the Alert is: " + alert.getText());
		alert.accept();
	}

	@Test(enabled = true, priority = 3)
	public void dismissTheAlertJSConfirm() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

//	The text of the Alert is: I am a JS Alert
//	The text of the Alert is: I am a JS Confirm
//	PASSED: acceptTheAlertJSAlert
//	PASSED: acceptTheAlertJSConfirm
//	PASSED: dismissTheAlertJSConfirm

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
