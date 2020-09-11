package com.db;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseListner implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestName()+ " is started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestName()+ " is succed");
	}

	public void onTestFailure(ITestResult r) {
		// TODO Auto-generated method stub
		System.out.println(r.getTestName()+ " is failed");
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
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+ " is starting");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+ " is finish");
	}

}
