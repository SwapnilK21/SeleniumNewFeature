package com.sample.selenium4;

import java.util.Optional;

import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.devtools.security.Security;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sample.base.Base;

public class NewSeleniumFeatures3 extends Base {
	
	static DevTools devTools;
	
	@BeforeTest
	public void devToolsSetIp() {
		
		devTools=((ChromiumDriver) driver).getDevTools();
		
		devTools.createSession();
	}
	
	@Test(priority=1)
	public void networkOffline() throws InterruptedException {
		
		devTools.send(Network.enable(Optional.of(2000000), Optional.empty(), Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(true,100,1000,2000,Optional.of(ConnectionType.WIFI)));
		
		driver.get("http://www.google.com");

	}

	@Test(priority=2)
	public void networkOnline() throws InterruptedException {
		
		devTools.send(Network.enable(Optional.of(2000000), Optional.empty(), Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(false,100,1000,2000,Optional.of(ConnectionType.WIFI)));
		
		driver.get("http://www.google.com");

	}
	
	@AfterTest
	public void devToolsTearDown() {
		
		devTools.close();
	}
	
	@Test(priority=3)
	public void consolLog() {
		
		devTools.send(Log.enable());
		
		devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.toString()));
		driver.get("http://www.google.com");
	}
	
	@Test(priority=4)
	public void insecureWebsite() {
		
		devTools.send(Security.setIgnoreCertificateErrors(true));
		
		driver.get("https://expired.badssl.com");
	}
}
