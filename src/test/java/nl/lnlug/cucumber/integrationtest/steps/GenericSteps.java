package nl.lnlug.cucumber.integrationtest.steps;

import nl.lnlug.cucumber.integrationtest.driver.GenericDriver;
import nl.lnlug.cucumber.integrationtest.util.DBUtil;
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
	 * @param databaseUrl
	 * @throws Throwable
	 */
	@Given("^set up connections \"([^\"]*)\", \"([^\"]*)\"$")	
	public void setupConnections(String serverUrl, String databaseUrl)
			throws Throwable {
		GenericDriver.getState().setServerUrl(serverUrl);

		GenericDriver.getState().setDatabaseUrl(databaseUrl);
		DBUtil.openDbConnection(databaseUrl);
	}

	@Then("^go to site \"([^\"]*)\"$")
	public void gotoSite(String siteName) throws Throwable {
		Thread.sleep(5000);
		GenericDriver.goToURL("web/" + siteName);
		Thread.sleep(5000);
	}

	/**
	 * Closes the database connection if open.
	 * 
	 * @throws Throwable
	 */
	@Then("^close database connections$")
	public void close_database_connections() throws Throwable {
		DBUtil.closeDbConnection();
	}



}
