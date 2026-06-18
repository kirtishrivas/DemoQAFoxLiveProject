package com.tutorialsninja.automation.hooks;

import com.tutorialsninja.automation.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void scenarioSetUp(Scenario scenario) {
		// Call statically using the Class name directly!
		Base.setUp(scenario);
	}

	@After
	public void scenarioTearDown(Scenario scenario) {
		// Call statically using the Class name directly!
		Base.closeBrowser(scenario);
	}
}