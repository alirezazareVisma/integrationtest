package nl.lnlug.cucumber.integrationtest.steps;

import static org.junit.Assert.assertNotNull;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nl.lnlug.cucumber.integrationtest.ScreenshotHook;
import nl.lnlug.cucumber.integrationtest.driver.AuthenticationDriver;

import org.openqa.selenium.WebElement;

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
		WebElement logoutElement = AuthenticationDriver.login(userName,
				DEFAULT_PASSWORD);
		assertNotNull("Logout element is not found.", logoutElement);
	}

	/**
	 * 
	 * @throws Throwable
	 */
	@Then("^go to controle panel$")
	public void go_to_controle_panel() throws Throwable {
		AuthenticationDriver.goToControlePanel();
		ScreenshotHook.createScreenshot("LNLUG");
	}

	/**
	 * Logs out in Portal
	 * 
	 * @throws Throwable
	 */
	@Then("^logout$")
	public void logout() {
		AuthenticationDriver.logout();
	}

	@Then("^ik do iets$")
	public void ik_do_iets() throws Throwable {
	}

}
