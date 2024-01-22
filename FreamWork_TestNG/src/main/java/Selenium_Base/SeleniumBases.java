package Selenium_Base;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public interface SeleniumBases {
	
	/**
	 * This Fuction To Lounch The Browser And Application
	 * @author admin
	 * @param browsername
	 * @param url
	 * @exception NullPointerException
	 */
	
	void SetUp(String browsername,String url);
	
	
	/**
	 * This Fuction To Close The Current Window 
	 * @author admin
	 * @exception NullPointerException
	 */
	void Close();
	
	/**
	 * This Fuction To Close The All Window 
	 * @author admin
	 * @exception NullPointerException
	 */
	
	void Quit_Application();
	
	/**
	 * This Method To Use Finding The WebElement with in The Page
	 * @param type Element Type like id name xpath Cssselector
	 * @param Value
	 * @return The WebElement
	 * @exception NoSuchElementException
	 */
	
	WebElement Element(String type , String Value);
	
	
	void SelectByValue(WebElement element,String Value);
	
	void SelectByindext(WebElement element,int Value);
	
	void SelectByVisibleText(WebElement element,String Value);
	
	void click(WebElement element);
	
	String GetTitle();
	
	String GetUrl();
	
	void Type(WebElement ele,String value);

	void SwitchToWindows(int a);

	boolean isdisplyed(WebElement e);
	
	void ScrollDown(WebElement ele);
	
     void MoveToElement(WebElement Element,WebDriver driver) ;
		
	
	

}
