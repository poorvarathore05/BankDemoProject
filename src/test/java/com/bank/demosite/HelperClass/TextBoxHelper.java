package com.bank.demosite.HelperClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bank.demosite.testClasses.StartWebDriver;

public class TextBoxHelper extends StartWebDriver {
	
	public static void typeInTestBox(By locator,String value){
		
		WebElement element = getElement(locator);
		element.sendKeys(value);
	}

	public static void typeInTestBox(String locator, String value) {
		WebElement element = getElement(locator);
		element.sendKeys(value);
		
	}

}
