package factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyUtils;

/**
 * This class is responsible for assigning the WebDriver based on the needs of
 * user, it can be local or remote
 * (on a server or on docker)
 */
public final class DriverFactory {

	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browserName, String version) throws MalformedURLException {

		// TODO: Add support for browserstack and selenoid drivers

		WebDriver driver = null;

		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if (browserName.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase("remote")) {
				try {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("browserName", "chrome");
					cap.setCapability("enableVNC", false);
					cap.setCapability("enableVideo", false);
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
				} catch (java.net.MalformedURLException e) {
					logger.error("Grid URL is invalid or Grid is not available");
				}
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Chrome driver launched");
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {

			if (runmode.equalsIgnoreCase("remote")) {
				try {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("browserName", "firefox");
					// cap.setCapability("browserVersion", version);
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
				} catch (java.net.MalformedURLException e) {
					logger.error("Grid URL is invalid or Grid is not available");
				}
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Firefox driver launched");
			}
		} else if (browserName.equalsIgnoreCase("edge")) {

			if (runmode.equalsIgnoreCase("remote")) {
				try {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("browserName", "edge");
					// cap.setCapability("browserVersion", version);
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
				} catch (java.net.MalformedURLException e) {
					logger.error("Grid URL is invalid or Grid is not available");
				}
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Edge driver launched");
			}
		}
		return driver;
	}

}
