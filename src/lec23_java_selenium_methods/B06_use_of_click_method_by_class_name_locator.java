package lec23_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B06_use_of_click_method_by_class_name_locator {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	}
	
	@Test
	public void newUserRegistrationButtonTest() throws InterruptedException {
		driver.findElement(By.className("cms-newuser-reg")).click();    // Learn from here , use of class attribute
		Thread.sleep(5000);
	}
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
