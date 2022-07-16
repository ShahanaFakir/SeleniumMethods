package hw16_selenium_methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetSizeMethods {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void SetSizeOfWindowTest() throws InterruptedException {
		Dimension dimension = new Dimension(900, 498);
		driver.manage().window().setSize(dimension);
		driver.get("https://www.macys.com/");
		Thread.sleep(3000);
		System.out.println("The size of the screen is: " + driver.manage().window().getSize());

	}

	@AfterTest
	public void endingBrowser() {
		driver.quit();

	}

}
