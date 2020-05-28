package com.bank.demosite.testClasses;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartWebDriver {

	protected static WebDriver driver = null;
	@BeforeSuite
	public void setup(){
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public static WebElement getElement(By locator){
		if((driver.findElements(locator)).size()==1){
			return driver.findElement(locator);
		}else
			throw new NoSuchElementException();
	}
	
	public static WebElement getElement(String locator){
		boolean isXpath = false;
		if(locator.contains("/"))
			isXpath = true;
	    if(driver.findElements(By.id(locator)).size()==1){
	    	return driver.findElement(By.id(locator));
	    }else if(driver.findElements(By.className(locator)).size()==1){
	    	return driver.findElement(By.className(locator));
	    }else if(!isXpath && driver.findElements(By.cssSelector(locator)).size()==1){
	    	return driver.findElement(By.cssSelector(locator));
	    }else if(isXpath && driver.findElements(By.xpath(locator)).size()==1){
	    	return driver.findElement(By.xpath(locator));
	    }else if(driver.findElements(By.name(locator)).size()==1){
	    	return driver.findElement(By.name(locator));
	    }else
	    	throw new NoSuchElementException();
		
		
	}
	
	@AfterSuite(alwaysRun=true)
    public void tearDown(){
		if(driver!=null){
			driver.quit();
		}
    	
    	
    }
}
