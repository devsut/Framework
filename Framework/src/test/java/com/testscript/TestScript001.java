package com.testscript;

import org.testng.annotations.Test;

import com.Basetest.BaseTest;
import com.aventstack.extentreports.Status;
import com.base.Pyroframe.Reports;
import com.pages.Login_Page;

public class TestScript001 extends BaseTest {
	
	Login_Page login;
	@Test
	protected void ts_001(){
	Reports.test=Reports.report.createTest("LOGINFUNCTION");
	Reports.test.assignCategory("p1");
	login = new Login_Page(driver);
	login.login();
	Reports.test.log(Status.PASS, "successfully clicked the login button");
	login.password();
	Reports.test.log(Status.PASS, "successfully password entered");
	login.button();
	Reports.test.log(Status.PASS, "successfully button clicked");
	
	}

}
