package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class SearchPage extends BasePage {
	
	/**
	 * This page will load after we search for "red shoes"
	 * 
	 */
	
	private final By sortByLowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
	private final By lowerPrice = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div/section[2]/div[4]/div[1]/select");
	private final By higherPrice = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div/section[2]/div[4]/div[3]/select");
	private final By price1000 = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div/div/div/section[2]/div[4]/div[1]/select/option[3]");
	private final By price2000 = By.xpath("//*[@id='container']/div/div[3]/div/div[1]/div/div/div/section[2]/div[4]/div[3]/select/option[2]");

	//Third shoes xpath taken by visible imagelink
	private final By thirdItem = By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div[2]/div/div[3]/div/div/a[1]");
			//By.xpath("//a[@title='Smart Shocks Shoes with Memory Foam Loafers & 02 Casuals for Men ( Pack of 03 Pairs) Casuals For Men']");
	
	
	public String getTitle() {
		try {Thread.sleep(3000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		
		return getPageTitle();
	}
	
	public SearchPage Reload() {
		pageReload();
		return this;
	}
	
	public SearchPage clickFilterLowToHigh() {
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		click(sortByLowToHigh, WaitStrategy.CLICKABLE, "Price low to high");
		return this;
	}
	
	public SearchPage lowerPriceFilter(String value) {
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		//dropdown(lowerPrice, value, WaitStrategy.CLICKABLE, "Lower Price");
		click(lowerPrice, WaitStrategy.CLICKABLE, "Price Low ");
		click(price1000, WaitStrategy.CLICKABLE, "1000 ");
		return this;
	}
	
	public SearchPage higherPriceFilter(String value) {
		//dropdown(higherPrice, value, WaitStrategy.CLICKABLE, "Higher Price");
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		click(higherPrice, WaitStrategy.CLICKABLE, "Price high");
		click(price2000, WaitStrategy.CLICKABLE, "2000 ");
		return this;
	}
	
	public SearchPage clickThirdItem() {
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		click(thirdItem, WaitStrategy.CLICKABLE, "ThirdItem");
		return this;
	}
	
	public ItemPage switchTab() {
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		pageReload(1);
		return new ItemPage();
	}
	
	
	
}
