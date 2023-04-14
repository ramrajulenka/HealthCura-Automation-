package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import utility.Base;
import utility.ExcelUtility;

public class LogInTestCases extends Base{
	@DataProvider
	Object readData() throws IOException
	{
		String location="D:\\JAVA Notes\\java Programs\\HealthCureProject\\Resources\\LogInData.xlsx";
		ExcelUtility xlData=new ExcelUtility(location);
	int rows=xlData.getRowCount("LogData");
	int cols=xlData.getCellCount("LogData", rows);	
	
	Object [][] data=new Object[rows][cols]; 
	
	for (int i = 1; i <=rows; i++) {
		for (int j = 0; j <cols; j++) {
			data[i-1][j]=xlData.getCellData("LogData", i, j);
		}
	}	
		return  data;	
	}
	
	@Test(description = "verifying valid userName and Password")
	void verifyWithValidUser() {
		driver.get(url);
		logger.info("land On Login Page");
		HomePage login  = new HomePage(driver);
		login.setUserName(global_userName);
		logger.info("Enter the Username as "+global_userName);
		login.setPassword(global_password);
		logger.info("Enter the Password as "+global_password);
		login.clickButton();
		logger.info("Click login btn");
		login.verifyHomePage();
	}
	@Test(dataProvider = "readData",description = "verify with invalid crediantial")
	void verifyUserWithInvalidData(String user, String pass)
	{
		driver.get(url);
		logger.info("land On Login Page");
		HomePage login  = new HomePage(driver);
		login.setUserName(user);
		logger.info("Enter the Username as "+user);
		login.setPassword(pass);
		logger.info("Enter the Password as "+pass);
		login.clickButton();
		logger.info("Click login btn");
		login.verifyInvalidCredential();
		logger.info("verifying Invalid Credential");
	}
	@Test(description = "Home Page End To End Test Case Basic Flow")
	void homePageEndToEndBasicFlow() {
		driver.get(url);
		HomePage login  = new HomePage(driver);
		login.setUserName(global_userName);
		login.setPassword(global_password);
		login.clickButton();
		login.verifyHomePage();
		login.dropDown();
		login.logOut();
	}
	@Test(description = "Home Page End To End Test Case with Alternet Flow")
	void homePageEndToEndWithAlternetFlow() {
		driver.get(url);
		HomePage login  = new HomePage(driver);
		login.dropDown();
		login.logIn();
		login.setUserName(global_userName);
		login.setPassword(global_password);
		login.clickButton();
		String homePageVerficcation=driver.findElement(By.xpath("//h2[normalize-space()=\"Make Appointment\"]")).getText();
		Assert.assertEquals("Make Appointment", homePageVerficcation);
		login.dropDown();
		login.logOut();
	}
	@Test(description = "Verify The Logo")
	void verifyTheLogo() throws InterruptedException {
		driver.get(url);
		HomePage login  = new HomePage(driver);
		login.verifyLogo();
	}

}

