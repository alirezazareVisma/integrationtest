package nl.lnlug.cucumber.integrationtest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * Hook to be run after each scenario.
 * 
 */
public class ScreenshotHook {

	/**
	 * Take a screenshot after a step failed.
	 * 
	 * @param result
	 *            Scenario result.
	 * @throws IOException
	 */
	@After
	public void takeScreenshot(Scenario result) throws IOException {
		if (result.isFailed()) {
			result.embed(createScreenshot(), "image/png");
		}
	}

	/**
	 * Create a screenshot
	 * 
	 * @param fileName
	 *            used to create screenshot
	 */
	public byte[] createScreenshot() {
		if (SeleniumDriver.getInstance() instanceof TakesScreenshot) {
			return ((TakesScreenshot) SeleniumDriver.getInstance())
					.getScreenshotAs(OutputType.BYTES);
		}

		return new byte[] {};
	}
	
	/**
	 * Create a screenshot to file
	 */
	public static void createScreenshot(String fileName) {
		File fileSrc = ((TakesScreenshot) SeleniumDriver.getInstance())
				.getScreenshotAs(OutputType.FILE);

		try {
			File destFile = new File("target/cucumber-screenshots/" + fileName + ".png");
			FileUtils.copyFile(fileSrc, destFile);
			System.out.println(destFile.getAbsolutePath());
		} catch (IOException e) {
			// Ignore silently
		}
	}
}
