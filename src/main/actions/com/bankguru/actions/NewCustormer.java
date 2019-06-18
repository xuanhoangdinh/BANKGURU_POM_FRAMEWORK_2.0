package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.commonFunction;

public class NewCustormer extends commonFunction {

	public NewCustormer(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "name")
	WebElement CUSTOMER_NAME_TXT;

	@FindBy(id = "dob")
	WebElement DOB_DATEPICKER;

	@FindBy(name = "addr")
	WebElement ADDRESS_TXT;

	@FindBy(name = "city")
	WebElement CITY_TXT;

	@FindBy(name = "state")
	WebElement STATE_TXT;

	@FindBy(name = "pinno")
	WebElement PIN_TXT;

	@FindBy(name = "telephoneno")
	WebElement MOBLIE_NUMBER_TXT;

	@FindBy(name = "emailid")
	WebElement EMAIL_TXT;

	@FindBy(name = "password")
	WebElement PASSWORD_TXT;

	@FindBy(css = "input[@value=Submit]")
	WebElement SUMMIT_BTN;

	@FindBy(className = "heading3")
	WebElement CUSTOMER_REGISTED_SUCCESSFUL;

	@FindBy(xpath = "//td[contains(text(),'Customer ID')]/following-sibling::td")
	WebElement CUSTOMER_ID;

//	public static final String CUSTOMER_NAME_TXT = "//input[@name='name']";
//	public static final String DOB_DATEPICKER = "//input[@id='dob']";
//	public static final String ADDRESS_TXT = "//textarea[@name='addr']";
//	public static final String CITY_TXT = "//input[@name='city']";
//	public static final String STATE_TXT = "//input[@name='state']";
//	public static final String PIN_TXT = "//input[@name='pinno']";
//	public static final String MOBLIE_NUMBER_TXT = "//input[@name='telephoneno']";
//	public static final String EMAIL_TXT = "//input[@name='emailid']";
//	public static final String PASSWORD_TXT = "//input[@name='password']";
//	public static final String SUMMIT_BTN = "//input[@value='Submit']";
//	public static final String CUSTOMER_REGISTED_SUCCESSFUL = "//p[@class='heading3']";
//	public static final String CUSTOMER_ID = "//td[contains(text(),'Customer ID')]/following-sibling::td";
//
//	public static final String DYNAMIC_MSG = "//*[contains(text(),'%s')]";
//	public static final String DYNAMIC_TXT = "//*[contains(text(),'%s')]";

	public void pressKeyTabCustomerName(Keys key) {
		waitVisible(CUSTOMER_NAME_TXT);
		inputKeys(CUSTOMER_NAME_TXT, key);
	}

	public void inputNumberCustomerName(String value) {
		waitVisible(CUSTOMER_NAME_TXT);
		input(CUSTOMER_NAME_TXT, value);
	}

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(value);
		return getTextDynamicElement(value);
	}

	public void pressKeyTabAddress(Keys key) {
		waitVisible(ADDRESS_TXT);
		inputKeys(ADDRESS_TXT, key);
	}

	public void pressKeySpaceAddress(Keys key) {
		waitVisible(ADDRESS_TXT);
		inputKeys(ADDRESS_TXT, key);
	}

	public void inputAddress(String value) {
		waitVisible(ADDRESS_TXT);
		input(ADDRESS_TXT, value);
	}

	public void pressKeyTabCity(Keys key) {
		waitVisible(CITY_TXT);
		inputKeys(CITY_TXT, key);
	}

	public void inputNumberCity(String value) {
		waitVisible(CITY_TXT);
		input(CITY_TXT, value);
	}

	public void pressKeyState(Keys key) {
		waitVisible(STATE_TXT);
		inputKeys(STATE_TXT, key);
	}

	public void inputNumberState(String value) {
		waitVisible(STATE_TXT);
		input(STATE_TXT, value);
	}

	public void pressKeyPin(Keys key) {
		waitVisible(PIN_TXT);
		inputKeys(PIN_TXT, key);
	}

//	public String getTexPin() {
//		waitVisible(PIN_MSG);
//		return getText(PIN_MSG);
//	}

	public void inputNumberPin(String value) {
		waitVisible(PIN_TXT);
		input(PIN_TXT, value);
	}

	public void pressKeyMobileNumber(Keys key) {
		waitVisible(MOBLIE_NUMBER_TXT);
		inputKeys(MOBLIE_NUMBER_TXT, key);
	}

	public void inputNumberMobileNumber(String value) {
		waitVisible(MOBLIE_NUMBER_TXT);
		input(MOBLIE_NUMBER_TXT, value);
	}

	public void pressKeyEmail(Keys key) {
		waitVisible(EMAIL_TXT);
		inputKeys(EMAIL_TXT, key);
	}

	public void inputNumberEmail(String value) {
		waitVisible(EMAIL_TXT);
		input(EMAIL_TXT, value);
	}

	public void inputDateOfBirth(String value) {
		waitVisible(DOB_DATEPICKER);
		input(DOB_DATEPICKER, value);
	}

	public void inputPassWord(String value) {
		waitVisible(PASSWORD_TXT);
		input(PASSWORD_TXT, value);
	}

	public NewCustormer clickSummit() {
		waitVisible(SUMMIT_BTN);
		click(SUMMIT_BTN);
		return PageFactory.initElements(driver, NewCustormer.class);
	}

	public String getTexCustomerRegisteredSuccessfully() {
		waitVisible(CUSTOMER_REGISTED_SUCCESSFUL);
		return getText(CUSTOMER_REGISTED_SUCCESSFUL);
	}

	public String getTexCustomerId() {
		waitVisible(CUSTOMER_ID);
		return getText(CUSTOMER_ID);
	}

}