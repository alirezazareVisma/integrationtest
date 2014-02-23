package nl.lnlug.cucumber.integrationtest.steps;

import nl.lnlug.cucumber.integrationtest.ScreenshotHook;
import nl.lnlug.cucumber.integrationtest.driver.AuthenticationDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Cucumber steps related to authentication.
 * 
 */
public class AuthenticationSteps {

	public static final String DEFAULT_PASSWORD = "test";

	/**
	 * Make sure the given user is logged in.
	 * 
	 * @param userName
	 */
	@Given("^user \"(.+)\" is logged in$")
	@Then("^login as \"([^\"]*)\"$")
	public void loginUser(String userName) {
		AuthenticationDriver.login(userName, DEFAULT_PASSWORD);
	}

	/**
	 * Logs in to EPE using the given login name and password
	 * 
	 * @param userName
	 * @param password
	 * @throws Throwable
	 */
	@Then("^login to EPE as \"([^\"]*)\", \"([^\"]*)\"$")
	public void loginAs(String userName, String password) {
		AuthenticationDriver.login(userName, password);
	}

	/**
	 * 
	 * @throws Throwable
	 */
	@Then("^go to controle panel$")
	public void go_to_controle_panel() throws Throwable {
		Thread.sleep(5000);
		AuthenticationDriver.goToControlePanel();
		ScreenshotHook.createScreenshot("LNLUG");
		Thread.sleep(5000);
	}

	/**
	 * Logs out in EPE
	 * 
	 * @throws Throwable
	 */
	@Then("^logout$")
	public void logout() {
		AuthenticationDriver.logout();
	}

}
