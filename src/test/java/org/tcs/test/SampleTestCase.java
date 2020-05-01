package org.tcs.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.cyberneko.HTMLScanner.CurrentEntity;

public class SampleTestCase {
	
	public static WebDriver driver;
	@BeforeClass
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAJAPPA\\Desktop\\JavaPractise\\SamTest\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	
	private void quitBrowser() {
		System.out.println(" quite Browser");
		driver.quit();

	}
	
	@BeforeMethod
	
	private void startTime() {
	System.out.print("Test Starts At");
	Date d = new Date(0);
	System.out.println(d);
		
	}
	
	@AfterMethod
	
	private void endTime() throws IOException {
		System.out.println("Test ends at");
		Date d = new Date(0);
		System.out.println(d);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File loginPageScreen = ts.getScreenshotAs(OutputType.FILE);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy") ;
		   LocalDateTime now = LocalDateTime.now(); 
		   String runtime = dtf.format(now);
		   System.out.println(runtime);  
		 
		
		String Filepath= "C:\\Users\\RAJAPPA\\Desktop\\JavaPractise\\Results\\LoginPageScreen_" + runtime+".PNG";
		System.out.println(Filepath);
		 File desc = new File (Filepath);
		 FileUtils.copyFile(loginPageScreen, desc);
		
	}
	@Test
	private void testcase1() {
	System.out.println("tc1");
	driver.get("https://www.facebook.com/");
	WebElement txtEmail = driver.findElement(By.id("email"));
	txtEmail.sendKeys("Test");
	WebElement txtpass = driver.findElement(By.id("pass"));
	txtpass.sendKeys("password");
	 WebElement btnClick = driver.findElement(By.xpath("//input[@type='submit']"));
	 btnClick.click();
	 
	 
	}
	
	@Test
	private void testcase2() {
		System.out.println("Tcs2");
		driver.get("https://www.facebook.com/");
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("new");
		WebElement txtpass = driver.findElement(By.id("pass"));
		txtpass.sendKeys("password");
		 WebElement btnClick = driver.findElement(By.xpath("//input[@type='submit']"));
		 btnClick.click();
	}
	
	@Test
	private void testcase3() {
		System.out.println("Tcs3");
		driver.get("https://www.facebook.com/");
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("old");
		WebElement txtpass = driver.findElement(By.id("pass"));
		txtpass.sendKeys("password");
		 WebElement btnClick = driver.findElement(By.xpath("//input[@type='submit']"));
		 btnClick.click();
	}

}
