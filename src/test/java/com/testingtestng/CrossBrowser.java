package com.testingtestng;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser extends BaseClass{

	@Parameters("browser")
	@Test
	private void tc1(String browserName) {
WebDriver driver;

if (browserName.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
}

else if (browserName.equals("edge")) {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}

else {
WebDriverManager.firefoxdriver().setup();
driver=new FirefoxDriver();

}
driver.get("https://www.flipkart.com/");
driver.quit();
	}
@Parameters("browser")	
@Test
private void tc2(String browsertype) {
browser(browsertype);
launchUrl("https://www.facebook.com/");
closeBrowser();


}
	
}
