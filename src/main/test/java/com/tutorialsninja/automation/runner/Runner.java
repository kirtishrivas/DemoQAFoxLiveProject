package com.tutorialsninja.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/FeatureFiles", 
		glue = "com.tutorialsninja.automation.stepdef", // 👈 Fixed this to match your step definition package exactly
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true
		)
public class Runner {
    // This class remains empty
}