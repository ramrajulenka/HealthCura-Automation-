package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HistoryPage {
public static	WebDriver ldriver;
	
	  public HistoryPage(WebDriver driver)
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
	@FindBy(xpath = "//a[normalize-space()=\"History\"]")
	WebElement clickHistory;
	@FindBy(xpath = "//h2[normalize-space()=\"History\"]")
	WebElement historyPageElemnt;
	@FindBy(xpath = "//p[@id=\"facility\"]")
	WebElement addedAppontmt;
	
	
	public void login(String user,String pass) {
		usernameElement.sendKeys(user);
		passwordElement.sendKeys(pass);
		buttonElement.click();	
	}
	public  void dropDown()
	 {
		dropDown.click();
	 }
	public void clickOnHistory() {
		clickHistory.click();
		
	}
	public void verifyHistoryPage() {
	String histryPageMsg=historyPageElemnt.getText();
	Assert.assertEquals("History", histryPageMsg);
	}
	public void verifyAddedAppointment() {
		String addedApntmt=addedAppontmt.getText();
		Assert.assertEquals("Hongkong CURA Healthcare Center", addedApntmt);
		}
}
