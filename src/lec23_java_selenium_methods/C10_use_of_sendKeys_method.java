package lec23_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C10_use_of_sendKeys_method {
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

	@Test(enabled = true, priority = 1)
	public void userIdTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cms-login-userId']")).sendKeys("p2ph1test_ms497");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cms-login-password']")).sendKeys("Password@12");
		Thread.sleep(5000);

	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
