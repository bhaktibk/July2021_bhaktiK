package com.orangeHRM.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.organgeHRM.pages.LoginPage;
import com.organgeHRM.pages.Menu_page;
import com.organgeHRM.pages.PIM_AddEmployeePage;
import com.orgngeHRM.base.Predefined;

import net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable.Symbolic;

public class PIM_AddEmployeeTest {
	@BeforeClass
	void start()  {
		Predefined.start("https://practice2022-trials72.orangehrmlive.com/");
		LoginPage loginPage= new LoginPage();
		loginPage.doLogin("Admin", "eAyHcOM8@0");
		
	}
	//@AfterClass
	void end() {
		Predefined.windowsQuit();
		 	
	}
	/*@Test //  need to revisit  
	void toAddEmployee() throws InterruptedException {
		Menu_page menu_page= new Menu_page();
		menu_page.navigateTo("PIM->Add Employee");
	}*/
	@Test
	void verifyUserClicksAddEmployee() throws InterruptedException {
		System.out.println("Step- Click on PIM");
		PIM_AddEmployeePage pim_AddEmployeePage= new PIM_AddEmployeePage();
		pim_AddEmployeePage.clickOnPIM();
		
		System.out.println("Step- Click on Add employee");
		pim_AddEmployeePage.clickOnPIM_AddRecipient();
		 
		System.out.println("Step- to verify user land on add employee Page");
		String expected= "Add Employee";
		String actuText= pim_AddEmployeePage.getAddRecipientText();
		Assert.assertEquals(actuText, expected);
		System.out.println("User land on Add employee");
		System.out.println("Step- enter Add employee details");
	
		System.out.println("Step- First name, Last Name, location ");
		pim_AddEmployeePage
		.setFn("Abhi")
		.setLn("bhakti")
		.setLocation("Australian Regional HQ")
		 .clickOnNextButon()
		 .setHobbites("Reading")
		 .clickOnNextButon()
		 .setWorkShift("General")
		 .setRegion("Region-1");
		 
		 
		
		 
		
		
	}
	

}
