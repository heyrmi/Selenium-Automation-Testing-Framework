package constants;

import enums.ConfigProperties;
import lombok.Getter;
import utils.PropertyUtils;

/**
 * Contains all the constants of the framework
 *
 */
public final class FrameworkConstants {
	

	private FrameworkConstants() {}
	
	private static final @Getter int  EXPLICITWAIT = 10;
	private static final @Getter String RESOURCESPATH = System.getProperty("user.dir")+"/resources";
	private static final @Getter String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final @Getter String EXCELPATH = RESOURCESPATH+"/excel/testdata.xlsx";
	private static final @Getter String RUNMANGERSHEET = "RUNMANAGER";
	private static final @Getter String ITERATIONDATASHEET = "DATA";
	private static final @Getter String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static @Getter String extentReportFilePath = "";
	

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
}


