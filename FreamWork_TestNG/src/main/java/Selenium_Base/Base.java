package Selenium_Base;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Com.Utils.Commons;

public class Base extends Commons implements SeleniumBases {

	static WebDriverWait wait;
	
	@Override
	public void SetUp(String browsername, String url) {

		switch (browsername) {     
		case "chrome":

			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\OneDrive\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			
			wait=new WebDriverWait(driver, 30);

			break;

		case "firefox":

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);

			break;

		default:

			System.err.println("Browser is Invalid");
			break;
		}

	}
	
	

	
	@Override
	public void Close() {

		driver.close();

	}

	
	@Override
	public void Quit_Application() {

		driver.quit();

	}
    
	@Override
	public WebElement Element(String type, String Value) {
try {
	
	switch (type) {
	case "id":

		return driver.findElement(By.id(Value));

	case "name":

		return driver.findElement(By.name(Value));

	case "xpath":

		return driver.findElement(By.xpath(Value));

	case "cssSelector":

		return driver.findElement(By.cssSelector(Value));

	default:

		System.err.println("invalid element");
		break;
	}
} 

catch (NoSuchElementException e) {
	
	System.err.println("Emement is Not Found => "+e.getMessage());
	
	throw new NoSuchElementException("Element Is Not Found"); 
}

catch (WebDriverException e) {
	
	System.err.println(e.getMessage());
	
	throw new WebDriverException ("UnKown Exception");
}

catch (Exception e) {
	
	System.err.println(e.getMessage());
}
		
		return null;
	}

	@Override
	public void SelectByValue(WebElement element, String Value) {


          WebElement ele =  IsElementVisible(element);	
          
          new Select(ele).selectByValue(Value);
	}

	@Override
	public void SelectByindext(WebElement element, int Value) {

		WebElement ele =  IsElementVisible(element);	
        
        new Select(ele).selectByIndex(Value);
	}

	@Override
	public void SelectByVisibleText(WebElement element, String Value) {

		WebElement ele =  IsElementVisible(element);	
        
        new Select(ele).selectByVisibleText(Value); 
	}

	@Override
	public void click(WebElement element) {

	   wait.withMessage("Element Not Clickable" ).until(ExpectedConditions.elementToBeClickable(element)).click();
		
	}
	
	
	public void IsSelectdValueIsCorrect(WebElement a ,String value) {
		
		WebElement ele = IsElementVisible(a);
		
		boolean an = ele.isSelected();
		
		Assert.assertTrue(an);
		
		
	}

	@Override
	public String GetTitle() {

		return driver.getTitle();
	}

	@Override
	public String GetUrl() {

		return driver.getCurrentUrl();
	}

	@Override
	public boolean isdisplyed(WebElement e) {

		return  e.isDisplayed();
	}

	@Override
	public void Type(WebElement ele, String value) {
		
		WebElement ele1 = IsElementVisible(ele);
		
		ele1.clear();
		
		ele1.sendKeys(value);
		
	}

	private WebElement IsElementVisible(WebElement ele) {
		
		WebElement ele1 =  wait.withMessage("Element Is Not Visible").until(ExpectedConditions.visibilityOf(ele));
		return ele1;
	}
	
     public void Type(WebElement ele, String value,Keys key) {
		
		WebElement ele1 = IsElementVisible(ele);
		
		ele1.clear();
		
		ele1.sendKeys(value);
		
	}
     
     public void AppendText(WebElement a, String Value) {
    	 
    	 WebElement ele = IsElementVisible(a);
    	 ele.sendKeys(Value);
     }

	@Override
	public void SwitchToWindows(int a) {
		
		Set<String> all = driver.getWindowHandles();
		
		ArrayList<String> li = new ArrayList<String>(all);
		
		driver.switchTo().window(li.get(a));
		
	}
	
	public String GetText(WebElement a) {
		
	return wait.until(ExpectedConditions.visibilityOf(a)).getText();
		
	}


	@Override
	public void ScrollDown(WebElement ele) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		   
	     jse.executeScript("arguments[0].scrollIntoView();",ele);
		
	}
	
	public void MoveToElement(WebElement Element,WebDriver dri) {
		
		Actions act = new Actions(dri);
		
		act.moveToElement(Element).click().perform();
		
		
	}

	

	

}
