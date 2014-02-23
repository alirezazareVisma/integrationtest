package nl.lnlug.cucumber.integrationtest.driver;

import nl.lnlug.cucumber.integrationtest.SeleniumDriver;
import nl.lnlug.cucumber.integrationtest.State;

import org.openqa.selenium.WebDriver;

/**
 * Contains Selenium generic actions
 * 
 * @author Zare_AD
 *  */
public class GenericDriver {
	
	protected static State state = new State(); 
	


	public static State getState() {
		return state;
	}
	
	public static void goToURL(String url) {
		getWebDriver().get(state.getServerUrl() + url);
	}


	protected static WebDriver getWebDriver() {
		return SeleniumDriver.getInstance();
	}



}
