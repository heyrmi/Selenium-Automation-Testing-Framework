package factories;

import browser.BrowserCapabilities;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

import static config.FrameworkConfigManager.frameworkConfigManager;

/**
 * This class is responsible for assigning the WebDriver based on the needs of
 * user, it can be local or remote
 * (on a server or on docker)
 */
public final class DriverFactory {

	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	private static final String browserstack_username = System.getenv("BROWSERSTACK_USERNAME");
	private static final String browserstack_access_key = System.getenv("BROWSERSTACK_ACCESS_KEY");

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browserName, String version) throws MalformedURLException {

		// TODO: Optimise this!

		WebDriver driver = null;

		String runmode = frameworkConfigManager().runmode();
		String platform = frameworkConfigManager().platform();

		if (browserName.equalsIgnoreCase("chrome")) {

			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				//Options for remote chrome
				if (platform.equalsIgnoreCase("selenoid")) {
				try {
					cap.setCapability("browserName", "chrome");
					cap.setCapability("enableVNC", false);
					cap.setCapability("enableVideo", false);
					driver = new RemoteWebDriver(new URL(frameworkConfigManager().seleniumgridurl()), cap);
				} catch (java.net.MalformedURLException e) {
					logger.error("Grid URL is invalid or Grid is not available");
					}
				}
				else if(platform.equalsIgnoreCase("browserstack")){
					cap.setCapability("browserName", "Chrome");
					cap.setCapability("browserVersion", "latest");
					driver = new RemoteWebDriver(
							new URL("https://" + browserstack_username + ":" + browserstack_access_key
									+ "@hub-cloud.browserstack.com/wd/hub"), cap);
				}
				//Selenium HUB
				else{
					cap.setBrowserName("chrome");
					driver = new RemoteWebDriver(new URL(frameworkConfigManager().seleniumgridurl()), cap);
				}
				//Options for local chrome
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Chrome driver launched");
			}


		} else if (browserName.equalsIgnoreCase("firefox")) {

			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				//Options for remote chrome
				if (platform.equalsIgnoreCase("selenoid")) {
					try {
						cap.setCapability("browserName", "firefox");
						cap.setCapability("enableVNC", false);
						cap.setCapability("enableVideo", false);
						driver = new RemoteWebDriver(new URL(frameworkConfigManager().seleniumgridurl()), cap);
					} catch (java.net.MalformedURLException e) {
						logger.error("Grid URL is invalid or Grid is not available");
					}
				}
				else if(platform.equalsIgnoreCase("browserstack")){
					cap.setCapability("browserName", "Firefox");
					cap.setCapability("browserVersion", "latest");
					driver = new RemoteWebDriver(
							new URL("https://" + browserstack_username + ":" + browserstack_access_key
									+ "@hub-cloud.browserstack.com/wd/hub"), cap);
				}
				//Selenium HUB
				else{
					cap.setBrowserName("firefox");
					driver = new RemoteWebDriver(new URL(frameworkConfigManager().seleniumgridurl()), cap);
				}
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Firefox driver launched");
			}
		}
		return driver;
	}
}
