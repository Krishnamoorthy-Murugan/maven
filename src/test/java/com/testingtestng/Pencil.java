package com.testingtestng;


import org.base.BaseClass;
import org.pojoclassses.AllLocatorsPOJO;
import org.testng.annotations.Test;

public class Pencil extends BaseClass{


	@Test(groups="Smoke")
	private void tc21() {
		System.out.println(Thread.currentThread().getId());
		launchBrowser();
		maxwindow();
launchUrl("https://www.flipkart.com/");
AllLocatorsPOJO a = new AllLocatorsPOJO();
passtext(a.getFbEmail(), "dfdf");
driver.quit();
System.out.println("smoke");

	}
	
	@Test(groups="Sanity")
	private void tc22() {
		System.out.println(Thread.currentThread().getId());
		launchBrowser();
		maxwindow();
launchUrl("https://www.flipkart.com/");
closeBrowser();
System.out.println("sanity");

	}
	
	@Test(groups="Regression")
	private void tc23() {
		System.out.println(Thread.currentThread().getId());
		launchBrowser();
		maxwindow();
launchUrl("https://www.amazon.in/");
closeBrowser();
System.out.println("regression");

	}
	

	
	
	
	
}
