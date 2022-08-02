package lec38_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B11_use_of_click_method_by_cssSelector_locator_using_id {
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
	
	// cssSelector by id 
	// first html tag, then # (hash), then write the value of id attribute inside the string
	@Test
	public void loginButtonTest() throws InterruptedException {
		driver.findElement(By.cssSelector("button#cms-login-submit")).click();    // Learn from here , use of class attribute
		Thread.sleep(5000);
	}
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
