package driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

/**
 * This class makes the driver instance threadsafe so that no driver instance collides with others 
 */
public final class DriverManager {


	private DriverManager() {}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>() ;


	public static WebDriver getDriver() {
		return dr.get();
	}

	
	static void setDriver(WebDriver driverref) {
		if(Objects.nonNull(driverref)) {
			dr.set(driverref);
		}
	}
	
	static void unload() {
		dr.remove();
	}

}
