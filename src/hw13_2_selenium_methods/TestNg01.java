package hw13_2_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg01 {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void urlTest() throws InterruptedException {
		driver.get("https://www.bestbuy.com/");
		Thread.sleep(3000);
		driver.get("https://www.target.com/");
		Thread.sleep(5000);

	}

	@AfterTest
	public void tearUp() {
		driver.quit();

	}

}
