package Test_Case;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Pages.Cart_Page;
import Com.Pages.DashBoard_Page;
import Com.Pages.Login_Page;
import Com.Pages.Product_Page;
import Selenium_Base.Base;

public class AddToCartDashBoard_Product extends Base {
	
	
	@Test
	public void DashBoardProductAddToCar() throws InterruptedException {
		
		Userlogin();
		
		Product_Page product = new Product_Page(driver);
		
		 DashBoard_Page dash = new DashBoard_Page(driver);
			
		 Cart_Page cart = new Cart_Page(driver);
		
		ScrollDown(dash.getSingle_Category());
		
		for(WebElement category : dash.getBaby_Category()) {
 			
	 		if(GetText(category).equalsIgnoreCase(ReadProperties().getProperty("category"))) {
	 				
	 			click(category);
	 			break;
	 		}}
		
		SelectProduct(ReadProperties().getProperty("productname"));
		
		//ScrollDown(product.getQuantity());
		
		//Type(product.getQuantity(), "2");
		
		ScrollDown(product.getAddToCart_Button());
		
		click(product.getAddToCart_Button());
		
		click(product.getView_Cart_Button());
		
		ValidateCartProduct(ReadProperties().getProperty("productname"));
		
		Quit_Application();
		
		
		
	}

}
