package com.bit.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UnitTest {
	@Test()
	public void test() {
		 //System.out.println(o+"  "+o1);
		 WebDriver dr=new ChromeDriver();
		 Reporter.log("openebd blank browser");
		 dr.get("http://www.facebook.com");
		 Reporter.log("went to url ");
		 dr.findElement(By.id("email")).sendKeys("dfgd");
		 dr.findElement(By.id("pass")).sendKeys("sdfgds");
	}
}
