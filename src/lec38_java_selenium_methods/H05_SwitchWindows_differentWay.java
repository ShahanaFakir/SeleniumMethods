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

public class H05_SwitchWindows_differentWay {
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
		driver.get("https://enthrallit.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test(enabled = true, priority = 1)
	public void switchWindows() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		Thread.sleep(3000);
		
		// This will scroll up the page by 1000 pixel vertically
		Thread.sleep(4000); // used to see the scroll
		js.executeScript("window.scrollBy(0,1000)", ""); // scroll down
		Thread.sleep(4000);
		
		String mainWindow = driver.getWindowHandle(); // learn this line
		System.out.println("Main Window ID: " + mainWindow + "\n");
		
		// click on the Open Window button
		driver.findElement(By.xpath("(//button[text()='Open Window'])[1]")).click();
		Thread.sleep(5000);
		
		// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
		
		// Get all window handles -- include parent + child
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Total Windows Open: " + allWindowHandles.size());
		
		// for each loop
		for (String windowHandle : allWindowHandles) {
			if (mainWindow.equals(windowHandle)) {
				System.out.println("\t Window ID 1: \t" + windowHandle + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			} else {
				driver.switchTo().window(windowHandle);
				System.out.println("\t Window ID 2: \t" + windowHandle + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			}
		}			
	}
		
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
