package com.assign1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asign1.generics.BaseTest;

public class FlipkartPage extends BaseTest {
	
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	private WebElement clsBTN;
	
	@FindBy(name = "q")
	private WebElement srch;
	
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	private WebElement product;
	
	@FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	private WebElement priceText;
	
	public FlipkartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnX()
	{
		clsBTN.click();
	}
	
	public void passText(String text)
	{
		srch.sendKeys(text,Keys.ENTER);
	}
	
	public void clickOnPro()
	{
		product.click();
	}
	
	public float getPrice()
	{
		String temp = priceText.getText();
		String temp2 = temp.replaceAll("[₹ ,]", "");
		float price= Float.parseFloat(temp2);
		System.out.println(price);
		return price;
	}

}
