package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonPage.commonFunction;

public class HomePage extends commonFunction {

	public HomePage(WebDriver driver) {
		super(driver);
	}

//	public static final String NEWCUSTOMER_LINK = "//a[contains(text(),'New Customer')]";
//	public static final String WELCOME_LBL = "//marquee[@class='heading3']";
//	public static final String EDITCUSTOMER_LINK = "//a[contains(text(),'Edit Customer')]";

	@FindBy(linkText = "New Customer")
	WebElement NEWCUSTOMER_LINK;

	@FindBy(className = "heading3")
	WebElement WELCOME_LBL;
	
	@FindBy(linkText = "Edit Customer")
	WebElement EDITCUSTOMER_LINK;

	public String getWelcomString() {
		waitVisible(WELCOME_LBL);
		return getText(WELCOME_LBL);

	}

	public NewCustormer clickMenuNewCustomer() {
		waitVisible(NEWCUSTOMER_LINK);
		click(NEWCUSTOMER_LINK);
		return PageFactory.initElements(driver, NewCustormer.class);

	}

	public EditCustomer clickMenuEditCustomer() {
		waitVisible(EDITCUSTOMER_LINK);
		click(EDITCUSTOMER_LINK);
		return PageFactory.initElements(driver, EditCustomer.class);

	}
}