package com.organgeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
 

import com.orgngeHRM.base.Predefined;

public class PIM_AddEmployeePage extends Predefined {

	public void clickOnPIM() {
		driver.findElement(By.xpath("//a/span[text()='PIM']")).click();
		 
	}
	
	public void clickOnPIM_AddRecipient() {
		driver.findElement(By.xpath("//li/a/span[@combinedmenutitle='PIM > Add Employee']")).click();
	}
	
	
	public String getAddRecipientText() {
		return driver.findElement(By.xpath("//span/h5[@class='modal-title']")).getText();
	}
	
	public   PIM_AddEmployeePage setFn(String fn) {
	 
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fn);
		return this;
	}
	
	public   PIM_AddEmployeePage setLn(String ln) {
		 
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(ln);
		return this;
	}
	//Canadian Development Center
	public   PIM_AddEmployeePage setLocation(String location) {
		 
		driver.findElement(By.xpath("//button[@class='btn dropdown-toggle']")).click(); 
		driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a")).click();
		return this;
	}
	
	public   PIM_AddEmployeePage clickOnNextButon() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage setHobbites(String hobby) {
		driver.findElement(By.xpath("//label[text()='Hobbies']/preceding-sibling::input")).sendKeys(hobby);
		return this;
	}
	 //General
	public PIM_AddEmployeePage setWorkShift(String shift) {
		driver.findElement(By.xpath("//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//span[text()='"+shift+"']")).click();
		return this;
	}
	public PIM_AddEmployeePage setRegion(String region) {
		driver.findElement(By.xpath("//label[text()='Region']/preceding-sibling::div/span[@class='caret']")).click();
		driver.findElement(By.xpath("//li//span[text()='"+region+"']")).sendKeys(region);
		return this;
	}
	
}
