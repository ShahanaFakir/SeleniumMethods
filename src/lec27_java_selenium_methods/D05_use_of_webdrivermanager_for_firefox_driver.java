package lec27_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D05_use_of_webdrivermanager_for_firefox_driver {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		// if you choose version, then it will use that specific version
		// if you don't use driverVersion() method, it will open the most updated version
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); // Make sure about this line
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
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
