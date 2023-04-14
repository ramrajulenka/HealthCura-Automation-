package testCases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProfilePage;
import utility.Base;

public class ProfileTestCases extends Base {
	@Test(description = "Profile Page End To End Test Case ")
	public void profileEndToEnd() {
		driver.get(url);
		ProfilePage profile=new ProfilePage(driver);
		profile.login(global_userName, global_password);
		logger.info("Land on Home Page");
		profile.dropDown();
		logger.info("Click On dropDown");
		profile.clickOnProfile();
		logger.info("Click on Profile");
		profile.verifyProfilePage();
		logger.info("Verify Profile Page Page");
		HomePage logout  = new HomePage(driver);
		logout.dropDown();
		logger.info("Click on DropDown");
	    logout.logOut();
	    logger.info("Click on Logout");
	}

}
