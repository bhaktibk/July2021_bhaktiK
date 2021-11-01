package com.organgeHRM.pages;

import org.openqa.selenium.By;

import com.orgngeHRM.base.Predefined;

public class Menu_page extends   Predefined {
	
	public void navigateTo(String menu) throws InterruptedException {
		String[] name= menu.split("->");
		for (String item: name) {
			driver.findElement(By.xpath("//span[text()='"+name+"']")).click();
			Thread.sleep(3000);
		}
			
	}

}
