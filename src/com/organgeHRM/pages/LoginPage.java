package com.organgeHRM.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.orgngeHRM.base.Predefined;

public class LoginPage extends Predefined {
	
	public void doLogin(String un, String pw) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pw);
		clickOnLoginButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public String getDashboardText() {
		return driver.findElement(By.xpath("//ul/li[@class='page-title']")).getText();
	}
	public void clickOnLoginButton() {
		clickOnButton("//input[@value='LOGIN']");
	}
	
	
	
}
