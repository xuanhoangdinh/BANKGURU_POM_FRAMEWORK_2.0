package com.bankguru.testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustormer;
import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;

public class NewCustomerScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustormer newCustormer;
	String email;
	JsonData data;

	static String emailLogin, passwordLogin;
	static String customerId;
//	String customerNamevalid, numberName, specialCharacterName, nameCannotEmptyMsg, dateOfBirthvalid,
//			cannotBeNumbericMsg, cannotSpecialCharacterMsg, firstCharacterBlankSpaceMsg, addressCannotEmptyMsg,
//			addressvalid, namemustBeNumbericMsg, mustBeNumbericMsg, cityvalid, cityCannotEmptyMsg, citynumber,
//			cityspecialCharacter, statevalid, stateCannotEmptyMsg, statenumber, statespecialCharacter, pinvalid,
//			pinnumbernotenough, pinMustHave6DigitsMsg, pinCannotEmptyMsg, pinspecialCharacter, pinCharacter,
//			mobileNumbervalid, mobileNumberCannotEmptyMsg, mobileBlankSpace, mobilespecialCharacter,
//			emailCannotEmptyMsg, emailnotcom, emailvarchar, emailbeforea, emailnotdoccom, emailBlankSpace,
//			passWordvalid, messegerRegisteredSuccessfully;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		inititalReport("NewCustomer.html");
		driver = openMultiBrowser(browser, version, url);
		data = getDataJson(".\\Data\\BankGuru.json");
		inititalReport("Newcustomer.html");

//// message chung
//		cannotSpecialCharacterMsg = "Special characters are not allowed";
//		firstCharacterBlankSpaceMsg = "First character can not have space";
//		mustBeNumbericMsg = "Characters are not allowed";
//// namecustomer
//		numberName = "1234";
//		specialCharacterName = "name!@#";
//		customerNamevalid = "hoangxuan";
//		nameCannotEmptyMsg = "Customer name must not be blank";
//		cannotBeNumbericMsg = "Numbers are not allowed";
//		namemustBeNumbericMsg = "Numbers are not allowed";
//
//// Adress
//		addressCannotEmptyMsg = "Address Field must not be blank";
//		addressvalid = "Tân Hiệp Hóc Môn";
//// date of birth
//		dateOfBirthvalid = "12/10/1994";
//// city
//		cityvalid = "Ho Chi Minh";
//		cityCannotEmptyMsg = "City Field must not be blank";
//		citynumber = "1234";
//		cityspecialCharacter = "city!@#";
////PIN
//		pinMustHave6DigitsMsg = "PIN Code must have 6 Digits";
//		pinvalid = "261094";
//		pinnumbernotenough = "1234";
//		pinCharacter = "1234PIN";
//		pinCannotEmptyMsg = "PIN Code must not be blank";
//		pinspecialCharacter = "@#";
//
////STATE		
//		statevalid = "Ho Chi Minh";
//		stateCannotEmptyMsg = "State must not be blank";
//		statenumber = "1234";
//		statespecialCharacter = "State!@#";
////MOBILE
//		mobileNumberCannotEmptyMsg = "Mobile no must not be blank";
//		mobileNumbervalid = "098686868";
//		mobileBlankSpace = "09 89";
//		mobilespecialCharacter = "0986!@#";
////EMAIL
//		emailCannotEmptyMsg = "Email-ID must not be blank";
//		emailnotdoccom = "guru99@gmail";
//		emailvarchar = "guru99";
//		emailbeforea = "Guru99@";
//		emailnotcom = "guru99@gmail.";
//		emailBlankSpace = "guru99gmail. com";
//
//		passWordvalid = "12345678";
//		messegerRegisteredSuccessfully = "Customer Registered Successfully!!!";

		email = "hoangxuan" + randomEmail() + "@gmail.com";
		// loginPage = new LoginPage(driver);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.iputUsename(RegisterScript.emailLogin);
		loginPage.iputPassword(RegisterScript.passwordLogin);
		homePage = loginPage.clickLogin();
		verifyEqual(homePage.getWelcomString(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@BeforeMethod
	public void beforeMethod() {
		newCustormer = homePage.clickMenuNewCustomer();
	}

	@Test
	public void TC_01_PresskeyTab() throws InterruptedException {
		logTestCase("PresskeyTab");
		newCustormer.pressKeyTabCustomerName(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getNameCannotEmptyMsg()),
				data.ExpectedMsgPage().getNameCannotEmptyMsg());
		Thread.sleep(3000);
	}

	@Test
	public void TC_02_inputNumberCustomerName() {
		logTestCase("inputNumberCustomerName");
		newCustormer.inputNumberCustomerName(data.NewCustomerPage().getNumberName());
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotBeNumbericMsg()),
				data.ExpectedMsgPage().getCannotBeNumbericMsg());

	}

	@Test
	public void TC_03_inputNumberSpecialCharacterName() {
		logTestCase("inputNumberSpecialCharacterName");
		newCustormer.inputNumberCustomerName(data.NewCustomerPage().getSpecialCharacterName());
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());

	}

	@Test
	public void TC_04_pressKeyTabCustomerName() {
		logTestCase("pressKeyTabCustomerName");
		newCustormer.pressKeyTabCustomerName(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());

	}

	@Test
	public void TC_05_pressKeyTabAddress() throws InterruptedException {
		logTestCase("pressKeyTabAddress");
		newCustormer.pressKeyTabAddress(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getAddressCannotEmptyMsg()),
				data.ExpectedMsgPage().getAddressCannotEmptyMsg());
	}

	@Test
	public void TC_06_pressKeySpaceAddress() throws InterruptedException {
		logTestCase("pressKeySpaceAddress");
		newCustormer.pressKeyTabAddress(Keys.SPACE);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
	}

//	1) Do not enter a value in CITY Field 2) Press TAB and move to next Field
	@Test
	public void TC_08_pressKeyTabCity() throws InterruptedException {
		logTestCase("pressKeySpaceAddress");
		newCustormer.pressKeyTabCity(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCityCannotEmptyMsg()),
				data.ExpectedMsgPage().getCityCannotEmptyMsg());
	}

//	9) Enter numeric value in CITY Field 1234 city123
	@Test
	public void TC_09_inputNumberCity() throws InterruptedException {
		logTestCase("inputNumberCity");
		newCustormer.inputNumberCity(data.NewCustomerPage().getCitynumber());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotBeNumbericMsg()),
				data.ExpectedMsgPage().getCannotBeNumbericMsg());
	}

//	10) Enter Special Character In CITY Field : City!@#
	@Test
	public void TC_10_inputspecialcharacterCity() throws InterruptedException {
		logTestCase("inputspecialcharacterCity");
		newCustormer.inputNumberCity(data.NewCustomerPage().getCityspecialCharacter());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());
	}

//	11) Enter First character Blank space
	@Test
	public void TC_11_pressKeySpaceCity() throws InterruptedException {
		logTestCase("pressKeySpaceCity");
		newCustormer.pressKeyTabCity(Keys.SPACE);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
	}

//12 Verify State Field State cannot be empt1) Do not enter a value in STATE Field 2) Press TAB and move to next Field.An error message "State must not be blank" must be shown

	@Test
	public void TC_12_pressKeyTabState() throws InterruptedException {
		logTestCase("pressKeyTabState");
		newCustormer.pressKeyState(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getStateCannotEmptyMsg()),
				data.ExpectedMsgPage().getStateCannotEmptyMsg());
	}

//13	 State cannot be numeric 1) Enter numeric value in STATE Field  1234 State123	An error message "Numbers are not allowed" must be shown
	@Test
	public void TC_13_inputNumberState() throws InterruptedException {
		logTestCase("inputNumberState");
		newCustormer.inputNumberState(data.NewCustomerPage().getStatenumber());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotBeNumbericMsg()),
				data.ExpectedMsgPage().getCannotBeNumbericMsg());
	}

//	14 State cannot have special character 1) Enter Special Character In STATE Field [State!@# !@#]//	An error message "Special characters are not allowed" must be shown
	@Test
	public void TC_14_inputSpecialCharacterState() throws InterruptedException {
		logTestCase("inputspecialcharacterState");
		newCustormer.inputNumberState(data.NewCustomerPage().getStatespecialCharacter());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());
	}

//	 15 State cannot have first blank space 1) Enter First character Blank space

	@Test
	public void TC_15_pressKeyState() throws InterruptedException {
		logTestCase("pressKeyState");
		newCustormer.pressKeyState(Keys.SPACE);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
	}

//16.1	 Verify PIN Field PIN must be numeric 1) Enter character value in PIN  Field//	1234 An error message "PIN Code must have 6 Digits " must be shown
	@Test
	public void TC_16_1_inputNumberPin() throws InterruptedException {
		logTestCase("inputNumberPinnotenough");
		newCustormer.inputNumberPin(data.NewCustomerPage().getPinnumbernotenough());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getPinMustHave6DigitsMsg()),
				data.ExpectedMsgPage().getPinMustHave6DigitsMsg());
	}

//	16.2  input 1234PIN An error message "Characters are not allowed" must be shown

	@Test
	public void TC_16_2_inputPinCharacter() throws InterruptedException {
		logTestCase("inputPinCharacter");
		newCustormer.inputNumberPin(data.NewCustomerPage().getPinCharacter());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getMustBeNumbericMsg()),
				data.ExpectedMsgPage().getMustBeNumbericMsg());
		Thread.sleep(3000);
	}

//	17 PIN cannot be empty//	1) Do not enter a value in PIN Field 2) Press TAB and move to next Field//	An error message "PIN code must not be blank" must be shown
	@Test
	public void TC_17_pressTabPin() throws InterruptedException {
		logTestCase("pressTabPin");
		newCustormer.pressKeyPin(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getPinCannotEmptyMsg()),
				data.ExpectedMsgPage().getPinCannotEmptyMsg());
		Thread.sleep(3000);
	}

//	19 PIN cannot have special character 1) Enter Special Character In PIN Field !@# 123!@# An error message "Special characters are not allowed" must be shown
	@Test
	public void TC_19_inputPinspecialCharacter() throws InterruptedException {
		logTestCase("inputPinspecialCharacter");
		newCustormer.inputNumberPin(data.NewCustomerPage().getPinspecialCharacter());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());
		Thread.sleep(3000);
	}

	// 20. PIN cannot have first blank space 1) Enter First character Blank space An
	// error message "First character cannot be space" must be shown
	@Test
	public void TC_20_pressTabPin() throws InterruptedException {

		logTestCase("pressTabPin");
		newCustormer.pressKeyPin(Keys.SPACE);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		Thread.sleep(3000);
	}

//	21 PIN cannot have blank space 1) Enter First character Blank space
//	An error message "PIN cannot have space" must be shown same 20
//22	 Verify Telephone Field Telephone cannot be empty 1) Do not enter a value in Telephone Field 2) Press TAB and move to next Field//	 An error message "Mobile no must not be blank" must be shown
	@Test
	public void TC_21_pressTabMobileNumber() throws InterruptedException {
		logTestCase("pressTabMobileNumber");
		newCustormer.pressKeyMobileNumber(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getMobileNumberCannotEmptyMsg()),
				data.ExpectedMsgPage().getMobileNumberCannotEmptyMsg());
		Thread.sleep(3000);
	}

//23	Telephone cannot have first character as blank space 1) Enter First character Blank space
//	An error message "First character cannot be space" must be shown
	@Test
	public void TC_22_pressSpaceMobileNumber() throws InterruptedException {
		logTestCase("pressSpaceMobileNumber");
		newCustormer.pressKeyMobileNumber(Keys.SPACE);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		Thread.sleep(3000);
	}

//	24 Telephone cannot have spaces 1) Enter Blank space in Telephone 123 123
//	An error message "Telephone cannot have be space" must be shown
	@Test
	public void TC_24_inputNumberMobileNumber() throws InterruptedException {
		logTestCase("inputNumberMobileNumber");
		newCustormer.inputNumberMobileNumber(data.NewCustomerPage().getMobileBlankSpace());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getMustBeNumbericMsg()),
				data.ExpectedMsgPage().getMustBeNumbericMsg());
		Thread.sleep(3000);
	}

//25	Telephone cannot have special character 1) Enter Special Character In Telephone Field
//	886636!@12 !@88662682 88663682!@
//	An error message "Special characters are not allowed" must be shown
	@Test
	public void TC_25_inputspecialCharacterMobileNumber() throws InterruptedException {
		logTestCase("inputspecialCharacterMobileNumber");
		newCustormer.inputNumberMobileNumber(data.NewCustomerPage().getMobilespecialCharacter());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());
		Thread.sleep(3000);
	}

//26	Verify Email Field Email cannot be empty
//	1) Do not enter a value in Email Field 2) Press TAB and move to next Field
//	An error message "Email ID must not be blank" must be shown
	@Test
	public void TC_26_pressTabEmail() throws InterruptedException {
		logTestCase("pressTabEmail");
		newCustormer.pressKeyEmail(Keys.TAB);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		Thread.sleep(3000);
	}

//	27 Email must be in correct format Enter invalid email in Email field
//	 guru99@gmail guru99 Guru99@ guru99@gmail. guru99gmail. com
//	 An error message "Email-ID is not valid"" must be shown
	@Test
	public void TC_27_1_inputEmailnotdoccom() throws InterruptedException {
		logTestCase("inputEmailnotdoccom");
		newCustormer.inputNumberEmail(data.NewCustomerPage().getEmailnotdoccom());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		Thread.sleep(3000);
	}

	// @Test
	public void TC_27_2_inputEmailvarchar() throws InterruptedException {
		logTestCase("inputEmailvarchar");
		newCustormer.inputNumberEmail(data.NewCustomerPage().getEmailvarchar());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		Thread.sleep(3000);
	}

	// @Test
	public void TC_27_3_inputEmailbeforea() throws InterruptedException {
		logTestCase("inputEmailbeforea");

		newCustormer.inputNumberEmail(data.NewCustomerPage().getEmailbeforea());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		Thread.sleep(3000);
	}

	// @Test
	public void TC_27_4_inputEmailnotcom() throws InterruptedException {
		logTestCase("inputEmailnotcom");
		newCustormer.inputNumberEmail(data.NewCustomerPage().getEmailnotcom());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		Thread.sleep(3000);
	}

	// @Test
	public void TC_27_5_inputEmailBlankSpace() throws InterruptedException {
		logTestCase("inputEmailBlankSpace");
		newCustormer.inputNumberEmail(data.NewCustomerPage().getEmailBlankSpace());
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		Thread.sleep(3000);
	}

//	29 Email cannot have space 1) Enter Blank space in Email //	An error message "Email-ID is not valid" must be shown
	@Test
	public void TC_29_pressTabEmail() throws InterruptedException {
		logTestCase("pressTabEmail");
		newCustormer.pressKeyEmail(Keys.SPACE);
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		Thread.sleep(3000);
	}

//	30.Verify Field LabelsCheck all Fields name(Label) are as documented in SRS for all modules Cross check Field names with that in SRS Field names in SRS and system should match
	@Test
	public void TC_30_inputnewCustomervalid() throws InterruptedException {
		logTestCase("inputnewCustomervalid");
		newCustormer.inputNumberCustomerName(data.NewCustomerPage().getCustomerNamevalid());
		newCustormer.inputDateOfBirth(data.NewCustomerPage().getDateOfBirthvalid());
		newCustormer.inputAddress(data.NewCustomerPage().getAddressvalid());
		newCustormer.inputNumberCity(data.NewCustomerPage().getCityvalid());
		newCustormer.inputNumberState(data.NewCustomerPage().getStatevalid());
		newCustormer.inputNumberPin(data.NewCustomerPage().getPinvalid());
		newCustormer.inputNumberMobileNumber(data.NewCustomerPage().getMobileNumbervalid());
		newCustormer.inputNumberEmail(email);
		newCustormer.inputPassWord(data.NewCustomerPage().getPassWordvalid());
		newCustormer.clickSummit();
		Thread.sleep(3000);
		verifyEqual(newCustormer.getDynamicText(data.NewCustomerPage().getMessegerRegisteredSuccessfully()),
				data.ExpectedMsgPage().getMessegerRegisteredSuccessfully());
		customerId = newCustormer.getTexCustomerId();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass
	public void afterClass() {
		exportReport();
		closeBrowser();
	}
}
