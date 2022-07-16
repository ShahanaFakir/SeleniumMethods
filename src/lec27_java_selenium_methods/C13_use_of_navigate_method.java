package lec27_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C13_use_of_navigate_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com"); // Amazon
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// interview question
	@Test(enabled = true, priority = 1)
	public void navigationTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to("https://portal.cms.gov/portal/"); // CMS
		Thread.sleep(3000);
		driver.navigate().back(); // Amazon
		Thread.sleep(3000);
		driver.navigate().forward(); // CMS
		Thread.sleep(3000);
		driver.navigate().refresh(); // CMS
		Thread.sleep(3000);		
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
