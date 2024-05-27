package com.base.Pyroframe;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports extends Listeners {
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public SimpleDateFormat data;
	
	public  static void startReport() {
		try {
			//To load Extend Report
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = timestamp+".html";
			spark =new ExtentSparkReporter(System.getProperty("user.dir")+"./target/"+repName);
		//	spark.loadXMLConfig(System.getProperty("user.dir")+"/Config/extent-report.xml");
			spark.config().setDocumentTitle("Testing");
			spark.config().setReportName("Functional Testing");
			spark.config().setTheme(Theme.DARK);
			spark.config().setProtocol(Protocol.HTTPS);
			spark.config().setEncoding("UTF-8");
			
			report =new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("HostName", "LocalHost");
			report.setSystemInfo("Port", "4444");
			report.setSystemInfo("OS", "Windows10");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testStepInfo(String Message, ITestResult tr) {
		String MethodName=tr.getMethod().getMethodName();
		ITestResult result = org.testng.Reporter.getCurrentTestResult();
        String trr=result.getMethod().getMethodName();
		test =report.createTest(MethodName);
		log.info(Message);
		test.log(Status.INFO,Message);
	}
	public void testStepPass(String Message) {
		log.info(Message);
		//test.log(Status.PASS,Message);
	}
	public  void testStepFail(String Message) {
		log.info(Message);
		//test.log(Status.FAIL,Message);
	}
	public static void result(ITestResult itr,WebDriver driver) {
		try {
			String methodName = itr.getMethod().getMethodName();
			if (itr.getStatus()==ITestResult.FAILURE) {
				String expectedmessage = Arrays.toString(itr.getThrowable().getStackTrace());
				Reports.test.fail("<details><summary><b><font color=red>Exception accured Please click here to see the detail.</font></b><summary>"+
				expectedmessage.replace(",", "<br>")+"</details> \n");
				BasePage base=new BasePage(driver);
				String path = base.takescreenshots(itr.getMethod().getMethodName());
				Reports.test.fail("<b><font color=red>"+"ScreenShot of Failure"+"</font><b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				String logText="<b> Test Method"+methodName+"Failed</b>";
				Markup markup=MarkupHelper.createLabel(logText, ExtentColor.RED);
				Reports.test.log(Status.FAIL, markup);
			}else if(itr.getStatus()==ITestResult.SUCCESS) {
				String logText="<b> Test Method "+methodName+" Successfull</b>";
				Markup markup=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
				Reports.test.log(Status.PASS, markup);
				
			}else if(itr.getStatus()==ITestResult.SKIP) {
				String logText="<b> Test Method"+methodName+"Skipped</b>";
				Markup markup=MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
				Reports.test.log(Status.SKIP, markup);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void flush() {
		report.flush();

	}

}
