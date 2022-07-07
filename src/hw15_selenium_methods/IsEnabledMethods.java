package hw15_selenium_methods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IsEnabledMethods {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.jcpenney.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test
	public void signInButtontest() throws InterruptedException {
		boolean signInButtonEnabled = driver.findElement(By.cssSelector("button.vIpbG.juQqs.w-QAi.iQ2RY._8gsRn"))
				.isEnabled();
		System.out.println("Is the signIn button enabled? Ans: " + signInButtonEnabled);
		Thread.sleep(5000);

	}

	/*
	 * public void signInButtonTest02() throws InterruptedException {
	 * driver.findElement(By.name("signin-continue-btn")).click();
	 * Thread.sleep(3000);
	 * 
	 * }
	 */

	@AfterTest
	public void endingBrowser() {
		driver.quit();

	}

}
