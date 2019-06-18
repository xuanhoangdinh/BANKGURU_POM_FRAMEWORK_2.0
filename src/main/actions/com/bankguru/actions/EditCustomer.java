package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class EditCustomer extends commonFunction {

	public EditCustomer(WebDriver driver) {
		super(driver);
	}

//	public static final String CUSTOMER_ID_TXT = "//input[@name='cusid']";
//	public static final String CUSTOMER_ID_MSG = "//label[@id='message14']";
//	public static final String SUMMIT_BTN = "//input[@value='Submit']";
//	//lấy bên newcustomer
//	public static final String ADDRESS_TXT = "//textarea[@name='addr']";
//	public static final String ADDRESS_MSG = "//label[@id='message3']";
//	public static final String CITY_TXT = "//input[@name='city']";
//	public static final String CITY_MSG = "//label[@id='message4']";
//	public static final String STATE_TXT = "//input[@name='state']";
//	public static final String STATE_MSG = "//label[@id='message5']";
//	public static final String PIN_TXT = "//input[@name='pinno']";
//	public static final String PIN_MSG = "//label[@id='message6']";
//	public static final String MOBLIE_NUMBER_TXT = "//input[@name='telephoneno']";
//	public static final String MOBLIE_NUMBER_MSG = "//label[@id='message7']";
//	public static final String EMAIL_TXT = "//input[@name='emailid']";
//	public static final String EMAIL_MSG = "//label[@id='message9']";
//	public static final String PASSWORD_TXT = "//input[@name='password']";
//	public static final String PASSWORD_MSG = "//label[@id='message18']";
//	public static final String CUSTOMER_REGISTED_SUCCESSFUL = "//p[@class='heading3']";
//	public static final String CUSTOMER_ID = "//td[contains(text(),'Customer ID')]/following-sibling::td";
	@FindBy(name = "cusid")
	WebElement CUSTOMER_ID_TXT;

	@FindBy(id = "message14")
	WebElement CUSTOMER_ID_MSG;

	@FindBy(css = "input[value=Submit]")
	WebElement SUMMIT_BTN;

	@FindBy(name = "addr")
	WebElement ADDRESS_TXT;

	@FindBy(id = "message3")
	WebElement ADDRESS_MSG;

	@FindBy(name = "city")
	WebElement CITY_TXT;

	@FindBy(id = "message4")
	WebElement CITY_MSG;

	@FindBy(name = "state")
	WebElement STATE_TXT;

	@FindBy(id = "message5")
	WebElement STATE_MSG;

	@FindBy(name = "pinno")
	WebElement PIN_TXT;

	@FindBy(id = "message6")
	WebElement PIN_MSG;

	@FindBy(name = "telephoneno")
	WebElement MOBLIE_NUMBER_TXT;

	@FindBy(id = "message7")
	WebElement MOBLIE_NUMBER_MSG;

	@FindBy(name = "emailid")
	WebElement EMAIL_TXT;

	@FindBy(id = "message9")
	WebElement EMAIL_MSG;

	@FindBy(name = "password")
	WebElement PASSWORD_TXT;

	@FindBy(id = "message18")
	WebElement PASSWORD_MSG;

	@FindBy(name = "heading3")
	WebElement CUSTOMER_REGISTED_SUCCESSFUL;

	@FindBy(xpath = "//td[contains(text(),'Customer ID')]/following-sibling::td")
	WebElement CUSTOMER_ID;

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(NewCustomerUI.DYNAMIC_MSG, value);
		return getTextDynamicElement(NewCustomerUI.DYNAMIC_MSG, value);
	}

	public void pressKeyTabCustomerId(Keys key) {
		waitVisible(CUSTOMER_ID_TXT);
		inputKeys(CUSTOMER_ID_TXT, key);
	}

	public void inputCustomerId(String value) {
		waitVisible(CUSTOMER_ID_TXT);
		input(CUSTOMER_ID_TXT, value);
	}

	public String getTexCustomerId() {
		waitVisible(CUSTOMER_ID_MSG);
		return getText(CUSTOMER_ID_MSG);
	}

	public EditCustomer clickSummit() {
		waitVisible(SUMMIT_BTN);
		click(SUMMIT_BTN);
		return PageFactory.initElements(driver, EditCustomer.class);
	}

// lay Adress
	public void clearAddress() {
		waitVisible(ADDRESS_TXT);
		clear(ADDRESS_TXT);
	}

	public void pressKeyTabAddress(Keys key) {
		waitVisible(ADDRESS_TXT);
		inputKeys(ADDRESS_TXT, key);
	}

	public String getTexAddress() {
		waitVisible(ADDRESS_MSG);
		return getText(ADDRESS_MSG);
	}

	public void inputAddress(String value) {
		waitVisible(ADDRESS_TXT);
		input(ADDRESS_TXT, value);
	}

	/////////////////////////////////////////////////
// City
	public void pressKeyTabCity(Keys key) {
		waitVisible(CITY_TXT);
		inputKeys(CITY_TXT, key);
	}

	public String getTexCity() {
		waitVisible(CITY_MSG);
		return getText(CITY_MSG);
	}

	public void inputNumberCity(String value) {
		waitVisible(CITY_TXT);
		input(CITY_TXT, value);
	}

	public void clearCity() {
		waitVisible(CITY_TXT);
		clear(CITY_TXT);
	}

	// State
	public void pressKeyState(Keys key) {
		waitVisible(STATE_TXT);
		inputKeys(STATE_TXT, key);
	}

	public String getTexState() {
		waitVisible(STATE_MSG);
		return getText(STATE_MSG);
	}

	public void inputState(String value) {
		waitVisible(STATE_TXT);
		input(STATE_TXT, value);
	}

	public void clearState() {
		waitVisible(STATE_TXT);
		clear(STATE_TXT);
	}

	// Pin
	public void pressKeyPin(Keys key) {
		waitVisible(PIN_TXT);
		inputKeys(PIN_TXT, key);
	}

	public String getTexPin() {
		waitVisible(PIN_MSG);
		return getText(PIN_MSG);
	}

	public void inputNumberPin(String value) {
		waitVisible(PIN_TXT);
		input(PIN_TXT, value);
	}

	public void clearPin() {
		waitVisible(PIN_TXT);
		clear(PIN_TXT);
	}

	// Mobile
	public void pressKeyMobileNumber(Keys key) {
		waitVisible(MOBLIE_NUMBER_TXT);
		inputKeys(MOBLIE_NUMBER_TXT, key);
	}

	public String getTexMobileNumber() {
		waitVisible(MOBLIE_NUMBER_MSG);
		return getText(MOBLIE_NUMBER_MSG);
	}

	public void inputNumberMobileNumber(String value) {
		waitVisible(MOBLIE_NUMBER_TXT);
		input(MOBLIE_NUMBER_TXT, value);
	}

	public void clearMobileNumber() {
		waitVisible(MOBLIE_NUMBER_TXT);
		clear(MOBLIE_NUMBER_TXT);
	}

	// EMAIL
	public void pressKeyEmail(Keys key) {
		waitVisible(EMAIL_TXT);
		inputKeys(EMAIL_TXT, key);
	}

	public String getTexEmail() {
		waitVisible(EMAIL_MSG);
		return getText(EMAIL_MSG);
	}

	public void inputEmail(String value) {
		waitVisible(EMAIL_TXT);
		input(EMAIL_TXT, value);
	}

	public void clearEmail() {
		waitVisible(EMAIL_TXT);
		clear(EMAIL_TXT);
	}

//PASSWORD
	public void inputPassWord(String value) {
		waitVisible(PASSWORD_TXT);
		input(PASSWORD_TXT, value);
	}

}