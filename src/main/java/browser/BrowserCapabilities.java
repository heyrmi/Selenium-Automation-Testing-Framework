package browser;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public final class BrowserCapabilities {
    //To avoid external instantiation
    private BrowserCapabilities(){}

    /**
     * To add browserstack capabilities only
     */
    public static DesiredCapabilities addBrowserStackCapabilities(String browser, String version) {
        //TODO: Support versions later (only in Browserstack)

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Broswer Capabilities
        switch (browser) {
            case "chrome":
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("browserVersion", "latest");
                break;
            case "firefox":
                capabilities.setCapability("browserName", "Firefox");
                capabilities.setCapability("browserVersion", "latest");
                break;
            case "edge":
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "latest");
                break;
            default:
                break;
        }

        //Browserstack Capabilities
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("projectName", "WebUI Automation");
        browserstackOptions.put("buildName", "Sample Build");
        browserstackOptions.put("sessionName", "Sample Test");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("debug", "true");
        browserstackOptions.put("seleniumVersion", "4.2.2");
        capabilities.setCapability("bstack:options", browserstackOptions);

        return capabilities;
    }

    /**
     * To return selenoid capabilities
     */
    public static DesiredCapabilities getSelenoidCapabilities(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }

    /**
     * To add selenium-hub capabilities
     */

    public static DesiredCapabilities getSeleniumHubCapabilities(String browser){
        String browserName = String.valueOf(browser);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        return capabilities;
    }

}
