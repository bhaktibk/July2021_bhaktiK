package com.orgngeHRM.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Predefined {
	protected  static WebDriver driver;
	
	static public void start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Step- Open URL ");
		driver.get(url);
		
		
	}
	static protected void clickOnButton(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		button.click();
	}
	
	static public void windowsQuit() {
		driver.quit();
	}

}
