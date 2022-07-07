package hw15_selenium_methods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClearMethod {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.macys.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test
	public void searchingProductTest() throws InterruptedException {
		driver.findElement(By.cssSelector("input.globalSearchInputField.right")).sendKeys("Babyclothes");
		Thread.sleep(2000);
		driver.findElement(By.className("icon-search-large")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.globalSearchInputField.right")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.globalSearchInputField.right")).sendKeys("Shoes");
		Thread.sleep(3000);
		driver.findElement(By.className("icon-search-large")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.globalSearchInputField.right")).clear();
		Thread.sleep(3000);
	}

	@AfterTest
	public void endingBrowser() {
		driver.quit();

	}

}
