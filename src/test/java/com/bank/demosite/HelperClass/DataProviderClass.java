package com.bank.demosite.HelperClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="getLoginData")
	public static Object[][] getloginData() throws IOException{
		return ReadExcelFile.getExcelData("banklogindetails.xlsx", "sheet1");
 }
}
