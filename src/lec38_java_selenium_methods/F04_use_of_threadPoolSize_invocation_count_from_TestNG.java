package lec38_java_selenium_methods;

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

public class F04_use_of_threadPoolSize_invocation_count_from_TestNG {
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
	
	// use of invocation count, when? -- if you know some test cases fail for no reason
	// and then you fix it, you can run more than one time by invocation count	
	// use of threadPoolSize
	//TODO Is the threadPoolSize working? NEED TO RESOLVED, may be working as multi threaded, can't see, need to be make sure
	@Test (enabled = true, priority = 1, threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
	public void titleTest() {	
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("Home Page Title is: "+actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ...");
		System.out.println("Thread: "+ Thread.currentThread().getName()); // to know which thread is running

	}
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
