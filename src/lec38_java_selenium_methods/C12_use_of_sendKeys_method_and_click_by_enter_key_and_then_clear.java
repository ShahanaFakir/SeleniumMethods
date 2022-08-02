package lec38_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C12_use_of_sendKeys_method_and_click_by_enter_key_and_then_clear {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void searchingProductsTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("SOCCER BALL", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Basketball", Keys.RETURN);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();		
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
