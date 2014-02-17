package nl.lnlug.cucumber.integrationtest.steps;

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

	@Then("^go to controle panel$")
	public void go_to_controle_panel() throws Throwable {
	   AuthenticationDriver.goToControlePanel();
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
	
	@Then("^do something else using \"([^\"]*)\"$")
	public void do_something_else_using(String arg1) throws Throwable {
	}


}
