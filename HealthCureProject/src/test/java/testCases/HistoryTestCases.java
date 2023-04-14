package testCases;

import org.testng.annotations.Test;

import pages.HistoryPage;
import pages.HomePage;
import pages.MakeAppointmentPage;
import utility.Base;

public class HistoryTestCases extends Base{
@Test(description = "Histry Page End To End Test Cases")	
public void HistoryEndToEnd() throws InterruptedException {
	driver.get(url);
	HistoryPage histry=new HistoryPage(driver);
	histry.login(global_userName, global_password);
    histry.dropDown();
    histry.clickOnHistory();
    histry.verifyHistoryPage();
    HomePage logout  = new HomePage(driver);
	logout.dropDown();
    logout.logOut();	
}
@Test(description = "Verify Added Appointment Displayed in History Page")	
public void addingAppointmtDisplyInHisty() throws InterruptedException {
	driver.get(url);
	HistoryPage histry=new HistoryPage(driver);
	histry.login(global_userName, global_password);
	MakeAppointmentPage mkApntmt=new MakeAppointmentPage(driver);
	mkApntmt.setFaciltyAsHongkong();
	mkApntmt.selectReadmission();
	mkApntmt.selectMedicalAid();
	mkApntmt.selectCalender();
	mkApntmt.setDate();
	mkApntmt.setComment("Comment");
	mkApntmt.bookAppointement();
    histry.dropDown();
    histry.clickOnHistory();
    histry.verifyAddedAppointment();
    HomePage logout  = new HomePage(driver);
	logout.dropDown();
    logout.logOut();	
}	
}
