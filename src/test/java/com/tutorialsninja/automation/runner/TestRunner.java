package com.tutorialsninja.automation.runner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/FeatureFiles", 
		glue =  { "com.tutorialsninja.automation.stepdef", "com.tutorialsninja.automation.hooks" }, // 🚀 Explicitly targets only the real folders // 👈 Fixed: removed the duplicate ".stepdef"
		tags = "@Orders",
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true
		)
public class TestRunner {
    // This class remains empty
}


