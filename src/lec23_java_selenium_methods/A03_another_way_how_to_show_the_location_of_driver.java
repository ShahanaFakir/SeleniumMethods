package lec23_java_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A03_another_way_how_to_show_the_location_of_driver {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		// 2nd way, to show the location of chrome driver
		// relative path
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); // we learn from here
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void urlTest() {
		driver.get("https://www.bestbuy.com");
	}
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
