package nl.lnlug.cucumber.integrationtest.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Selenium code related to user authentication.
 * 
 */
public class AuthenticationDriver extends GenericDriver {
	private static final Logger LOG = LoggerFactory
			.getLogger(AuthenticationDriver.class);
	
	private static final String CONTROL_PANEL_URL = "/group/control_panel";
	protected static final String LOGOUT_URL = "c/portal/logout";
	protected static final String LOGIN_URL = "c/portal/login";
	/**
	 * Login with the given user.
	 * 
	 * If another user is logged in, log him out first.
	 * 
	 * @param loginName
	 * @param password
	 * @return 
	 */
	public static WebElement login(String loginName, String password) {
		try {
			getWebDriver().get(state.getServerUrl()+LOGIN_URL);
			if (!state.getCurrentUser().isEmpty()) {
				if (!state.getCurrentUser().equals(loginName)) {
					logout();
				}
			}
	
			if (state.getCurrentUser().isEmpty()) {
				getWebDriver().get(state.getServerUrl()+LOGIN_URL);
				WebElement loginInput = getWebDriver().findElement(By.id("_58_login"));
				loginInput.clear();
				loginInput.sendKeys(loginName);
				getWebDriver().findElement(By.id("_58_password")).sendKeys(password);
				getWebDriver().findElement(By.className("btn-primary"))
				.submit();
				// Keep track of current user
				state.setCurrentUser(loginName);
			}
			return getWebDriver().findElement(By.className("sign-out"));
		} catch (NoSuchElementException ex) {
			LOG.error("Logout element is not found.");
			return null;
		}
	}

	/**
	 * Logout the current user.
	 */
	public static void logout() {
		getWebDriver().get(state.getServerUrl() + LOGOUT_URL);
		state.setCurrentUser("");
		
	}

	/**
	 * Goes to control panel
	 */
	public static void goToControlePanel() {
		getWebDriver().get(state.getServerUrl() + CONTROL_PANEL_URL);
		
	}

}