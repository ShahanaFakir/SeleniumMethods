package lec38_java_selenium_methods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class G02_use_of_double_click_action {
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
		driver.get("http://demo.guru99.com/test/simple_context_menu.html"); 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// not used in the framework, rarely asked in the interview
	// so focus on line 45
	@Test (enabled = true, priority = 1)
	public void rightClickActionTest() throws InterruptedException {
		WebElement dcButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions actions = new Actions(driver);
		actions.doubleClick(dcButton).build().perform(); // to do the double click, doubleClick() is used
		Thread.sleep(5000);
		
		// Not part of the double click action
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
