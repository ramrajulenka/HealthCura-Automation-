package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePage {
	public static	WebDriver ldriver;
	
	  public ProfilePage(WebDriver driver)
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
		@FindBy(xpath="//a[@id=\"menu-toggle\"]")
		WebElement dropDown;
		@FindBy(xpath="//a[normalize-space()=\"Profile\"]")
		WebElement profilePageElement;
		@FindBy(xpath="//h2[normalize-space()=\"Profile\"]")
		WebElement verifyProfilePage;
		
		public void login(String user,String pass) {
			usernameElement.sendKeys(user);
			passwordElement.sendKeys(pass);
			buttonElement.click();
			
		}
		public  void dropDown()
		 {
			dropDown.click();
		 }
		public void clickOnProfile() {
			profilePageElement.click();
			
		}
		public void verifyProfilePage() {
		String profilePageMsg=verifyProfilePage.getText();
		Assert.assertEquals("Profile", profilePageMsg);
		}
}
