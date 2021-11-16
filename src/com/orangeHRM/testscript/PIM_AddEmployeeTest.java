package com.orangeHRM.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.oragangeHRM.utility.ExcelData;
import com.organgeHRM.pages.LoginPage;
import com.organgeHRM.pages.Menu_page;
import com.organgeHRM.pages.PIM_AddEmployeePage;
import com.orgngeHRM.base.Predefined;

import net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable.Symbolic;

public class PIM_AddEmployeeTest {
	PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
	Menu_page menu_page = new Menu_page();

	@BeforeMethod
	void start() {
		Predefined.start("https://practice2022-trials72.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage();
		loginPage.doLogin("Admin", "eAyHcOM8@0");

	}

	@AfterMethod
	void end() {
		Predefined.windowsQuit();
	}

	@DataProvider(name = "empData")
	//Object[][] 
	void getDataFromXls() throws Throwable {
		System.out.println("Data provided method gets called successfully ");
		//return 
		ExcelData.getTableData();
	}

	@Test(dataProvider = "empData")
	void addEmplpyeeFromDataTable(String fname, String lName, String location, String hobbies, String shift,
			String region, String fet, String Dept) {
		System.out.println("Passing data from xls ");
		menu_page.navigateTo("PIM->Add Employee");
		System.out.println("Step- First name, Last Name, location ");

		pim_AddEmployeePage.setFn(fname).setLn(lName).setLocation(location).clickOnNextButon()
				.setHobbites(hobbies).clickOnNextButon().setWorkShift(shift).setRegion(region).setFET(fet)
				.setTemporaryDep(Dept).saveButtonClick_1();

		System.out.println("Step - Employee Get added Successfully");
		System.out.println("Strp- go to Employee list screen");
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = true;
		Boolean actual = pim_AddEmployeePage.isTextVisisble();
		softAssert.assertEquals(actual, flag);
		softAssert.assertAll();
	}

	@Test
	void verifyUserClicksAddEmployee() throws InterruptedException, Exception {
		System.out.println("Step- Click on PIM");
		System.out.println("Step- Click on Add employee");
		// PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		Menu_page menu_page = new Menu_page();
		menu_page.navigateTo("PIM->Add Employee");
		// pim_AddEmployeePage.clickOnPIM();

		// pim_AddEmployeePage.clickOnPIM_AddRecipient();

		System.out.println("Step- to verify user land on add employee Page");
		String expected = "Add Employee";
		String actuText = pim_AddEmployeePage.getAddRecipientText();
		Assert.assertEquals(actuText, expected);
		System.out.println("User land on Add employee");
		System.out.println("Step- enter Add employee details");
		String name = "bb";

		System.out.println("Step- First name, Last Name, location ");
		pim_AddEmployeePage.setFn(name).setLn("bhakti").setLocation("Australian Regional HQ").clickOnNextButon()
				.setHobbites("Reading").clickOnNextButon().setWorkShift("General").setRegion("Region-1").setFET("0.75")
				.setTemporaryDep("Sub unit-1").saveButtonClick_1();

		System.out.println("Step - Employee Get added Successfully");
		System.out.println("Strp- go to Employee list screen");
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = true;
		Boolean actual = pim_AddEmployeePage.isTextVisisble();
		softAssert.assertEquals(actual, flag);
		softAssert.assertAll();

	}

}
