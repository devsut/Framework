package com.testscript;

import org.testng.annotations.Test;

import com.Basetest.BaseTest;
import com.aventstack.extentreports.Status;
import com.base.Pyroframe.Reports;
import com.pages.Orange_hrm_login;

public class Orange_hrm extends BaseTest{
	Orange_hrm_login orange;
	
	@Test
	public void login() {
		Reports.test =Reports.report.createTest("TEST SCRIPT1");
		Reports.test.assignCategory("P1");
		orange=new Orange_hrm_login(driver);
		orange.username();
		Reports.test.log(Status.PASS, "successfully entered the username");
		orange.password();
		Reports.test.log(Status.PASS, "successfully entered the password");
		orange.submit();
		Reports.test.log(Status.PASS, "successfully clicked the submit button");
		orange.recuirment();
		Reports.test.log(Status.PASS, "successfully clicked the recuirment button");
		orange.selectjob();
		Reports.test.log(Status.PASS, "successfully selected the job ");
		orange.selectvacancy();
		Reports.test.log(Status.PASS, "successfully selected the vacancy ");
		orange.selecthiringmanager();
		Reports.test.log(Status.PASS, "successfully selected the hiringmanager ");
	}

}
