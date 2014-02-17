package nl.lnlug.cucumber.integrationtest.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Selenium code related to user authentication.
 * 
 */
public class AuthenticationDriver extends GenericDriver {
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
	 */
	public static void login(String loginName, String password) {
		//state.getServerUrl()
		getWebDriver().get("http://localhost:8080/"+LOGIN_URL);
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
			getWebDriver().findElement(By.className("aui-button-input-submit"))
			.submit();
			getWebDriver().findElement(By.className("sign-out"));
			
			// Keep track of current user
			state.setCurrentUser(loginName);
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
