package Com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {
	
	WebDriver driver;

	@FindBys({@FindBy(xpath = "//div[@class='product-detail content-center']//a")})
	private List<WebElement> product_Category; 
	
	@FindBy(id = "Quantity-product-template")
	private WebElement Quantity;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement AddToCart_Button;
	
	@FindBy(xpath = "//button[text()='Buy it now']")
	private WebElement BuyNow_Button;
	
	@FindBy(xpath = "(//a[@class='dt-sc-btn add-wishlist'])[1]")
	private WebElement AddWhichList_Button;
	
	@FindBy(xpath = "//a[text()='View Cart ']")
	private WebElement View_Cart_Button;
	
	@FindBys({@FindBy(xpath = "//div[@class='swatch-group']//label")})
	private List<WebElement> product_Size;
	
	@FindBys({@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--selectable']")})
	private List<WebElement> Filter_Product;
	
	@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
	private WebElement Filter_Button;
	
	
	
	

	public WebElement getFilter_Button() {
		return Filter_Button;
	}

	public List<WebElement> getProduct_Size() {
		return product_Size;
	}

	public Product_Page(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
    
    public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getproduct_Category() {
		return product_Category;
	}

	public List<WebElement> getFilter_Product() {
		return Filter_Product;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getAddToCart_Button() {
		return AddToCart_Button;
	}

	public WebElement getBuyNow_Button() {
		return BuyNow_Button;
	}

	public WebElement getAddWhichList_Button() {
		return AddWhichList_Button;
	}

	public WebElement getView_Cart_Button() {
		return View_Cart_Button;
	}

}
