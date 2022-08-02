package lec38_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C05_use_of_getTitle_method {
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

	// how can you find the title of the page?
	// right click on an empty place of any page -- click "view page source" -- ctrl+f (to find) -- Type title
	@Test(enabled = true, priority = 1)
	public void titleOfThePageTest() {
		System.out.println("The title of the Page is: " + driver.getTitle());
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
