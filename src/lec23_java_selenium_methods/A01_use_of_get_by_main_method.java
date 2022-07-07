package lec23_java_selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_use_of_get_by_main_method {

	public static void main(String[] args) {
		// System is a class and setProperty is a method
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tofael\\eclipse-workspace\\April2022CoreJava\\driver\\chromedriver.exe");
		// WebDriver is an interface and ChromeDriver is a concrete class which implements WebDriver interface
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // or fullscreen() method
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com"); // we learn from here
		driver.quit();
	
	}

}
