/*Assignment - 14 : 30th Oct'2021
1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Login with username and password 
3. Verify ""Dashboard"" as Title(Tab Level) Display Dashboard page
4. Go to PIM--> Add employee button
5. Add all details in form and add employee
6. Go to PIM--> Employee list
7. Verify recently added employee should be displayed on Employee list

Please create new repo, add testcases which we covered in session apart from above one.
Repo naming convention : July21_Margi_HybridDriven*/

package com.orangeHRM.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.organgeHRM.pages.LoginPage;
import com.orgngeHRM.base.Predefined;

public class LoginTest {
	
		
	@BeforeClass
	void start() throws InterruptedException {
		 
		Predefined.start("https://practice2022-trials72.orangehrmlive.com/");
		
		
	}
	@AfterClass
	void end() {
		Predefined.windowsQuit();
		 	
	}
	@Test (priority=1)
	void verifyLogin() {
		System.out.println("Step- Enter Un, PW and Click on login button ");
		LoginPage loginPage= new LoginPage();
		loginPage.doLogin("Admin", "eAyHcOM8@0");
		String actual = loginPage.getDashboardText();
		System.out.println("Step - verify user gets logged in successfully");
		String expected= "Dashboard";
		Assert.assertEquals(actual, expected); 
		System.out.println("Step- loginEnd");
	}
	
	 
	

}
