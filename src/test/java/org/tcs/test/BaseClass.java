package org.tcs.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAJAPPA\\Desktop\\JavaPractise\\SamTest\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void getUrl(String url) {
		driver.get(url);

	}
	
	public static void enterText(WebElement e, String text) {
		
	e.sendKeys(text);

	}
	
	public static  void btnClick(WebElement e) {
		e.click();
	}
	
	public static void quitBrowser() {
		driver.quit();

	}

}
