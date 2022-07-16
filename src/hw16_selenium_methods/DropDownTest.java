package hw16_selenium_methods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\misai\\eclipse-workspace\\SeleniumMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void selectByIndexTest01() throws InterruptedException {
		WebElement dropElement = driver.findElement(By.cssSelector(
				"select.nav-search-dropdown.searchSelect.nav-progressive-attrubute.nav-progressive-search-dropdown"));
		Select select = new Select(dropElement);
		select.selectByIndex(15);
		Thread.sleep(2000);

	}

	@Test(enabled = true, priority = 2)
	public void selectByIndexTest02() throws InterruptedException {
		WebElement dropElement = driver.findElement(By.cssSelector(
				"select.nav-search-dropdown.searchSelect.nav-progressive-attrubute.nav-progressive-search-dropdown"));
		Select select = new Select(dropElement);
		select.selectByVisibleText("Books");
		Thread.sleep(2000);

	}

	@Test(enabled = true, priority = 3)
	public void selectByIndexTest03() throws InterruptedException {
		WebElement dropElement = driver.findElement(By.cssSelector(
				"select.nav-search-dropdown.searchSelect.nav-progressive-attrubute.nav-progressive-search-dropdown"));
		Select select = new Select(dropElement);
		select.selectByValue("search-alias=mobile-apps");
		Thread.sleep(2000);

	}

	@AfterTest
	public void endingBrowser() {
		driver.quit();
	}

}
