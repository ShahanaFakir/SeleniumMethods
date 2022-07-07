package lec23_java_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A02_use_of_get_by_testNG {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		// 1st way, to show the location of chrome driver
		// absolute path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tofael\\eclipse-workspace\\April2022CoreJava\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void urlTest() {
		driver.get("https://www.amazon.com");
	}
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
