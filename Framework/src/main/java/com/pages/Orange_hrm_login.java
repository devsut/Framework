package com.pages;

import org.openqa.selenium.WebDriver;

import com.Hybridutility.GOR;
import com.base.Pyroframe.BasePage;

public class Orange_hrm_login extends BasePage {

	public Orange_hrm_login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void username() {
		EnterText(GOR.username, "Admin");
		log.info("Username is successfully entered");
		takescreenshots("username");
	}
	public void password() {
		EnterText(GOR.password, "admin123");
		log.info("Password is successfully entered");
	}
	public void submit() {
		click(GOR.submit);
		log.info("Submit button is successfully clicked");
		takescreenshots("submitpage");
	}
	public void recuirment() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(GOR.recruitment);
		log.info("Recruitment button is successfully clicked");
	}
	public void selectjob() {
		click(GOR.jobdownarrow);
		log.info("Job dropdown arrow is successfully clicked");
		click(GOR.selectjob);
		log.info("Job  is successfully selected");
	}
	public void selectvacancy() {
		click(GOR.vacancydownarrow);
		log.info("vacancy dropdown   is successfully clicked");
		click(GOR.selectvacancy);
		log.info("vacancy  is successfully selected");
	}
	public void selecthiringmanager() {
		click(GOR.hiringmanagerdownarrow);
		log.info("Hiringmanager dropdown   is successfully clicked");
		click(GOR.hiringmanager);
		log.info("Hiringmanager  is successfully selected");
	}

}
