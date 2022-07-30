package org.pojoclassses;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AllLocatorsPOJO extends BaseClass {
	public AllLocatorsPOJO() {
PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement demoFstname;
	@CacheLookup

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement demoLastname;
	@CacheLookup

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement demoUserName;
	@CacheLookup

	@FindBy(xpath = "//input[@id='password']")
	private WebElement demoPassword;
	@CacheLookup

	@FindBy(id = "email")

	private WebElement fbEmail;
	@CacheLookup

	@FindBy(id = "pass")
	private WebElement fbPass;
	@CacheLookup

	@FindAll({@FindBy(xpath = "(//input[@type='text'])[2]"),
		@FindBy(xpath="//span[text()='Enter Email/Mobile number']")})
	private WebElement flipEmail;
	@CacheLookup

	@FindAll({@FindBy(xpath = "//input[@type='password']"),
		@FindBy(xpath ="//span[text()='Enter Password'] ")
	})
	private WebElement flipPasswd;
	@CacheLookup

	@FindBy(xpath = "//div[@id='signin-block']")
	private WebElement redbusSigninbtn;
	@FindBy(xpath = "//li[@id='signInLink']")
	private WebElement redbusSignupbtn;
	@FindBys({ @FindBy(xpath = "//input[@id='mobileNoInp']"),
			@FindBy(xpath = "//input[@placeholder='Enter your mobile number']"),
			@FindBy(xpath = "//input[@type= 'number']") })
	private WebElement redbusMobileno;

	@FindBy(xpath = "//iframe[@class='modalIframe']")
	private WebElement frameLocator;

	public WebElement getFrameLocator() {
		return frameLocator;
	}

	public WebElement getRedbusSigninbtn() {
		return redbusSigninbtn;
	}

	public WebElement getRedbusSignupbtn() {
		return redbusSignupbtn;
	}

	public WebElement getRedbusMobileno() {
		return redbusMobileno;
	}

	public WebElement getFbEmail() {
		return fbEmail;
	}

	public WebElement getFbPass() {
		return fbPass;
	}

	public WebElement getFlipEmail() {
		return flipEmail;
	}

	public WebElement getFlipPasswd() {
		return flipPasswd;
	}

	public WebElement getDemoFstname() {
		return demoFstname;
	}

	public WebElement getDemoLastname() {
		return demoLastname;
	}

	public WebElement getDemoUserName() {
		return demoUserName;
	}

	public WebElement getDemoPassword() {
		return demoPassword;
	}

}
