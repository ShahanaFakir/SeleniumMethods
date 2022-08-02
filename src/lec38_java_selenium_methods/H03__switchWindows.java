package lec38_java_selenium_methods;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class H03__switchWindows {
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
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void switchWindows() throws InterruptedException {
		String mainWindow = driver.getWindowHandle(); // learn this line
		System.out.println("Main Window ID: " + mainWindow + "\n");
		// click the new Window button
		driver.findElement(By.xpath("//button[text()='New Window']")).click();
		Thread.sleep(5000);
		// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
		
		// Get all window handles -- include parent + child
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Windows Open After Click: " + allWindowHandles.size());
		// Extract Parent and child window from all window handles
		String parent = (String) allWindowHandles.toArray()[0]; // first index: parent
		String child = (String) allWindowHandles.toArray()[1]; // second index: child 

		//	Use window handle to switch from one window to other window (parent to child)
		driver.switchTo().window(child); // switchTo() -- method is used to switch from one to another
		
	}
		
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
