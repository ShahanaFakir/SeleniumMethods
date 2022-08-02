package lec38_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.AbstractParallelWorker.Arguments;

public class F06_use_of_SkipException {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://portaldev.cms.gov/portal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// Explain in the next class, forgot to add
	@Test(enabled = true, groups = { "functionalTest" })
	public void nonSkipHomePageTitleTest() {
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("home page title is: " + actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match...");	
		System.out.println("No need to skip the test");
	}	
	
	@Test(enabled = true, groups = { "functionalTest" })
	public void skipHomePageTitleTest() {
		String title = "CMS Enterprise Portal";
		if (title.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
		} else {
			System.out.println("Home Page Title doesn't match...");
		}
		System.out.println("I am out of the if else condition");
	}	
	
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
