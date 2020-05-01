package org.tcs.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamWait extends BaseClass{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		browserLaunch();
		getUrl("https://www.seedschool.co.in/");
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
		
		
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver);
		f.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		
		
		
	}

}
