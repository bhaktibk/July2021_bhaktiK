package com.organgeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orgngeHRM.base.Predefined;

public class PIM_AddEmployeePage extends Predefined {

	public void clickOnPIM() {
		driver.findElement(By.xpath("//a/span[text()='PIM']")).click();
		 
	}
	public void clickOnPIM_EmployeeList() {
		driver.findElement(By.xpath("//a/span[text()='Employee List']")).click();
		 
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
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage setHobbites(String hobby) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//label[text()='Hobbies']/preceding-sibling::input")).sendKeys(hobby);
		return this;
	}
	 //General
	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		try {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		}catch(StaleElementReferenceException staleException) {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		}
		/*driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		driver.findElement(By.xpath("//span[text()='"+shift+"']")).click();
		return this;*/
		WebDriverWait wait = new WebDriverWait(driver, 30); // 500 ms
		//wait.until(ExpectedConditions.visibilityOf(e));
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']")));
		e.click();
		return this;
	}
	public PIM_AddEmployeePage setRegion(String region) {
		/*driver.findElement(By.xpath("//label[text()='Region']/preceding-sibling::div/span[@class='caret']")).click();
		//driver.findElement(By.xpath("//li//span[text()='"+region+"']")).sendKeys(region);
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("By.xpath(\"//li//span[text()='\"+region+\"']\")")));
		e.click();
		return this;*/
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement regionDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		// scrolling
		regionDropDown.click();
		
		WebElement regionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+region+"']")));
		regionElement.click();
		return this;
	}
	//0.75
	public PIM_AddEmployeePage setFET(String fet) {
		driver.findElement(By.xpath("//label[text()='FTE']//parent::div")).click();
		driver.findElement(By.xpath("//span[text()='"+fet+"']")).click();
		
		return this;
	}
	//Sub unit-1
	public PIM_AddEmployeePage setTemporaryDep(String dep) {
		//driver.findElement(By.xpath("//label[text()='Temporary Department']//preceding-sibling::div/span[@class='caret']")).click();
		//driver.findElement(By.xpath("//li/span[text()='"+dep+"']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement deptDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Temporary Department']//preceding-sibling::div")));
		// scrolling
		deptDropDown.click();
		
		WebElement regionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/span[text()='"+dep+"']")));
		regionElement.click();
		return this;
	}
	
	public PIM_AddEmployeePage saveButtonClick_1() {
		//driver.findElement(By.xpath("//form[@name='customFieldsForm_0']//button[text()='save']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return this;
	}
	public PIM_AddEmployeePage saveButtonClick_2() {
		driver.findElement(By.xpath("//form[@name='customFieldsForm_1']//button[text()='save']")).click();
		return this;
	}
	
	public boolean isTextVisisble() {
		return driver.findElement(By.xpath("//*[text()='Successfully Saved']")).isDisplayed();

	
	}
	
	
	
}
