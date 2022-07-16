package hw16_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAllCookiesMethods {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void deleteCookiesTest() {
		driver.get("https://www.macys.com/");
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

	}

	@AfterTest
	public void endingBrowser() {
		driver.quit();

	}

}
