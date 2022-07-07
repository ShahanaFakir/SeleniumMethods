package lec23_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B10_use_of_click_method_by_cssSelector_locator_using_class {
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
	
	// if the class contain separate words [btn btn-prim gh-spr], they are actually different class, then
	// we have to close the gap between class by putting dot/period between them
	// cssSelector by class --> first html tag, then dot, then write class name inside the string, 
	// remove the space between class, and replace with dot or period
	@Test (enabled = true, priority = 2)
	public void searchButtonClickTest() throws InterruptedException {
		driver.findElement(By.cssSelector("input.btn.btn-prim.gh-spr")).click();    // Learn from here , use of class attribute
		Thread.sleep(5000);
	}
			
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
