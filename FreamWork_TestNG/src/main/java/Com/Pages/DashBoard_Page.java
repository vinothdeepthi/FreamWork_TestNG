package Com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DashBoard_Page {
	
WebDriver driver;
	
	@FindBys({@FindBy(xpath = "//div[@class='pf-c']//h3")})
	private List<WebElement> Baby_Category; 
	
	@FindBy(xpath = "//a[@class='site-header__icon site-header__search_icon dT_TopStickySearchBtn']")
	private WebElement Search_Icon;
	
	@FindBy(name ="q")
	private WebElement Search_TextBox;
	
	@FindBy(xpath = "(//button[@class='dt-sc-btn'])[1]")
	private WebElement Search;
	
	@FindBy(xpath = "//div[@class='menu-trigger']")
	private WebElement Menu_Button;
	
	@FindBys({@FindBy(xpath = "//ul[@data-menu='dt-main-menu']//a")})
	private List<WebElement> Menu_Options;
	
	@FindBys({@FindBy(xpath = "//*[@id=\"winter-wear-4-dt-sc-menu\"]/ul/li//a")})
	private List<WebElement> Winter_products;
	
	@FindBy(xpath = "//*[@id=\"__pf\"]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div[2]/div/h3")
	private WebElement Single_Category;
	
	
	
	
public WebElement getSingle_Category() {
		return Single_Category;
	}

public List<WebElement> getWinter_products() {
		return Winter_products;
	}

public WebElement getMenu_Button() {
		return Menu_Button;
	}

	public List<WebElement> getMenu_Options() {
		return Menu_Options;
	}

public WebElement getSearch() {
		return Search;
	}

public DashBoard_Page(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

public WebDriver getDriver() {
	return driver;
}


public List<WebElement> getBaby_Category() {
	return Baby_Category;
}

public WebElement getSearch_Icon() {
	return Search_Icon;
}

public WebElement getSearch_TextBox() {
	return Search_TextBox;
}


}
