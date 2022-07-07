package seleniumMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeSelenium {
		WebDriver driver;
		@BeforeTest
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\misai\\\\eclipse-workspace\\\\SeleniumMethods\\\\driver\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 
			driver.manage().deleteAllCookies();
			driver.get("https://portal.cms.gov/portal/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		}
		
		@Test
		public void logoTest() throws InterruptedException {
			boolean elementDisplayed = driver.findElement(By.xpath("//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")).isDisplayed();
			Thread.sleep(5000);
			System.out.println("Is the logo displayed? Ans: " + elementDisplayed); // This is not necessary, I gave you guys comfort about the boolean method
		}
		
		
		@AfterTest
		public void tearUp() {
			driver.quit();
		}

	}


