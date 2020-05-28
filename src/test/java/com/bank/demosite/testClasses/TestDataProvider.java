package com.bank.demosite.testClasses;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bank.demosite.HelperClass.AlertHelper;
import com.bank.demosite.HelperClass.DataProviderClass;
import com.bank.demosite.HelperClass.TextBoxHelper;

public class TestDataProvider extends StartWebDriver {

	@Test(dataProvider = "getLoginData", dataProviderClass = DataProviderClass.class)
	public void testCase(Map<String, Object> data) throws IOException, InterruptedException {

		driver.get("http://www.demo.guru99.com/V4/");
		TextBoxHelper.typeInTestBox("//input[@type='text']", data.get("UserName").toString());
		TextBoxHelper.typeInTestBox("password", data.get("Password").toString());
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		String homePage = "Guru99 Bank Manager HomePage";
		String xpath = null;
		
		if(checkForAlert(driver)){
			AlertHelper.clickOk();
			System.out.println("Invalid UserName");
		}
		
		if (homePage.equalsIgnoreCase(driver.getTitle())) {
			xpath = "//tr[@class='heading3']/td";
			String elementText = driver.findElement(By.xpath(xpath)).getText();
			if (elementText.equalsIgnoreCase("Manger Id : " + data.get("UserName"))) {
				System.out.println("Valid UserName");
				driver.findElement(By.xpath("//a[text()='Log out']")).click();
				AlertHelper.clickOk();
			}
		}
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("ScreenShot\\TestScreenshot.jpg"));

	}
	
	private boolean checkForAlert(WebDriver aDriver){
		try{
			aDriver.switchTo().alert();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
