package com.bit.ui.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class log4jPractice {
	
	Logger log=Logger.getLogger(log4jPractice.class);
	@Test
	public void test1() {
		DOMConfigurator.configure("log4j.xml");
		log.fatal("fatal");
		log.error("error");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		log.trace("race");
	}
	WebDriver driver;
	WebElement ele;
	@Test
	public void windowHandle() {
		Actions a=new Actions(driver);
		String  pwin=driver.getWindowHandle();
		a.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Set<String> cwin=driver.getWindowHandles();
		
		for(String win:cwin)
		{
			if(!win.equals("pwin"))
			{
				driver.switchTo().window(win);
			}
		}
		
	}
	
	@Test
	public void screenshot() throws IOException
	{
		int num=(int)(Math.random()*1000)+1;
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("/Users/bittech/shot"+num+".png"));
		

	}
	WebElement ele1;
	@Test
	public void dragAndDrop() throws IOException
	{
		driver.switchTo().frame(0);
		driver.switchTo().frame("name");
		driver.switchTo().frame(ele);
		
		List<WebElement>  elements=driver.findElements(By.tagName("iframe"));
		for(WebElement ele:elements)
		{
			if(ele.getAttribute("name").equals("expected"))
			{
				driver.switchTo().frame("expected");
			}
		}
		
		
		
		
		
		
		
		Actions a=new Actions(driver);
		a.dragAndDrop(ele, ele1).build().perform();
		a.dragAndDropBy(ele, 0, 200).build().perform();
		
	}
	
	@Test
	public void alertHandle()
	{
		Alert a=driver.switchTo().alert();
		a.accept();
		a.dismiss();
		a.sendKeys("jgj");
		a.getText();
		
	}
	
	@Test
	public void handleCookie()
	{
		
		Set<Cookie> cookies=driver.manage().getCookies();
		String [] values=new String[cookies.size()];
		int i=0;
		for(Cookie cookie :cookies)
		{
			String value=cookie.getValue();
			values[i]=value;
			i++;
			
//			if(cookie.getValue().equals("exValue"))
//			{
//				cookie.validate();
//			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
