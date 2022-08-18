package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;



public final class OrangeHRMHomePage extends BasePage {
	
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	
	
	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE,"Welcome link");
		return this;
	}
	
	
			
	public OrangeHRMLoginPage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");
		return new OrangeHRMLoginPage();
	}
	

	
	
	//wait.until(d->d.findElement(link_logout).isEnabled()); //Java 8 way
}
