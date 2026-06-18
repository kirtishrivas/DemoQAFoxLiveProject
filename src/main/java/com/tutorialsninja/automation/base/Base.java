package com.tutorialsninja.automation.base;


import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import com.tutorialsninja.automation.config.ConfigurationReader;
import com.tutorialsninja.automation.config.PropertyFileReader;
import com.tutorialsninja.automation.framework.Browser;
import com.tutorialsninja.automation.util.PathHelper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Base {
	
	public static Logger log=Logger.getLogger(Base.class);
	
	public static WebDriver driver;
	public static ConfigurationReader reader;
	
	
	
	
	//@Before
	public  static void setUp(Scenario scenario){
		log.info("Scenario Started: "+scenario.getName());
		PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
		reader=new PropertyFileReader();
		 System.out.println("Reader object: " + reader);
		    System.out.println("Browser value: " + reader.getBrowser());

		Browser.startBrowser();
		Browser.maximize();
	}
	
	//@After
	public static void closeBrowser(Scenario scenario){
		if(scenario.isFailed()){
			scenario.attach(Browser.takeScreenshot(), "image/png", "Failed Scenario");
		}
		log.info("Scenario Completed: "+scenario.getName());
		log.info("Scenario Status is: "+scenario.getStatus());
		Base.driver.quit();
		}
	
	
	}


