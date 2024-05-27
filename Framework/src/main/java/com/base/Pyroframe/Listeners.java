package com.base.Pyroframe;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	public SimpleDateFormat date;
	
	
	public Logger log=LogManager.getLogger(getClass());
	
	 static {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		String time = dateformat.format(new Date());
		String filepath = String.format("logs/Log4jDemo_%s.log", time);
		System.setProperty("log",filepath);
	}
	 @Override
	public void onStart(ITestContext context) {
		log.info("********************* TESTSCRIPT EXECUTION IS STARTED ******************");
		System.out.println("********************* TESTSCRIPT EXECUTION IS STARTED ******************");
	}
	@Override
	public void onTestStart(ITestResult result) {
	String start = result.getMethod().getMethodName();
	log.info("**********************"+start +" EXECUTION IS STARTED ******************");
	System.out.println("**********************"+start +" EXECUTION IS STARTED ******************");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String success = result.getMethod().getMethodName();
		log.info("**********************"+success +" COMPLETED SUCCESSFULLY ******************");
		System.out.println("**********************"+success +" COMPLETED SUCCESSFULLY ******************");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String fail = result.getMethod().getMethodName();
		log.info("**********************"+fail +" HAS BEEN FAILED ******************");
		System.out.println("**********************"+fail +" HAS BEEN FAILED ******************");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String skip = result.getMethod().getMethodName();
		log.info("**********************"+skip +" HAS BEEN SKIPPED ******************");
		System.out.println("**********************"+skip +" HAS BEEN SKIPPED ******************");
	}
	@Override
	public void onFinish(ITestContext context) {
		log.info("********************* TESTSCRIPT EXECUTION IS FINISHED ******************");
		System.out.println("********************* TESTSCRIPT EXECUTION IS FINISHED ******************");
	}
	

}
