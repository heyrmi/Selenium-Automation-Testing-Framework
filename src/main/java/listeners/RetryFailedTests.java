package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import enums.ConfigProperties;
import utils.PropertyUtils;

/**
 * This class is responsible for retrying the failed test cases (only once)
 * If user wishes to run multiple times he can do it through excel sheet. 
 */
public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int retries = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		boolean value =false;

		if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count<retries ;
			count++;
		} 
		return value;
	}

}
