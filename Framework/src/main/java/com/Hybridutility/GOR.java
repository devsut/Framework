package com.Hybridutility;

import org.openqa.selenium.By;

public class GOR {

		
    // HINIYA WEBSITE WEBELEMENTS
    public static final By about=By.xpath("(//span[text()='About us'])[1]");
    public static final By services=By.xpath("//span[text()='Services']");
    public static final By consult=By.xpath("(//span[text()='Consulting'])[1]//ancestor::a");
    public static final By qaconsult=By.xpath("(//span[text()='QA Consulting'])[1]//ancestor::a");
    
    //ORANGE HRM
    public static final  By username= By.xpath("//input[@name='username']");
	public static final By password=By.xpath("//input[@name='password']");
    public  static final By submit=By.xpath("//button[@type='submit']");
    public static final By recruitment=By.xpath("//span[text()='Recruitment']");
    public static final By jobdownarrow=By.xpath("(//div[@class='oxd-select-text--after'])[1]");
    public static final By vacancydownarrow=By.xpath("(//div[@class='oxd-select-text--after'])[2]");
    public static final By hiringmanagerdownarrow=By.xpath("(//div[@class='oxd-select-text--after'])[3]");
    public static final By statusdownarrow=By.xpath("(//div[@class='oxd-select-text--after'])[4]");
    public static final By selectjob=By.xpath("//span[text()='Chief Executive Officer']");
    public static final By selectvacancy=By.xpath("//span[text()='nitheesh']");
    public static final By hiringmanager=By.xpath("//span[text()='Odis Adalwin']");
    
    
    

    
}
