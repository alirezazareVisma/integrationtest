package nl.lnlug.cucumber.integrationtest.driver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import nl.lnlug.cucumber.integrationtest.SeleniumDriver;
import nl.lnlug.cucumber.integrationtest.State;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains Selenium generic actions
 * 
 * @author Zare_AD
 * 
 */
public class GenericDriver {
	
	protected static State state = new State(); 
	
	protected static final int POLLER_TIME_OUT = 3;

	protected static final int TIME_OUT = 40;
	
	protected static final int LOAD_PAGE_TIME_OUT = 60;

	protected static final String GROUP_CONTROL_PANEL_MANAGE_URL = "group/control_panel/manage?";

	protected static final String SERVER_ADMINISTRATION_PORTLET_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=137";

	protected static final String FIND_USER_GROUP_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=127&_127_struts_action=%2Fuser_groups_admin%2Fview&_127_keywords=+%09EPE_platform-manager_";

	protected static final String FIND_SITE_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=134&_134_struts_action=%2Fsites_admin%2Fview&_134_name=";
	protected static final String FIND_SITE_MEMBERS_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=174&_174_struts_action=%2Fsite_memberships_admin%2Fedit_site_assignments&_174_advancedSearch=true";
	protected static final String ADD_SITE_MEMBERS_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=174&_174_struts_action=%2Fsite_memberships_admin%2Fedit_site_assignments&_174_tabs1=users&_174_tabs2=available&doAsGroupId=";
	protected static final String SITE_MEMBERSHIP_REQUEST_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=174&_174_struts_action=%2Fsite_memberships_admin%2Fview_membership_requests&doAsGroupId=";
	protected static final String EDIT_SITE_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=165&doAsGroupId=";

	protected static final String SITE_MANAGEMENT_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=134";

	protected static final String FIND_USER_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=125&_125_struts_action=%2Fusers_admin%2Fview_users&_125_usersListView=flat-users&_125_advancedSearch=true&_125_emailAddress=";
	protected static final String EDIT_USER_URL = GROUP_CONTROL_PANEL_MANAGE_URL
			+ "p_p_id=125&_125_struts_action=%2Fusers_admin%2Fedit_user&_125_p_u_i_d=";

	protected static final String INVITATION_PORTLET_URL = "/user-directory?p_p_id=100&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_100_struts_action=%2Finvitation%2Finvite";

	protected static final String REGISTRATION_PORTLET_URL = "web/guest/registration?epe=";

	protected static final String AUTHORIZATION_APPROVEMENT_COMMENT = "This user is approved by authorization test";
	protected static final String AUTHORIZATION_DENY_COMMENT = "This user is denied by authorization test";
	protected static final String AUTHORIZATION_COMMENT = "This user is commented by authorization test";
	protected static final String MEMBERSHIP_REQUEST_APPROVEMENT_COMMENT = "This user is approved by membership request test";
	protected static final String MEMBERSHIP_REQUEST_DENIAL_COMMENT = "This user is denied by membership request test";

	public static State getState() {
		return state;
	}
	
	public static void goToURL(String url) {
		getWebDriver().get(state.getServerUrl() + url);
	}


	protected static WebDriver getWebDriver() {
		return SeleniumDriver.getInstance();
	}

	protected static FluentWait<WebDriver> getFluentWaiter(WebDriver webDriver) {
		return new FluentWait<WebDriver>(webDriver)
			       .withTimeout(TIME_OUT, TimeUnit.SECONDS)
			       .pollingEvery(POLLER_TIME_OUT, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
	}
	
	protected static WebDriverWait getWaiter(WebDriver webDriver) {
		return new WebDriverWait(webDriver, TIME_OUT);
	}
	
	protected static WebElement getElementWhenReady(WebDriver webDriver, By by) {
		getWaiter(webDriver).until(ExpectedConditions.visibilityOfElementLocated(by));		
		return getWaiter(webDriver).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	protected static WebElement getElementWhenPresent(WebDriver webDriver, By by) {	
		return getWaiter(webDriver).until(ExpectedConditions.elementToBeClickable(by));
	}

	protected static WebElement getElementWhenClickable(WebDriver webDriver, By by) {
		return getWaiter(webDriver).until(ExpectedConditions.elementToBeClickable(by));
	}

	protected static void loadPage(WebDriver webDriver) {
		webDriver.manage().timeouts().pageLoadTimeout(LOAD_PAGE_TIME_OUT, TimeUnit.SECONDS);
		webDriver.manage().timeouts().setScriptTimeout(LOAD_PAGE_TIME_OUT, TimeUnit.SECONDS);
	}

	
	protected static void clickAndAcceptAlert(WebDriver webDriver, By by) {
		webDriver.findElement(by).click();
		acceptAlert(webDriver);
	}
	
	protected static void submitAndAcceptAlert(WebDriver webDriver, By by) {
		webDriver.findElement(by).submit();
		acceptAlert(webDriver);
	}
	protected static void acceptAlert(WebDriver webDriver) {
		webDriver.switchTo().alert().accept();
	}


}
