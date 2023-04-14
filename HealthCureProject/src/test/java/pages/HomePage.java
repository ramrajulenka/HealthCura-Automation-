package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	public static	WebDriver ldriver;
	
	  public HomePage(WebDriver driver)
		{
		    ldriver= driver;
			PageFactory.initElements(driver, this);
		}
	  
		@FindBy(id="txt-username")
		WebElement usernameElement;
		
		@FindBy(id="txt-password")
		WebElement passwordElement;
		
		@FindBy(id="btn-login")
		WebElement buttonElement;
		@FindBy(xpath="//i[@class=\"fa fa-bars\"]")
		WebElement dropDown;
		@FindBy(linkText  ="Login")
		WebElement logIn;
		@FindBy(linkText  ="Logout")
		WebElement logOut;
		@FindBy(xpath="//a[@id=\"btn-make-appointment\"]")
		WebElement makeAppntmt;
		@FindBy(xpath="//h2[normalize-space()=\"Make Appointment\"]")
		WebElement homePageVerifyElement;
		@FindBy(xpath="//p[@class=\"lead text-danger\"]")
		WebElement invalidTextMsg;
		@FindBy(xpath="//h1[normalize-space()=\"CURA Healthcare Service\"]")
		WebElement logo;
		
		public void setUserName(String username)
		{
			usernameElement.sendKeys(username);
		}
		
		public void setPassword(String password)
		{
			passwordElement.sendKeys(password);
		}
		public  void clickButton()
		 {
			buttonElement.click();
		 }
		public  void dropDown()
		 {
			dropDown.click();
		 }
        public void logIn() {
			
			logIn.click();
			
		}
  public void makeAppointmnt() {
		makeAppntmt.click();
			
		}
public void logOut() {
			
			logOut.click();
			
		}
public void verifyHomePage() {
	String homePageVerficcation=homePageVerifyElement.getText();
	Assert.assertEquals("Make Appointment", homePageVerficcation);
	
}
public void verifyInvalidCredential() {
	String invalidCredentialMsg=invalidTextMsg.getText();
	Assert.assertEquals("Login failed! Please ensure the username and password are valid.", invalidCredentialMsg);
	
}
public void verifyLogo() {
String Pagelogo=logo.getText();
Assert.assertEquals("CURA Healthcare Service", Pagelogo);
}
}
