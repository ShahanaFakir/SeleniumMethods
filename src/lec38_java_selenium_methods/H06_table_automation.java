package lec38_java_selenium_methods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class H06_table_automation {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test(enabled = true, priority = 1)
	public void readTable() throws InterruptedException {
		WebElement table = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon"));
		System.out.println(table.getText());
		System.out.println("\n------------------------------------------------------------\n");
	}
	
	
	@Test(enabled = true, priority = 2)
	public void readAnyRowofTheTable() {
		WebElement row = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(3)"));
		System.out.println(row.getText());
		System.out.println("\n------------------------------------------------------------\n");
	}

	@Test(enabled = true, priority = 3)
	public void readCellOfAnyRowofTheTable() {
		WebElement row = driver
				.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(1) td:nth-child(3)"));
		System.out.println(row.getText());
		System.out.println("\n------------------------------------------------------------\n");
	}

	@Test(enabled = true, priority = 4)
	public void readAllRowofTheTable() {
		List<WebElement> listOfWebElements = driver.findElements(By.cssSelector("table.navFooterMoreOnAmazon tr"));
		List<String> rows = new ArrayList<String>();
		for (WebElement element : listOfWebElements) {
			rows.add(element.getText());
		}
		for (String st : rows) {
			System.out.println(st);
			System.out.println(rows);
		}

	}

		
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
