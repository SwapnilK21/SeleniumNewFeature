package com.sample.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.hp.com/us-en/shop");
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
	}

}
