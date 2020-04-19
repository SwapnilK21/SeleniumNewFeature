package com.sample.selenium4;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import com.sample.base.Base;

public class NewSeleniumFeatures extends Base {

	@Test(priority=1)
	public void seleniumScreenShot() throws IOException {
		
		System.out.println(driver.getTitle());
		WebElement logo= driver.findElement(By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='main']/span[@id='body']/center/div[@id='lga']/div[@id='hplogo']/a/img[1]"));
		
		File srcFile=logo.getScreenshotAs(OutputType.FILE);
		File destFile= new File("logo.png");
		FileUtils.copyFile(srcFile, destFile);

	}
	
	@Test(priority=2)
	public void newTab() {
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.msn.com");
		System.out.println(driver.getTitle());
		
	}

	@Test(priority=3)
	public void newWindow() {
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://www.yahoo.com");
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=4)
	public void locationOfElement()
	{
		driver.get("http://www.bing.com");
		WebElement logo=driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M10 38.642')]"));
		System.out.println(driver.getTitle());
		
		System.out.println("Size : "+logo.getSize());
		
		System.out.println("Height : "+logo.getRect().getDimension().getHeight());
		System.out.println("Width : "+logo.getRect().getDimension().getWidth());
		
		System.out.println("X Location : "+logo.getRect().getX());
		System.out.println("Y Location : "+logo.getRect().getY());
		
	}
}
