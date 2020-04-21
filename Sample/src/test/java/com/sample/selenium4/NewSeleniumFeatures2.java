package com.sample.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import com.sample.base.Base;

public class NewSeleniumFeatures2 extends Base {
	
	@Test
	public void relativeLocators()
	{
		driver.get("https://automationbookstore.dev/");
		
		//Find 3rd Element i.e. Agile Testing.
		WebElement agileTesting = driver.findElement(RelativeLocator.withTagName("li").above(By.id("pid7")).toLeftOf(By.id("pid4")).toRightOf(By.id("pid2")));
		
		String id=agileTesting.getAttribute("id");
		System.out.println(id);
	}
	

}
