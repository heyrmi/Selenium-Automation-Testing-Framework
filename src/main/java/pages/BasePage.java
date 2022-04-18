package pages;

import static enums.LogType.INFO;
import static reports.FrameworkLogger.log;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;

/**
 * This class is responsible for providing all basic controls for elements on then site. 
 */
public class BasePage {

	
	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		log(INFO, elementname+" is clicked");
		
	}
	
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		log(INFO, value +" is entered successfully in "+elementname);
	}
	
	protected void dropdown(By by, String dropDownValue, WaitStrategy waitstrategy,String elementname) {
		Select dropDown = new Select(ExplicitWaitFactory.performExplicitWait(waitstrategy, by));
		dropDown.selectByVisibleText(dropDownValue);
		log(INFO, dropDownValue +" selected from "+elementname);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void waitForElementToBeVisible(By by) {
		WebElement element = DriverManager.getDriver().findElement(by);
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOf(element));
		log(INFO, "Waited for the element to be visible ");
	}
	
	protected void pageReload() {
		DriverManager.getDriver().navigate().refresh();
		log(INFO, "Page is reloaded successfully ");
	}
	
	protected void pageReload(int tabNo) {
		ArrayList<String> tabs2 = new ArrayList<String> (DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(tabs2.get(tabNo));
	}
	
	
	

	
}
