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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.AbstractParallelWorker.Arguments;

public class F03_use_of_expectedExceptions {
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
	
	@Test (enabled = true)
	public void testNGExceptionTest01(){
		System.out.println("We can verify whether a code throws the expected exception or not. Here it will fail");
		int i = 1/0;		
	}
	
	@Test (enabled = true, expectedExceptions = ArithmeticException.class)
	public void testNGExceptionTest02(){
		System.out.println("We can verify whether a code throws the expected exception or not. Here it will Pass, because we used expectedExceptions attribute");
		int i = 1/0;		
	}
	
	@Test (enabled = true, expectedExceptions = NoSuchElementException.class)
	public void loginButtonTest() {
		driver.findElement(By.id("I added here-cms-login-submit")).click();
	}
	
	
		
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
