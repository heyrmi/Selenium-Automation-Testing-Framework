package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public final class FlipkartHomePage extends BasePage{
	
	//To avoid logging in as it will require personal details
	/**
	 * Locators
	 */
	private final By closeButton = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	private final By searchBar = By.xpath("//input[@title='Search for products, brands and more']");
	private final By searchButton = By.xpath("//button[@type='submit']");
	
	
	/**
	 * Functions 
	 */
	public FlipkartHomePage clickCloseButton() {
		click(closeButton, WaitStrategy.CLICKABLE, "Close Button");
		return this;
	}
	
	public FlipkartHomePage enterSomethingInSearchBar(String value) { 
		sendKeys(searchBar, value, WaitStrategy.CLICKABLE, "Search Box");
		return this;
	}
	
	public SearchPage clickSearchButton() {
		click(searchButton, WaitStrategy.CLICKABLE, "Search Button");
		try {Thread.sleep(3000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		return new SearchPage();
	}
}
