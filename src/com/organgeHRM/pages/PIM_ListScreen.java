package com.organgeHRM.pages;

import org.openqa.selenium.By;

import com.orgngeHRM.base.Predefined;

public class PIM_ListScreen  extends Predefined{

	public void clickOnPIM() {
		driver.findElement(By.xpath("//a/span[text()='PIM']")).click();
		 
	}
	public void clickOnPIM_EmployeeList() {
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		 
	}
	
}
