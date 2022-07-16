package lec27_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C04_use_of_isSelected_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// TODO Still not working, need to talk with Developer
	@Test(enabled = true, priority = 1)
	public void checkBoxSelectedTest02() {
		boolean checkBoxSelectled02 = driver.findElement(By.xpath("//label[normalize-space(text())='Other']")).isSelected();
		System.out.println("Is the check Box Selectled? Ans: " + checkBoxSelectled02);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
