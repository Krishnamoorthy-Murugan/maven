package org.base;

import java.awt.AWTException;
import java.awt.KeyEventPostProcessor;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import bsh.Variable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Select s;
	public static JavascriptExecutor js;

	public static void launchBrowser() {	
				WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
	}
public static void browser(String browserName) {
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
}
	public static void maxwindow() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void currentPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void currentPageurl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void closeCurrentWindow() {
		driver.close();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void passtext(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void clickBtn(WebElement element) {
		element.click();
	}

	public static String sendParticularValue(int sheetNum, int rowNum, int cellNum) throws IOException {
		File f = new File("D:\\Java Projects - eclipse workspace\\MavenTech\\excelfile\\BookingHotel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet mysheet = w.getSheetAt(sheetNum);
		Row itrRow = mysheet.getRow(rowNum);
		Cell itrCell = itrRow.getCell(cellNum);
		int cellType = itrCell.getCellType();
		String sendValues = "";
		if (cellType == 1) {
			sendValues = itrCell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(itrCell)) {
			Date dd = itrCell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			sendValues = s.format(dd);

		} else {
			double numericCellValue = itrCell.getNumericCellValue();
			long l = (long) numericCellValue;
			sendValues = String.valueOf(l);
		}
		return sendValues;

	}

	public static void createExcel(String fileName, String sheetName) throws IOException {
		File f = new File("D:\\Java Projects - eclipse workspace\\MavenTech\\excelfile\\" + fileName + ".xlsx");

		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet(sheetName);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("created...");

	}

	public static void createNewCell(String sheetName, int getTheRow, int createTheCell, String data)
			throws IOException {
		File f = new File("D:\\Java Projects - eclipse workspace\\MavenTech\\excelfile\\BookingHotel.xlsx");
		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);
		Sheet newSheet = w.getSheet(sheetName);
		Row newRow = newSheet.getRow(getTheRow);
		Cell newCell = newRow.createCell(createTheCell);
		newCell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("writed......");
	}

	public static void createNewRow(String sheetName, int createTheRow, int createTheCell, String datas)
			throws IOException {
		File f = new File("D:\\Java Projects - eclipse workspace\\MavenTech\\excelfile\\BookingHotel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet newSheet = w.getSheet(sheetName);
		Row newRow = newSheet.createRow(createTheRow);
		Cell newCell = newRow.createCell(createTheCell);
		newCell.setCellValue(datas);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("writed......");

	}

	public static void updateExcel(String sheetName, int getTheRow, int getTheCell, String getTheData,
			String setTheData) throws IOException {
		File f = new File("D:\\Java Projects - eclipse workspace\\MavenTech\\excelfile\\BookingHotel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet newSheet = w.getSheet(sheetName);
		Row newRow = newSheet.getRow(getTheRow);
		Cell newCell = newRow.getCell(getTheCell);
		String value = newCell.getStringCellValue();
		if (value.equals(getTheData)) {
			newCell.setCellValue(setTheData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("updated");
	}

	// Drop down
	public static void dropDownbyIndex(WebElement webeleRef, int index) {
		s = new Select(webeleRef);
		s.selectByIndex(index);

	}

	public static void dropDownbyVisibleText(WebElement webeleRef, String text) {
		s = new Select(webeleRef);
		s.selectByVisibleText(text);

	}

	public static String getValue(WebElement webeleRef) {
		String ordernum = webeleRef.getAttribute("value");
		System.out.println(ordernum);
		return ordernum;
	}

	public static void getAttribute(WebElement webeleRef, String attrName) {
		String attrvalues = webeleRef.getAttribute(attrName);
		System.out.println(attrvalues);
	}

	public static void getText(WebElement webeleRef) {
		String text = webeleRef.getText();
		System.out.println(text);
	}

	public static void sleepTime(int ms) throws InterruptedException {
		Thread.sleep(ms);
	}

	public static void switchToFrame(WebElement webeleRef) {
		driver.switchTo().frame(webeleRef);
	}

	public static void javascriptToInsertValues(String sendvalue, WebElement webeleRef) {
		js = (JavascriptExecutor) driver;
		js.executeScript("\"argument[0].setAttribute('value','" + sendvalue + "')\"", webeleRef);

	}

	public static void mouseoverAction(WebElement webeleRef) {
		Actions actions = new Actions(driver);
		actions.moveToElement(webeleRef).perform();
	}

	public static void dragAndDrop(WebElement sourceWebele, WebElement destnWebele) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceWebele, destnWebele).perform();
	}

	public static void keyUpandDown(WebElement tarwebEle, String sendkey) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(tarwebEle, sendkey).keyUp(Keys.SHIFT).build().perform();
	}

	public static void doubleClick(WebElement webeleRef) {
		Actions actions = new Actions(driver);
		actions.doubleClick(webeleRef).perform();

	}

	public static void rightClick() {
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
	}

	public static void robotClass(int keyeventvk_key, int itrNum) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < itrNum; i++) {
			r.keyPress(keyeventvk_key);
			r.keyRelease(keyeventvk_key);
		}

	}

	public static void implicitywait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	
	
	
	
}
