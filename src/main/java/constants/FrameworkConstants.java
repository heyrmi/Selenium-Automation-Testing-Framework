package constants;

import enums.ConfigProperties;
import utils.PropertyUtils;

/**
 * Contains all the constants of the framework
 *
 */
public final class FrameworkConstants {
	

	private FrameworkConstants() {}
	
	private static final int EXPLICITWAIT = 10;
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/Resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/Drivers/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH+"/Drivers/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/Config/config.properties";
	private static final String EXCELPATH = RESOURCESPATH+"/Excel/testdata.xlsx";
	private static final String RUNMANGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath = "";
	

	public static String getExtentReportFilePath()  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath()  {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	
	
	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	
	public static String getRunmangerDatasheet() {
		return RUNMANGERSHEET;
	}
	
	public static String getIterationDatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

}
