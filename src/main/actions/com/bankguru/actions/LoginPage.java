package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.commonFunction;

public class LoginPage extends commonFunction {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "here")
	WebElement HERE_LINK;

	@FindBy(name = "uid")
	WebElement USERNAME_LOGIN_TXT;

	@FindBy(name = "password")
	WebElement PASSWORD_LOGIN_TXT;

	@FindBy(css = "input[value=LOGIN]")
	WebElement LOGIN_BTN;

	@FindBy(css = "input[value=RESET]")
	WebElement RESET_BTN;

//	public static final String HERE_LINK = "//a[contains(text(),'here')]";
//	public static final String USERNAME_LOGIN_TXT = "//input[@name='uid']";
//	public static final String PASSWORD_LOGIN_TXT = "//input[@name='password']";
//	public static final String LOGIN_BTN = "//input[@value='LOGIN']";
//	public static final String RESET_BTN = "//input[@value='RESET']";

	public RegisterPage clickHereLink() {
		waitVisible(HERE_LINK);
		click(HERE_LINK);
		return PageFactory.initElements(driver, RegisterPage.class);
	}

	public void iputUsename(String value) {
		waitVisible(USERNAME_LOGIN_TXT);
		input(USERNAME_LOGIN_TXT, value);

	}

	public void iputPassword(String value) {
		waitVisible(PASSWORD_LOGIN_TXT);
		input(PASSWORD_LOGIN_TXT, value);
	}

	public HomePage clickLogin() {
		waitVisible(LOGIN_BTN);
		click(LOGIN_BTN);
		return PageFactory.initElements(driver, HomePage.class);
	}
}