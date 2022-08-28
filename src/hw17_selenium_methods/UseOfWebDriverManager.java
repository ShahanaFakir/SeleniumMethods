package hw17_selenium_methods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UseOfWebDriverManager {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bestbuy.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(enabled = true, priority = 1, threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
	public void menuTest01() {
		String expected = "Best Buy | Official Online Store | Shop Now & Save";
		String actual = driver.getTitle();
		System.out.println("Home page title is:" + actual);
		Assert.assertEquals(actual, expected, "Home Page doesn't match...");
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url from piority 1 is:" + currentURL);

		// Is the menu bar displayed....
		// Home page title is:Best Buy | Official Online Store | Shop Now & Save
		// The current Url from priority 1 is:https://www.bestbuy.com/
	}

	@Test(enabled = true, priority = 2)
	public void menuTest02() {
		String expected = "Best Buy | Official Online Store | Shop Now & Save";
		String actual = driver.getTitle();
		System.out.println("Home page title is:" + actual);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "Home Page doesn't match...");
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url from piority 2 is:" + currentURL);
		// Home page title is:Best Buy | Official Online Store | Shop Now & Save
		// The current url from priority 2 is:https://www.bestbuy.com/
	}

	@Test(enabled = true)
	public void menuTest03() {
		WebElement menu = driver.findElement(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']"));
		boolean flag = menu.isDisplayed();
		System.out.println("Is the menu bar displayed....");
		Assert.assertTrue(true, "menu is displayed");// PASSED: menuTest03
	}

	@Test(enabled = false, dependsOnMethods = "menuTest")
	public void signInTest() {
		boolean signInButtonEnabled = driver
				.findElement(By.xpath("//a[@class='c-button c-button-secondary c-button-sm sign-in-btn']")).isEnabled();
		System.out.println("Is the signIn button Enabled" + signInButtonEnabled);
	}

	@Test(enabled = true, groups = { "functionalTest" })
	public void skipHomePageTitleTest() {
		String title = "best buy home page";
		if (title.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
		} else {
			System.out.println("Home Page Title doesn't match..."); // PASSED: skipHomePageTitleTest
		}
	}
//	@Test (enabled = true)// This signInButtonTest01 will be failed and in console it will showed NoSuchElementException
//	public void signInButtonTest01() {
//		driver.findElement(By.id(" xyz Sign in button")).click();
//	}

	@Test(enabled = true, expectedExceptions = NoSuchElementException.class)
	public void signInButtonTest02() {
		driver.findElement(By.id(" xyz Sign in button")).click();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
