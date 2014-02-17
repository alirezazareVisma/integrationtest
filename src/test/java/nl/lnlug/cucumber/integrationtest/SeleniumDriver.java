package nl.lnlug.cucumber.integrationtest;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Utility class to define the web driver to use while running integration tests
 * 
 * @author azare
 *
 */
public class SeleniumDriver {
	private static WebDriver driver;

	private static final long TIMEOUT = 20;

	/**
	 * Returns a driver to use for Selenium tests
	 * 
	 * @return WebDriver which will be used for running integration tests
	 */
	public static WebDriver getInstance() {
		return getInstance(SupportedSeleniumDrivers.PHANTOMJS);
	}

	/**
	 * Returns a driver to use for Selenium tests
	 * 
	 * @return WebDriver which will be used for running integration tests
	 */
	public static WebDriver getInstance(SupportedSeleniumDrivers supportedDriver) {
		if (driver == null) {
			switch (supportedDriver) {
			case FIREFOX:
				driver = createFireFoxDriver();
				break;
			case HTMLUNIT:
				driver = createHtmlUnitDriver();
				break;
			case PHANTOMJS:
			default:
				driver = createPhantomJSDriver();
				break;
			}

			driver.manage().timeouts()
					.implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1200, 800));
		}

		return driver;
	}

	private static WebDriver createFireFoxDriver() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setEnableNativeEvents(false);
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setPreference("layers.acceleration.disabled", true);

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		desiredCapabilities
				.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

		return new FirefoxDriver(desiredCapabilities);
	}

	private static WebDriver createHtmlUnitDriver() {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities
				.htmlUnitWithJs();
		desiredCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);

		return new HtmlUnitDriver(desiredCapabilities);
	}

	private static WebDriver createPhantomJSDriver() {
		URL url = SeleniumDriver.class.getResource("phantomjs.exe");
		String path = url.getPath();

		DesiredCapabilities desiredCapabilities = DesiredCapabilities
				.phantomjs();
		desiredCapabilities
				.setCapability(
						PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						path);
		desiredCapabilities.setCapability(
				CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		desiredCapabilities
				.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		desiredCapabilities.setCapability(
				CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
		desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS,
				true);

		// PhantomJSDriver atm does not support alerts
		// newCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		desiredCapabilities.setJavascriptEnabled(true);

		ArrayList<String> cliArgs = new ArrayList<String>();
		cliArgs.add("--web-security=true");
		cliArgs.add("--ignore-ssl-errors=true");
		desiredCapabilities.setCapability(
				PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgs);

		return new PhantomJSDriver(desiredCapabilities);
	}

}
