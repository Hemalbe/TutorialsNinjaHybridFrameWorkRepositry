package com.tutorialsnija.qa.utlis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport(){
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"//test-output//ExtentReports//extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinjaTestAutomationResults");
		sparkReporter.config().setDocumentTitle("TutorialsNinja TestAutomation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"//src//main//java//com//tutorialsnija//qa//config//config.properties");
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email", configProp.getProperty("username"));
		extentReport.setSystemInfo("Password", configProp.getProperty("password"));
		extentReport.setSystemInfo("os.name", System.getProperty("os.name"));
		extentReport.setSystemInfo("user.name", System.getProperty("user.name "));
		extentReport.setSystemInfo("java.version", System.getProperty("java.version"));

		return extentReport;
		
	}
	

}
