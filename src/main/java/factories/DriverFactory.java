package factories;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

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

	public static WebDriver getDriver(String browserName, String browserVersion) throws MalformedURLException {

		WebDriver driver = null;

		String runmode = frameworkConfigManager().runmode();

		if (runmode.equalsIgnoreCase("browserstack")) {
			driver = browserStackDriver(browserName, browserVersion);
		} else if (runmode.equalsIgnoreCase("selenoid")) {
			driver = selenoidDriver(browserName, browserVersion);
		} else if (runmode.equalsIgnoreCase("local")) {
			driver = localDriver(browserName, browserVersion);
		}
		return driver;
	}

	@SneakyThrows
	private static WebDriver browserStackDriver(String browserName, String browserVersion) {
		// TODO: Utilise browserVersion, os, os_version
		// TODO: add a browsername as Enum, so no other name can be passed
		logger.info("Browser is: " + browserName);
		logger.info("Browser version is: " + browserVersion);
		logger.info("Will run test in BrowserStack");

		WebDriver brwoserstackdriver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os", "Windows");
		capabilities.setCapability("os_version", "11");
		capabilities.setCapability("build", "Automation Testing");
		capabilities.setCapability("browser", browserName);
		capabilities.setCapability("browserVersion", "latest");
		brwoserstackdriver = new RemoteWebDriver(
				new URL("https://" + browserstack_username + ":" + browserstack_access_key
						+ "@hub-cloud.browserstack.com/wd/hub"),
				capabilities);

		return brwoserstackdriver;
	}

	@SneakyThrows
	private static WebDriver selenoidDriver(String browserName, String browserVersion) {

		logger.info("Browser is: " + browserName);
		logger.info("Browser version is: " + browserVersion);
		logger.info("Will run test in Selenoid");

		WebDriver selenoiddriver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("enableVNC", false);
		capabilities.setCapability("enableVideo", false);
		selenoiddriver = new RemoteWebDriver(new URL(frameworkConfigManager().seleniumgridurl()), capabilities);

		return selenoiddriver;
	}

	private static WebDriver localDriver(String browserName, String browserVersion) {

		logger.info("Browser is: " + browserName);
		logger.info("Browser version is: " + browserVersion);
		logger.info("We don't have provision for browserVersion in local");
		logger.info("Will run test in Local");

		WebDriver localdriver = null;
		switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				localdriver = new ChromeDriver();
				logger.info("Chrome driver launched");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				localdriver = new FirefoxDriver();
				logger.info("Firefox driver launched");
				break;
			default:
				logger.info("No browser selected. Please select one");
				break;
		}
		return localdriver;
	}

}
