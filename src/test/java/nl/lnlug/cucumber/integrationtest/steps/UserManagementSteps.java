package nl.lnlug.cucumber.integrationtest.steps;

import static org.junit.Assert.assertNotNull;
import cucumber.api.java.en.Then;
import nl.lnlug.cucumber.integrationtest.driver.UserManagementDriver;

import org.openqa.selenium.WebElement;

/**
 * Cucumber steps related to user management.
 * 
 */
public class UserManagementSteps {

	/**
	 * Deactivate a given user
	 * 
	 * @param emailAddress
	 * @throws Throwable
	 */
	@Then("^deactivate user \"([^\"]*)\"$")
	public void deactivate_user(String emailAddress) throws Throwable {
		WebElement el = UserManagementDriver.findUser(emailAddress, "0");
		assertNotNull("Could not find active user " + emailAddress, el);
		UserManagementDriver.deactivateUser(emailAddress);
		el = UserManagementDriver.findUser(emailAddress, "5");
		assertNotNull("User is not deactivated " + emailAddress, el);
	}
	
//	/**
//	 * Activate a given user
//	 * @param emailAddress
//	 * @throws Throwable
//	 */
//	@Then("^activate user \"([^\"]*)\"$")
//	public void activate_user(String emailAddress) throws Throwable {
//		WebElement el = UserManagementDriver.findUser(emailAddress, "5");
//		assertNotNull("Could not find deactived user " + emailAddress, el);
//		UserManagementDriver.activateUser(emailAddress);
//		el = UserManagementDriver.findUser(emailAddress, "0");
//		assertNotNull("User is not activated " + emailAddress, el);
//	}


}
