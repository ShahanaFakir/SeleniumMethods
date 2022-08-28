package hw17_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UseHeadlessBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", " ./driver/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("headless");
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.target.com/");
		Thread.sleep(5000);
		System.out.println("The current Url is: " + driver.getCurrentUrl());
		System.out.println("Test execution completed");
		driver.quit();

	}

}
