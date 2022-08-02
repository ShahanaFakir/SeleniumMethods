package lec38_java_selenium_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C09_use_of_getAttribute_method {
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

	@Test(enabled = true, priority = 1)
	public void getAttributeTest() {
		String value01 = driver.findElement(By.xpath("//a[text()='New User Registration']")).getAttribute("id");
		String value02 = driver.findElement(By.xpath("//a[text()='New User Registration']")).getAttribute("class");
		String value03 = driver.findElement(By.xpath("//a[text()='New User Registration']")).getAttribute("title");
		String value04 = driver.findElement(By.xpath("//a[text()='New User Registration']")).getAttribute("href");
		System.out.println("The value of the id attribute is: " + value01);
		System.out.println("The value of the class attribute is: " + value02);
		System.out.println("The value of the title attribute is: " + value03);
		System.out.println("The value of the href attribute is: " + value04);

	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
