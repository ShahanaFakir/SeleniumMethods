package seleniumMethods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

public class SendKeyMethodPractice {
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

	@Test
	public void userIdTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.name("user.email_address")).sendKeys("afrose_699@yahoo.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='pw-input']")).sendKeys("11301988A");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='sign-in']")).click();
		Thread.sleep(10000);
	}

	@AfterTest
	public void endingBrowser() {
		driver.quit();

	}

}
