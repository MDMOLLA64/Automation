package com.bit.ui.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
  @BeforeMethod(groups="backend")
  public void beforeMethod() {
	  System.out.println("bm");
	  System.out.println("open browser");
  }

  @AfterMethod(groups="backend")
  public void afterMethod(ITestResult r) {
	  switch(r.getStatus())
	  {
	  case ITestResult.FAILURE:
	  {
		  System.out.println("took screen shot");
	  }case ITestResult.SKIP:
	  {
		  System.out.println("method is skipped");
	  }
	  case ITestResult.SUCCESS:
	  {
		  System.out.println("method passed");
	  }
	  }
	  System.out.println("am");
  }


//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
  
  @BeforeClass(groups="ui")
  public void beforeClass() {
	  System.out.println("bc");
	  System.out.println("read property file");
	  System.out.println("finished beforeClass");
	  System.out.println("finished beforeClass");
  }

  @AfterClass(groups="ui")
  public void afterClass() {
	  System.out.println("ac");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("bt");
	  System.out.println("read property file");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("at");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("bs");
	  System.out.println("generate report");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("as");
  }

}
