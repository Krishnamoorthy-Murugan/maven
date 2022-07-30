package com.testingtestng;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.pojoclassses.AllLocatorsPOJO;
import org.testng.annotations.Test;

public class Book extends BaseClass{

	@Test(groups= {"Smoke","Sanity"})
	private void tc1() {
		System.out.println(Thread.currentThread().getId());
		launchBrowser();
		maxwindow();
launchUrl("https://www.amazon.in/");
driver.quit();
System.out.println("sanity s");
	}
	
	@Test(groups= {"Sanity","Regression"})
	private void tc2() {
		System.out.println(Thread.currentThread().getId());
		launchBrowser();
		maxwindow();
launchUrl("https://www.facebook.com");
closeBrowser();
System.out.println("sanity r");

	}
	
	@Test(groups= {"Regression","Smoke"})
	private void tc3() {
		System.out.println(Thread.currentThread().getId());
		launchBrowser();
		maxwindow();
		launchUrl("https://www.flipkart.com/");

driver.quit();
System.out.println("Smoke r");

	}
	

	
	
	
	
	
}
