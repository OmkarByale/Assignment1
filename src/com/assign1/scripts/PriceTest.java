package com.assign1.scripts;

import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.asign1.generics.BaseTest;
import com.assign1.pages.AmazonPage;
import com.assign1.pages.FlipkartPage;

public class PriceTest extends BaseTest {
	
	

	@Test
	public void testPrice()
	{
		//to get the price of Amazon
		driver.get("https://www.amazon.in/");
		AmazonPage ap = new AmazonPage(driver);
		ap.passText("iPhone XR (64GB) - Yellow");
		ap.clickOnPro();
		Set<String> whs = driver.getWindowHandles();
		for(String w : whs)
		{
			driver.switchTo().window(w);
		}
		float aprice = ap.getPrice();
		Reporter.log("Price in Amazon : Rs. "+aprice, true);
		
		//to get the price of Flipkart
		driver.get("https://www.flipkart.com/");
		FlipkartPage fp = new FlipkartPage(driver);
		fp.clickOnX();
		fp.passText("iPhone XR (64GB) - Yellow");
		fp.clickOnPro();
		Set<String> whs2 = driver.getWindowHandles();
		for(String w : whs2)
		{
			driver.switchTo().window(w);
		}
		
		float fprice = fp.getPrice();
		Reporter.log("Price in Flipkart : Rs. "+fprice, true);
		
		if(aprice<fprice)
		{
			Reporter.log("Best price is in Amazon Rs. "+aprice, true);
		}
		else if(aprice>fprice)
		{
			Reporter.log("Best price in Flipkart Rs. "+fprice, true);
		}
		else
		{
			Reporter.log("Both are having same price Rs. "+ aprice, true);
		}
		
	}

}
