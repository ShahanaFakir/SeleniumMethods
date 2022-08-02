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

public class F05_use_of_dependsOnMethods_from_TestNG {
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
	public void logoTest(){
		WebElement logo = driver.findElement(By.xpath("//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");	
	}
	
	@Test(enabled = false, dependsOnMethods = "logoTest")
	public void newUserRegistrationTest() {
		boolean nurButtonEnabled = driver.findElement(By.xpath("//a[text()='New User Registration']")).isEnabled();
		System.out.println("Is the New User Registration Button Enable? Ans: " + nurButtonEnabled);
	}
			
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
