package Test_Case;

import org.testng.annotations.Test;

import Com.Pages.Cart_Page;
import Com.Pages.DashBoard_Page;
import Com.Pages.Product_Page;
import Selenium_Base.Base;

public class SearchAddToCartPrduct extends Base {
	
	@Test
	public void AddToCartSerchProduct() {
		
		Userlogin();
		
        Product_Page product = new Product_Page(driver);
		
		DashBoard_Page dash = new DashBoard_Page(driver);
		
		Cart_Page cart = new Cart_Page(driver);
		
		click(dash.getSearch_Icon());
		
		Type(dash.getSearch_TextBox(), ReadProperties().getProperty("searchproduct"));
		
		click(dash.getSearch());
		
		SelectProduct(ReadProperties().getProperty("dressproduct"));
		
        ScrollDown(product.getAddToCart_Button());
		
		click(product.getAddToCart_Button());
		
		click(product.getView_Cart_Button());
		
		ValidateCartProduct(ReadProperties().getProperty("dressproduc"));
		
        Quit_Application();
		
		
	}

}
