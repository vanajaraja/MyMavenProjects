package org.tcs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Paramet extends BaseClass {
	@BeforeClass
	private void browserReady() {
		String url="https://www.amazon.com/";
		browserLaunch();
		getUrl(url);
		System.out.println(Thread.currentThread().getId());
	}
	
	@AfterClass
	 private void CloseBrowser() {
		quitBrowser();
	}
	@Parameters({"username","email","password","confirmpassword"})
	@Test (groups= {"Regression" , "Smoke"})
	
	private void signUp(@Optional("newtester")String s1,@Optional("test1.tes@gmail.com")String s2,String s3,String s4) throws InterruptedException {
	WebElement signUpMenu = driver.findElement(By.id("nav-link-accountList"));
	Actions a = new Actions(driver);
	a.moveToElement(signUpMenu).perform();
	WebElement signStartLink = driver.findElement(By.linkText("Start here."));
	a.moveToElement(signStartLink).click().perform();
	Thread.sleep(6000);
	Assert.assertTrue(driver.getTitle().contains("Registration"), "Verify that navigated to Registration Page");
	WebElement txtUserName = driver.findElement(By.id("ap_customer_name"));
	enterText(txtUserName, s1);
	//driver.findElement(arg0)
	WebElement txtEmail = driver.findElement(By.id("ap_email"));
	enterText(txtEmail, s2);
	String actual = txtEmail.getAttribute("value");
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actual, "test1.tes@gmail.com", "Optional email id entered");
	WebElement txtpass = driver.findElement(By.id("ap_password"));
	enterText(txtpass, s3);
	WebElement txtConfirmPass = driver.findElement(By.id("ap_password_check"));
	enterText(txtConfirmPass,s4);
	
	WebElement btnCreateAccount = driver.findElement(By.id("continue"));
	btnCreateAccount.click();
	Thread.sleep(6000);
	Assert.assertTrue(driver.getTitle().contains("Authentication"), "Verify that navigated to Authentication page");
	}
	
	
	@Test(enabled=false)
	private void Covid19Message() {
		//driver.switchTo().frame("DAsis");
		WebElement coVid19 = driver.findElement(By.xpath("//*[@id='nav-upnav']"));
		WebElement img = driver.findElement(By.xpath("(//img//ancestor::a)[1]"));
		String attribute = img.getAttribute("aria-label");
		System.out.println(attribute);
		
		/*String text = coVid19.getText();
		System.out.println(text);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(text.equalsIgnoreCase("COVID"), "Amazon has COVID-19 Message at the Home Page");
	//	Assert.assertTrue(text.equalsIgnoreCase("COVID"), "Amazon has COVID-19 Message at the Home Page");
		sa.assertAll();*/
		

	}

}
