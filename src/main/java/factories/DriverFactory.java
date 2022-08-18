package factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyUtils;

/**
 * This class is responsible for assigning the WebDriver based on the needs of user, it can be local or remote
 * (on a server or on docker)
 */
public final class DriverFactory {

	private DriverFactory() {}

	public static WebDriver getDriver(String browserName,String version) throws MalformedURLException {

		WebDriver driver = null;

		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if(browserName.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("browserName", Browser.CHROME);
				cap.setCapability("browserVersion", version);
				driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		else if(browserName.equalsIgnoreCase("firefox")) {

			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("browserName", Browser.FIREFOX);
				cap.setCapability("browserVersion", version);
				driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		else if(browserName.equalsIgnoreCase("edge")) {

			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("browserName", Browser.EDGE);
				cap.setCapability("browserVersion", version);
				driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		return driver;
	}

}
