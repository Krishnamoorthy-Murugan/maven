package com.testingtestng;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
 static WebDriver driver;
	public static void scrolldown(WebElement webele) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", webele);
	}
	public static void main(String[] args) throws AWTException {

WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
			driver.manage().window().maximize();
	driver.get( "https://demo.guru99.com/test/guru99home/");
	WebElement txtele = driver.findElement(By.xpath("//h3[contains(text(),'iFrame')]"));
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", txtele);
	String text = txtele.getText();
	System.out.println(text);
	
	driver.switchTo().frame("a077aa5e");
	WebElement img = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
	img.click();
	driver.switchTo().defaultContent();
	String text1 = txtele.getText();
	System.out.println(text1);
	driver.close();
	
	 }
		}


