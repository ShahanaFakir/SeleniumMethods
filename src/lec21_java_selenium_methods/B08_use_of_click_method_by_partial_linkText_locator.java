package lec21_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B08_use_of_click_method_by_partial_linkText_locator {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	}
	
	// source: at the bottom of the page, first element from Sell column is 'Start Selling'
	// when there is no priority, then the test cases run alphabetically
	@Test (enabled = true, priority = 2)
	public void startSellingTest01() throws InterruptedException {
		driver.findElement(By.partialLinkText("Start s")).click();    // Learn from here , use of class attribute
		Thread.sleep(5000);
	}
	
	@Test (enabled = true, priority = 1)
	public void startSellingTest02() throws InterruptedException {
		driver.findElement(By.partialLinkText("Start s")).click();    // Learn from here , use of class attribute
		Thread.sleep(5000);
	}
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
