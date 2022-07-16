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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

public class E02_use_of_sendKeys_method_by_javascriptExecutor {
	WebDriver driver;
	JavascriptExecutor js;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// Regular way to click a submit button to search something	
		@Test (enabled=false, priority = 1)
		public void searchAProductTest01() throws InterruptedException{		
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
			Thread.sleep(3000);
			driver.findElement(By.id("nav-search-submit-button")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPad");
			Thread.sleep(3000);
			driver.findElement(By.id("nav-search-submit-button")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			Thread.sleep(3000);
		}
		
		// click submit button by Enter key from keyboard	
		@Test (enabled=false, priority = 2)
		public void searchAProductTest02() throws InterruptedException{		
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Del xps", Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nexus", Keys.RETURN);
			Thread.sleep(3000);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			Thread.sleep(3000);
		}
		
		// Alternative of sending value in text field --- By using JavascriptExecutor 01
		// TODO Failed, have to look again. doom is not loading
		@Test(enabled = true, priority = 3)
		public void searchItemByclickingSearchButtonTest01() throws InterruptedException {
			WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
			WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
			js.executeScript("arguments[0].value='MacBook'", searchField); // how to send value
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", searchButton); // how to click 
			Thread.sleep(5000);
		}
		
		// Alternative of sending value in text field --- By using JavascriptExecutor 02
		// Use above one, this one I don't like, also difficult to remember
		// because using xpath is difficult
		@Test(enabled = true, priority = 4)
		public void searchItemByclickingSearchButtonTest03() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('twotabsearchtextbox').value = 'iPad';");
			Thread.sleep(4000);
			js.executeScript("document.getElementById('nav-search-submit-button').click();");
			Thread.sleep(4000);
		}
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
