package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MakeAppointmentPage {
	public static	WebDriver ldriver;
	
	  public MakeAppointmentPage(WebDriver driver)
		{
		    ldriver= driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[@id=\"menu-toggle\"]")
	WebElement dropDown;
	@FindBy(xpath = "(//a[normalize-space()='Home'])[1]")
	WebElement clickHome;
	@FindBy(xpath="//a[@id=\"btn-make-appointment\"]")
	WebElement selectMakeAppointmt;
	@FindBy(id="txt-username")
	WebElement usernameElement;
	@FindBy(id="txt-password")
	WebElement passwordElement;
	@FindBy(id="btn-login")
	WebElement buttonElement;
	@FindBy(name="facility")
	WebElement heathCareTokyo;
	@FindBy(xpath="//option[@value=\"Hongkong CURA Healthcare Center\"]")
	WebElement heathCareHongKong;
	@FindBy(xpath="//option[@value=\"Seoul CURA Healthcare Center\"]")
	WebElement heathCareCenteSeoul;
	@FindBy(xpath="//input[@id=\"chk_hospotal_readmission\"]")
	WebElement hospitalReadmission;
	@FindBy(xpath="//input[@id=\"radio_program_medicaid\"]")
	WebElement radioBtnMeicaid;
	@FindBy(xpath="//div[@class=\"input-group-addon\"]")
	WebElement visitDateElement;
	@FindBy(xpath="//td[normalize-space()=\"24\"]")
	WebElement chooseDate;
	@FindBy(xpath="//textarea[@id=\"txt_comment\"]")
	WebElement commentField;
	@FindBy(xpath="//button[@id=\"btn-book-appointment\"]")
	WebElement bookAppontmtBtn;
	@FindBy(xpath="//h2[normalize-space()=\"Appointment Confirmation\"]")
	WebElement confrmBookElemt;
	
	public  void dropDown()
	 {
		dropDown.click();
	 }
	public void homePage() {
		clickHome.click();
			
		}
	public void clickMakeAppointmt() {
		selectMakeAppointmt.click();
	}
	public void login(String user,String pass) {
		usernameElement.sendKeys(user);
		passwordElement.sendKeys(pass);
		buttonElement.click();
		
	}
	public void setFaciltyAsTokyo(String tokya)
	{
		heathCareTokyo.sendKeys(tokya);
	}
	public void setFaciltyAsHongkong()
	{
		heathCareHongKong.click();;
	}
	public void setFaciltyAsSeoul()
	{
		heathCareCenteSeoul.click();
	}
	public void selectReadmission()
	{
		 hospitalReadmission.click();
	}
	public void selectMedicalAid()
	{
		radioBtnMeicaid.click();
	}
	public void selectCalender()
	{
		visitDateElement.click();
	}
	public void setDate()
	{
		chooseDate.click();
	}

	public void setComment(String comment)
	{
		commentField.sendKeys(comment);
	}
	public void bookAppointement()
	{
		bookAppontmtBtn.click();
	}
	public void verifyConformBooking() {
		String appointmentConformMsg=confrmBookElemt.getText();
		Assert.assertEquals("Appointment Confirmation", appointmentConformMsg);
		
	}
	
	  
}
