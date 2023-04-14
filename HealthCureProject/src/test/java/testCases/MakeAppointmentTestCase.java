package testCases;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MakeAppointmentPage;
import utility.Base;

public class MakeAppointmentTestCase extends Base{
	@Test(description ="Make Appointment End to End Test Case basic flow")
	void makeAppointmentEndToEnd(){
		driver.get(url);
		MakeAppointmentPage mkApointmt=new MakeAppointmentPage(driver);
		mkApointmt.login(global_userName, global_password);
		mkApointmt.setFaciltyAsTokyo("Facility");
		mkApointmt.selectReadmission();
		mkApointmt.selectMedicalAid();
		mkApointmt.selectCalender();
		mkApointmt.setDate();
		mkApointmt.setComment("This Is comment");
		mkApointmt.bookAppointement();
		mkApointmt.verifyConformBooking();
		HomePage logout  = new HomePage(driver);
		logout.dropDown();
	    logout.logOut();
	} 
		@Test(description ="Make Appointment End to End Test Case Alternet  flow")
		void makeAppointmentEndToEndAlternetFlow() throws InterruptedException{
			driver.get(url);
			MakeAppointmentPage mkApointmt=new MakeAppointmentPage(driver);
     		mkApointmt.dropDown();
	    	mkApointmt.homePage();
			mkApointmt.clickMakeAppointmt();
			mkApointmt.login(global_userName, global_password);
			mkApointmt.setFaciltyAsHongkong();
			mkApointmt.selectReadmission();
			mkApointmt.selectMedicalAid();
			mkApointmt.selectCalender();
			mkApointmt.setDate();
			mkApointmt.setComment("This Is comment");
			mkApointmt.bookAppointement();
			mkApointmt.verifyConformBooking();
			HomePage logout  = new HomePage(driver);
			logout.dropDown();
			logout.logOut();
		} 
}
