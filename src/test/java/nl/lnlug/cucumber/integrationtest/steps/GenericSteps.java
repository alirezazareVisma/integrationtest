package nl.lnlug.cucumber.integrationtest.steps;

import nl.lnlug.cucumber.integrationtest.driver.GenericDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Contains test methods for generic processes which could be used in different
 * test scenario's
 * 
 * 
 */
public class GenericSteps {

	/**
	 * sets up the connection to database and web driver and defines the host
	 * against which the test scenario's should run.
	 * 
	 * @param serverUrl
	 * @throws Throwable
	 */
	@Given("^set up connections \"([^\"]*)\"$")
	public void set_up_connections(String serverUrl) throws Throwable {
		GenericDriver.getState().setServerUrl(serverUrl);
	}

	/**
	 * This method is used to clean up your connections after running tests
	 * 
	 * @throws Throwable
	 */
	@Then("^close connections$")
	public void close_connections() throws Throwable {
		
		// Clean up your db connection or do any other stuff when you are done 
	}

}
