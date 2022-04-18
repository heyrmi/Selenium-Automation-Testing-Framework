package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class ItemPage extends BasePage{
	
	
	private final By addItemsToCart = By.xpath("//button[text()='ADD TO CART']");
	private final By sizeOfShoes = By.xpath("//a[text()='10']");
	private final By increseItemInCart = By.xpath("//button[text()='+']");
	//button[text()='+']
	
	
	public ItemPage clickOnAddToCart() {
		click(addItemsToCart, WaitStrategy.CLICKABLE, "Add to cart");
		return this;
	}
	
	public ItemPage clickOnIncresingItemSize() {
		click(increseItemInCart, WaitStrategy.VISIBLE, "Shoes Size 10");
		return this;
	}
	
	public ItemPage clickOnItemSize() {
		click(sizeOfShoes, WaitStrategy.CLICKABLE, "Shoes Size 10");
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		return this;
	}
	
	
	
	public String getPageTitleOfItem() {
		return getPageTitle();
	}
}
