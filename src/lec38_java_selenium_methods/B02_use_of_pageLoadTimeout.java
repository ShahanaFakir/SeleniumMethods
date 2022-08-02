package lec38_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B02_use_of_pageLoadTimeout {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Learn from here
		// WebDriver will wait for 20 seconds to load the page and then it will through exception
		// But if the loading is done before 20 seconds, it will go to next level
		
	}
	
	@Test
	public void loginButtonTest() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).click();
		Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
