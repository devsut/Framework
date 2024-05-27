package com.base.Pyroframe;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage extends Reports {
	public static WebDriver driver;
	
	public  WebDriver browserlaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	    }
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
	    }
		return driver;
	}
	
	public BasePage(WebDriver driver) {
		BasePage.driver=driver;
	}
	public static void setDriver(WebDriver driver) {
		BasePage.driver = driver;
	}
	  protected WebElement findWebElement(By locator) {
	    	return driver.findElement(locator); 	
	    }
	  protected List<WebElement> findWebElements(By locator) {
	    	List<WebElement> element=driver.findElements(locator);
	    	return element;
	    }
	  protected void click(By locator) {
		  findWebElement(locator).click();
	  }
	  protected void EnterText(By locator,String Input) {
		  findWebElement(locator).clear();
			findWebElement(locator).sendKeys(Input);
	  }
	  protected String getCurrentURL() {
	    	return driver.getCurrentUrl();
	    }
	  protected  String takescreenshots(String Name) {
			String destination = null;
			try {
				TakesScreenshot screenshots=(TakesScreenshot)driver;
				String date = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
				File screen=screenshots.getScreenshotAs(OutputType.FILE);
				destination = System.getProperty("user.dir")+"/screenShot/"+Name+date+".png";
				File dest = new File(destination);
				FileHandler.copy(screen, dest);
				return destination;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return destination;
		}
	  protected  String getText(WebElement e) {
			String text = e.getText();
			return text;
		}
	  protected  void movetoelement(WebElement target) {
			Actions a = new Actions(driver);
			a.moveToElement(target).perform();		
		}
	  protected  void draganddrop(WebElement source,WebElement dest) {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, dest).perform();
		}
	  protected  void rightclick(WebElement target) {
			Actions a = new Actions(driver);
			a.contextClick(target).perform();		
		}
	  protected  void doubleclick(WebElement target) {
			Actions a = new Actions(driver);
			a.doubleClick(target).perform();
		}
	  protected  String getAttribute(WebElement e){
			String attribute = e.getAttribute("value");
			return attribute;
		}
	  protected  void copyrobot()  {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_C);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_C);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  protected  void robotenter() {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  protected  void selectbyindex(WebElement e,int index) {
			Select s = new Select(e);
			s.selectByIndex(index);
		}
	  protected void selectbyvalue(WebElement e,String value) {
			Select s = new Select(e);
			s.selectByValue(value);
		}
	  protected  void selectbyvisibletext(WebElement e,String txt) {
			Select s = new Select(e);
		    s.selectByVisibleText(txt);
		}
	  protected  String getFirstSelected(WebElement e) {
			Select s = new Select(e);
			WebElement option = s.getFirstSelectedOption();
			String text = option.getText();
			return text;
		}
	  protected void deSelectbyIndex(WebElement e,int index) {
			Select s = new Select(e);
			s.deselectByIndex(index);
		}
		
		protected void deSelectbyvisibletext(WebElement e,String value) {
			Select s = new Select(e);
			s.selectByValue(value);
		}
		protected void deSelectAll(WebElement e) {
			Select s = new Select(e);
			s.deselectAll();
		}
		protected void alert() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}
		protected void dismiss() {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}
		protected void promptalert(String value) {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
			a.accept();
		}
		protected void frame(int index) {
		   driver.switchTo().frame(index);
		}
		protected void frame1(String name) {
		   driver.switchTo().frame(name);
		}
		protected void frame2(String id) {
		   driver.switchTo().frame(id);
		}
		protected void defaultcontent() {
		   driver.switchTo().defaultContent();
		}
		protected  void parentframe() {
			 driver.switchTo().parentFrame();
		}
		protected void javascriptset(WebElement w,String s) {
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].setAttribute('value','s')", w);
		}
		protected void javascriptget(WebElement w) {
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("return arguments[0].getAttribute('value')", w);
		}
		protected void scrolldown(WebElement w) {
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(true)", w);
		}
		protected  void scrollup(WebElement w) {
			JavascriptExecutor j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(false)", w);
		}
		protected String getWindowHandle() {
			String windowHandle = driver.getWindowHandle();
			return windowHandle;
		}
		protected String getWindowHandles(int arg) {
			Set<String> s = driver.getWindowHandles();
			List<String> l = new ArrayList<>();
			l.addAll(s);
			driver.switchTo().window(l.get(arg));
			return null;
		}
		protected void back() {
			driver.navigate().back();
		}
		protected void forward() {
			driver.navigate().forward();
		}
		protected void refresh() {
			driver.navigate().refresh();
		}

		protected void displayed(WebElement e) {
			boolean displayed = e.isDisplayed();
		}
		protected void enabled(WebElement e) {
			boolean displayed = e.isEnabled();
		}
		protected void selected(WebElement e) {
			boolean displayed = e.isSelected();
		}
	  
	  
	  
}
