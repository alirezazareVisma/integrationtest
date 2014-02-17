package nl.lnlug.cucumber.integrationtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The test runner for integration test using JUnit and Cucumber Also contains
 * glue code for test features.
 * 
 * @author azare
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	format = { 
		"pretty", 
		"html:target/cucumber-reports/html" 
	}, 
	monochrome = false, 
	features = { "src/test/resources/features/" }, 
	glue = { "nl.lnlug.cucumber.integrationtest" },
	tags = { "@setup,@it,@cleanup" })
public class CucumberTest {
	private static final Logger LOG = LoggerFactory
			.getLogger(CucumberTest.class);

	@BeforeClass
	public static void setup() {
		LOG.trace("setup()");
		
		SeleniumDriver.getInstance();
	}

	@AfterClass
	public static void cleanup() {
		LOG.trace("cleanup()");
		
		SeleniumDriver.getInstance().quit();
	}
}
