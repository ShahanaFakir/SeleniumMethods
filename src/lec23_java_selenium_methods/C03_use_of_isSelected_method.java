package lec23_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//isEnabled() is the method used to verify if the web element is enabled or
//disabled within the web page. isEnabled() is primarily used with buttons.
//Use of isEnabled(), a boolean type method

public class C03_use_of_isSelected_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// To learn more: https://www.youtube.com/watch?v=LywLnI7hHhw
	@Test(enabled = false, priority = 2)
	public void checkBoxSelectedTest01() {
		boolean checkBoxSelectled01 = driver.findElement(By.cssSelector("label#cms-label-tc")).isSelected();
		System.out.println("Is the check Box Selectled? Ans: " + checkBoxSelectled01);
	}
	
	//TODO Nasir
	// we have to findout the webelement of check box only
	@Test(enabled = true, priority = 1)
	public void checkBoxEnabledTest02() throws InterruptedException {
		driver.findElement(By.cssSelector("label#cms-label-tc")).click(); // it will click the check box
		Thread.sleep(5000); // Then wait
		boolean checkBoxSelected02 = driver.findElement(By.cssSelector("label#cms-label-tc")).isSelected(); // Evaluate selected or not
		System.out.println("Is the Check Box Selected? Ans: " + checkBoxSelected02);
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
