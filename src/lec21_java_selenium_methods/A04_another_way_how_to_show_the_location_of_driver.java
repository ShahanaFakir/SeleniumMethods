package lec21_java_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A04_another_way_how_to_show_the_location_of_driver {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		// 3rd way, to show the location of chrome driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe"); // we learn from here
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void urlTest() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(3000); // Use for Pause 
	}
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
