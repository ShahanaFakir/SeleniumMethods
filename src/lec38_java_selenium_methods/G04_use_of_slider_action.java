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

public class G04_use_of_slider_action {
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
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// not used in the framework, rarely asked in the interview
	// so focus on line 49
	@Test(enabled = true, priority = 1)
	public void sliderActionTest01() throws InterruptedException {
		// Instantiate Action Class
		Actions actions = new Actions(driver);
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
		// Move mouse to x offset 50 i.e. in horizontal direction
		Thread.sleep(5000);
		// to test the slider is working or not
		// dragAndDrop (int xoffset, int yoffset)
		actions.dragAndDropBy(slider, 80, 0).build().perform(); // learn from here
		Thread.sleep(5000);
		// slider.click();
		System.out.println("Moved slider in horizontal directions");
	}

	// Alternative
	@Test(enabled = true, priority = 2)
	public void sliderActionTest2() throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.clickAndHold(slider);
		actions.moveByOffset(65, 0).build().perform();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
