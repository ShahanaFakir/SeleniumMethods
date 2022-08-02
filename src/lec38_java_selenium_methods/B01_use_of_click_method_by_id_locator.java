package lec38_java_selenium_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B01_use_of_click_method_by_id_locator {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
	}
	
	@Test
	public void loginButtonTest() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).click(); // Learn from here, use of id attribute
		Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
