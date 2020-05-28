package com.bank.demosite.HelperClass;

import org.openqa.selenium.Alert;

import com.bank.demosite.testClasses.StartWebDriver;

public class AlertHelper extends StartWebDriver{
	
	public static Alert alert = null;	

	 public static void clickOk(){
		 alert = driver.switchTo().alert();
		 alert.accept();
		 
	 } 
	 
	 public static void cancel(){
		 alert = driver.switchTo().alert();
		 alert.dismiss();
	 }
}
