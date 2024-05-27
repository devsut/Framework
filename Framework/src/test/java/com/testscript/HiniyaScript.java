package com.testscript;

import org.testng.annotations.Test;

import com.Basetest.BaseTest;
import com.aventstack.extentreports.Status;
import com.base.Pyroframe.Reports;
import com.pages.Hiniya;

public class HiniyaScript extends BaseTest{
	Hiniya h;
	@Test
	protected void hc01() {
		Reports.test=Reports.report.createTest("hiniya site");
		Reports.test.assignCategory("h1");
		h= new Hiniya(driver);
		h.title();
		Reports.test.log(Status.PASS, "successfully got the title");
		h.clickallaction();
		Reports.test.log(Status.PASS, "successfully clicked the action");

	}

}
