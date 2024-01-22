package Com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page {
	

	WebDriver driver;
	
	@FindBys({@FindBy(xpath = "//div[@class='product-info']//a")})
	private List<WebElement> All_Cart_Product;
	
	@FindBys({@FindBy(xpath = "//input[@class='quantity-selector cart-number']")})
	private List<WebElement> List_Of_Quantity;

	
    public Cart_Page(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	
	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getAll_Cart_Product() {
		return All_Cart_Product;
	}

	public List<WebElement> getList_Of_Quantity() {
		return List_Of_Quantity;
	}
	

}
