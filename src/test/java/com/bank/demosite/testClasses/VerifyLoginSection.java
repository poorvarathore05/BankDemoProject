package com.bank.demosite.testClasses;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginSection extends StartWebDriver{
	
	
	@Test
	public void login(){
		
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr262271");
		driver.findElement(By.name("password")).sendKeys("ydavuza");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//System.out.println("Title :" +driver.getTitle());
		Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}

}
