package com.pages;

import org.openqa.selenium.WebDriver;

import com.Hybridutility.GOR;
import com.Hybridutility.XmlUtility;
import com.base.Pyroframe.BasePage;

public class Login_Page extends BasePage {

	public Login_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login() {
		String username = XmlUtility.readexcel("TC01","User", 0);
		EnterText(GOR.username, username);
		log.info("username is entered");
		takescreenshots("test");
	}
	public void password() {
		String password = XmlUtility.readexcel("TC01","Pass", 0);
		EnterText(GOR.password,password );
		log.info("password is entered");
	}
    public void button() {
    	click(GOR.submit);
		log.info("login button is clicked");
	}
		

}
