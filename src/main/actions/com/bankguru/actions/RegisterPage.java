package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.commonFunction;

public class RegisterPage extends commonFunction {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "emailid")
	WebElement EMAIL_REGISTER_TXT;

	@FindBy(css = "input[value=Submit]")
	WebElement SUBMIT_BTN;

	@FindBy(xpath = "//td[contains(text(),'User ID :')]//following-sibling::td")
	WebElement USERNAME_LBL;

	@FindBy(xpath = "//td[contains(text(),'Password :')]//following-sibling::td")
	WebElement PASSWORD_LBL;

//	public static final String EMAIL_REGISTER_TXT = "//input[@name='emailid']";
//	public static final String SUBMIT_BTN = "//input[@value='Submit']";
//	public static final String USERNAME_LBL = "//td[contains(text(),'User ID :')]//following-sibling::td";
//	public static final String PASSWORD_LBL = "//td[contains(text(),'Password :')]//following-sibling::td";
	public void inputEmailRegister(String value) {
		waitVisible(EMAIL_REGISTER_TXT);
		input(EMAIL_REGISTER_TXT, value);
	}

	public void clickSumit() {
		waitVisible(SUBMIT_BTN);
		click(SUBMIT_BTN);
	}

	public String getUsername() {
		waitVisible(USERNAME_LBL);
		return getText(USERNAME_LBL);
	}

	public String getPasswork() {
		waitVisible(PASSWORD_LBL);
		return getText(PASSWORD_LBL);
	}

	public LoginPage navigateToLoginPage(String value) {
		openUrl(value);
		return PageFactory.initElements(driver, LoginPage.class);
	}

}
