package tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.Driver;

/**
 * This class is responsible for running the test cases and opening and closing of the desired browsers
 */
public class BaseTest {
	
	protected BaseTest() {}
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) { //Map<String,String>
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"),map.get("version"));
	}

	
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}



}
