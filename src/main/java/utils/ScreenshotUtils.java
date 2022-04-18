package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;

/**
 * This class is responsible for Taking the screenshots
 */
public final class ScreenshotUtils {
	
	
	private ScreenshotUtils() {}
	
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
