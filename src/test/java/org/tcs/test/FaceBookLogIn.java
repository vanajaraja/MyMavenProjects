package org.tcs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FaceBookLogIn extends BaseClass{
	@BeforeClass
	private void browserReady() {
		String url="https://www.tutorialspoint.com/testng/testng_overview.htm";
		browserLaunch();
		getUrl(url);
		System.out.println(Thread.currentThread().getId());
	}
	
	@AfterClass
	 private void CloseBrowser() {
		quitBrowser();
	}
	
	@Test (groups="Smoke")
	private void testNGHome() {
		WebElement lnkInterviewQ = driver.findElement(By.linkText("TestNG - Home"));
		lnkInterviewQ.click();
		String pagetitle = driver.getTitle();
		Assert.assertTrue(pagetitle.contains("Tutorial"), "Verifying the title");
	}
	
	@Test (groups="Regression")
	private void testNGOverview() {
		WebElement lnkInterviewQ = driver.findElement(By.linkText("TestNG - Overview"));
		lnkInterviewQ.click();
		String pagetitle = driver.getTitle();
		
		Assert.assertTrue(pagetitle.contains("Overview"), "Verifying the title");
	}
	
	@Test (groups= {"Regression","Smoke"} )
	private void testNGEnvrn() {
		WebElement lnkInterviewQ = driver.findElement(By.linkText("TestNG - Environment"));
		lnkInterviewQ.click();
		String pagetitle = driver.getTitle();
		
		Assert.assertTrue(pagetitle.contains("Environment"), "Verifying the title");
	}
	
	@Test  (groups="Regression")
	private void testNGWriteTest() {
		WebElement lnkInterviewQ = driver.findElement(By.linkText("TestNG - Writing Tests"));
		lnkInterviewQ.click();
		String pagetitle = driver.getTitle();
		
		Assert.assertTrue(pagetitle.contains("Writing"), "Verifying the title");
	}

}
