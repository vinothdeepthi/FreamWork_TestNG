package Com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.Pages.Cart_Page;
import Com.Pages.DashBoard_Page;
import Com.Pages.Login_Page;
import Com.Pages.Product_Page;
import Selenium_Base.Base;

public class Commons {
	
	public static WebDriver driver;
	
	static Properties pro = null;
	
	static ExtentReports report;
	
	public static Properties ReadProperties() {
		
		
		try {
			
			FileInputStream file;	file = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\FreamWork_TestNG\\src\\test\\resources\\Pro.properties");
			 pro = new Properties();
			pro.load(file);
			
		} catch (FileNotFoundException e) {
			
			System.err.println("invalid File  =>"+e.getMessage());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return pro;
	}
	
public String TakeScreenShots( WebDriver driver) throws IOException {
		
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File des = new File(System.getProperty("user.dir")+"\\Screenshots\\screen.png");
		
		FileUtils.copyFile(source, des);
	
		return des.getAbsolutePath();
	}
	
	
	 public static ExtentReports GetExtendReports()  {
		
		report = new ExtentReports();
		
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\FreamWork_TestNG\\src\\test\\resources\\Report\\report.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
		spark.config().setReportName("this Project Name ");
		
		spark.config().setDocumentTitle("this document Name ");
		
		report.attachReporter(spark);
		
		return report; }
		
	
	public static void Userlogin() {
		
		try {
			
			Base b = new Base();
			
			 Login_Page login = new Login_Page(driver);
			
			b.SetUp(ReadProperties().getProperty("browser"), ReadProperties().getProperty("url"));
			
			Assert.assertEquals(b.GetTitle(), ReadProperties().getProperty("homepagetitle"));
			
			b.click(login.getProfile_Logo());
			
			b.AppendText(login.getUserName(), ReadProperties().getProperty("username"));
			
			b.AppendText(login.getPassword(), ReadProperties().getProperty("password"));
			
			b.click(login.getLogin_Button());
			
			Assert.assertEquals(b.GetText(login.getAccount_Detiles()),ReadProperties().getProperty("accountname"));
			
			b.click(login.getHome_Button());	
		} 
		catch (NoSuchElementException e) {
			
			System.err.println(e.getMessage());
			throw new NoSuchElementException("Element is not Found");
		}
		
         catch (NullPointerException e) {
			
			System.err.println(e.getMessage());
			//throw new NoSuchElementException("Element returns null value");
		}
		catch (Exception e) {
			
			System.err.println(e.getMessage());	
		}    
	}
	
	public static void SelectProduct(String ProductName) {
		
		Base b = new Base();
		 
		 Product_Page product = new Product_Page(driver);
		 
		 try {
			 
			 for(WebElement product1 : product.getproduct_Category()) {
				 	
			 	   if(b.GetText(product1).equalsIgnoreCase(ProductName)) { 
			 			
		               b.click(product1);
			 		   
			 		   break;
			 		}
				} 
			
		} catch (NoSuchElementException e) {
			
			System.err.println(e.getMessage());
			throw new NoSuchElementException("Element is not Found");
			
		}
		 
		 catch (ElementClickInterceptedException e) {
				
				System.err.println(e.getMessage());
				throw new NoSuchElementException("Element is not clickAble");
				
			}
		 
		 catch (Exception e) {
				
				System.err.println(e.getMessage());
				
			}   
	 }
	
       public static void ValidateCartProduct(String CartProduct) {
    	   
    	   Base b = new Base();
		 
		 Cart_Page cart = new Cart_Page(driver);
		 
		 try {
			 
			 for (WebElement carts : cart.getAll_Cart_Product()) {
		 			
		 			if(b.GetText(carts).equalsIgnoreCase(CartProduct)) {
		 				
		 				Assert.assertTrue(true);
		 			}
		 			
		 			else {
		 				Assert.assertTrue(false);
		 			}
			 }
		}
		 catch (NoSuchElementException e) {
			
		 System.err.println(e.getMessage());
			throw new NoSuchElementException("Element is not Found");	
		} 
		 
		 catch (Exception e) {
			
			System.err.println(e.getMessage());	
		}	
       }
}
