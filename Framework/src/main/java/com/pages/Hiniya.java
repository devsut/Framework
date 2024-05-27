package com.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Hybridutility.GOR;
import com.base.Pyroframe.BasePage;

public class Hiniya extends BasePage {

	public Hiniya(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void title() {
		String currentURL = getCurrentURL();
		System.out.println(currentURL);
	}
	public void clickallaction() {
		click(GOR.about);
		String expectedurl="https://hiniya.com/about-us/";
		String actualurl = getCurrentURL();
		assertEquals(expectedurl, actualurl);
		WebElement consultaction = findWebElement(GOR.consult);
		
		click(GOR.services);
		movetoelement(consultaction);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	click(GOR.consult);
		click(GOR.qaconsult);
		

	}
}
