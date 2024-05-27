package com.Basetest;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.base.Pyroframe.Reports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	 
	@BeforeSuite
	public void reportclass() {
		Reports.startReport();
		
	    }
	
	@BeforeTest
	@Parameters("browserlaunch")
	public void launch(String browser) {
	
//	WebDriverManager.chromedriver().setup();
//	driver=new ChromeDriver();
//	BasePage base=new BasePage(driver);
//	base.browserlaunch(browser);
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
    }
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
    }
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@AfterMethod()
	public void afterMerhod(ITestResult itr) {
		Reports.result(itr,driver);
	}
	@AfterClass
	public void afterclass() {
		driver.quit();

	}
	@AfterSuite
	public void close() {
		Reports.flush();
	}
}
