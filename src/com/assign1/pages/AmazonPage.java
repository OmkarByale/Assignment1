package com.assign1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement srch;
	
	@FindBy(xpath = "//span[text()='Apple iPhone XR (64GB) - Yellow']")
	private WebElement product;
	
	@FindBy(xpath = "//td[text()='Price:']/../td[2]/span[1]")
	private WebElement priceText;
	
	public AmazonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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
		return price;
	}

}
