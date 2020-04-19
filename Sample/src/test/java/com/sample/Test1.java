package com.sample;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test1 {

	@Parameters({"browser"})
	@Test(invocationCount=5, threadPoolSize=5)
	public void test(String browser){
		// TODO Auto-generated method stub
		Date d= new Date();
		System.out.print(browser+"----"+d+"----"+"I am Super Hero \n");
	}

}
