package Com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver driver;

	@FindBy(xpath = "//a[@class='site-header__icon site-header__account']")
	private WebElement Profile_Logo;
	
	@FindBy(id="CustomerEmail")
	private WebElement UserName;
	
	@FindBy(id = "CustomerPassword")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@value='My Account']")
	private WebElement Login_Button;
	
	@FindBy(xpath = "//div[@class='address-col']//h5")
	private WebElement Account_Detiles;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement Home_Button;
	
	
	public WebElement getHome_Button() {
		return Home_Button;
	}

	public Login_Page(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getProfile_Logo() {
		return Profile_Logo;
	}


	public WebElement getUserName() {
		return UserName;
	}


	public WebElement getPassword() {
		return Password;
	}


	public WebElement getLogin_Button() {
		return Login_Button;
	}


	public WebElement getAccount_Detiles() {
		return Account_Detiles;
	}

}
