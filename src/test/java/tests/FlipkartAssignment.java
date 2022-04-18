package tests;

import static enums.LogType.PASS;
import static reports.FrameworkLogger.log;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import annotation.FrameworkAnnotation;
import enums.CategoryType;
import pages.FlipkartHomePage;
import pages.ItemPage;
import pages.SearchPage;


public final class FlipkartAssignment extends BaseTest{

	private FlipkartAssignment() {}

	
	@Test
	@FrameworkAnnotation(author= {"Rahul"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void flipkartTestChrome(Map<String,String> data) {
		Assert.assertTrue(true);
	}
	
	@Test
	@FrameworkAnnotation(author= {"Rahul"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void flipkartTestFirefox(Map<String,String> data) {
		throw new SkipException("Skipping this test");
	}
	
	@Test
	@FrameworkAnnotation(author= {"Rahul"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void flipkartTestEdge(Map<String,String> data) {
		Assert.fail("Just Failed");
	}
	
	/**
	 * @Test
	@FrameworkAnnotation(author= {"Rahul"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void flipkartTestChrome(Map<String,String> data) {

		String title =new FlipkartHomePage()
				.clickCloseButton()
				.enterSomethingInSearchBar(data.get("SearchText"))
				.clickSearchButton()
				.getTitle();
		
		
		//Expected message (title) can also be kept in Excel but its not advisable
		Assertions.assertThat(title)
		.isEqualTo("Red Shoes- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		
		if(title.contains("Red Shoes- Buy Products Online")) {
			log(PASS, "First Condition is passed");
		}
		
		
		try {Thread.sleep(1000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		
		String titleOfShoes = new SearchPage()
				.Reload()
				.clickFilterLowToHigh()
				.lowerPriceFilter(data.get("LowerPrice"))
				.higherPriceFilter(data.get("HigherPrice"))
				.clickThirdItem()
				.switchTab()
				.getPageTitleOfItem();
		
		Assertions.assertThat(titleOfShoes).isNotNull();
		
		if(!titleOfShoes.isEmpty()){
			log(PASS, "First Condition is passed");
		}
		
		new ItemPage()
		.clickOnAddToCart()
		.clickOnItemSize()
		.clickOnAddToCart()
		.clickOnIncresingItemSize();
		
	}
	 */
	
}
