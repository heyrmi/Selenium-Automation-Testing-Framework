package driver;

import java.net.MalformedURLException;
import java.util.Objects;

import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import utils.PropertyUtils;

/**
 * This class is responsible for invoking the webdriver based on what user mentioned in excel
 */

public final class Driver {
	
	private Driver() {}
	
	public static void initDriver(String browser,String version)  {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser,version));
			
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Please check the capabilities of browser");
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			
		}
	}

	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
