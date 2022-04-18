package listeners;

import annotation.FrameworkAnnotation;
import reports.ExtentReport;
import utils.ELKUtils;
import org.testng.*;

import java.util.Arrays;

import static enums.LogType.*;
import static reports.FrameworkLogger.log;

/**
 * This class is responsible for Listening to the test cases, whether they pass or fail or get skipped. 
 */


public class ListenerClass implements ITestListener, ISuiteListener {

	
	@Override
	public void onStart(ISuite suite) {
			ExtentReport.initReports();
	}

	
	@Override
	public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
			
	}

	
	@Override
	public void onTestStart(ITestResult result) {
	
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.category());
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		log(PASS,result.getMethod().getMethodName() +" is passed");
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "pass");
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
			log(FAIL,result.getMethod().getMethodName() +" is failed");
			log(FAIL,result.getThrowable().toString());
			log(FAIL,Arrays.toString(result.getThrowable().getStackTrace()));
			ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "fail");
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		log(SKIP,result.getMethod().getMethodName() +" is skipped");
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
