package lec27_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.AbstractParallelWorker.Arguments;

public class F01_use_of_different_type_of_assert {
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
	
	@Test (enabled = true, priority = 1)
	public void titleTest01() {	
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("Home Page Title is: "+actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ..."); // Hard Assertion
		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 1 is: "+currentURL);
	}
	
	@Test (enabled = true, priority = 2)
	public void titleTest02() {	
		String expected = "A CMS Enterprise Portal"; // WHICH is wrong
		String actual = driver.getTitle();
		System.out.println("Home Page Title is: "+actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ...");	// Hard Assertion, if failed no next step
		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 2 is: "+currentURL);
	}
	
	@Test (enabled = true, priority = 3)
	public void titleTest03() {	
		String expected = "A CMS Enterprise Portal"; // WHICH is wrong
		String actual = driver.getTitle();
		System.out.println("Home Page Title is: "+actual);
		SoftAssert softAssert = new SoftAssert(); 	// Soft Assertion, mainly interview question, not used generally
		softAssert.assertEquals(actual, expected, "Home Page Title doesn't match ..." );
		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 3 is: "+currentURL);
		
	}
	
	@Test (enabled = true, priority = 4)
	public void logoTest(){
		WebElement logo = driver.findElement(By.xpath("//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");	// error message will be appeared when the assertion failed 
	
	}
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
