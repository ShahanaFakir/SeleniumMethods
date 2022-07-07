package hw15_selenium_methods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IsSelectedMethods {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.macys.com/account/signin/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test(enabled = true, priority = 1)
	public void onlyCheckThisboxtest() throws InterruptedException {
		boolean checkBoxSelect = driver.findElement(By.cssSelector("input.standard-form.login365-checkbox"))
				.isSelected();
		System.out.println("Is the check box selected? Ans: " + checkBoxSelect);
		Thread.sleep(5000);
	}

	@AfterTest
	public void endingBrowser() {
		driver.quit();

	}

}
