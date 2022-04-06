package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass
{
    @Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		 
		 Thread.sleep(5000);
		 
		 AddCustomerPage addcust =new AddCustomerPage(driver);
		 logger.info("providing customer details.....");
		 
		 addcust.clickAddNewCustomer();
		 addcust.custName("Ravindra");
		 addcust.custgender("male");
		 addcust.custdob("17", "01", "1988");
		 Thread.sleep(6000);
		 addcust.custaddress("INDIA");
		 addcust.custcity("PUNE");
		 addcust.custstate("MH");
		 addcust.custpinno("411017");
		 addcust.custtelephoneno("8087130856");
		 
		 String email=randomestring()+"@gmail.com";
		 addcust.custemailid(email);
		 addcust.custpassword("abcdf");
		 addcust.custsubmit();
		 
		 Thread.sleep(3000);
		 
		 logger.info("validation is started......");
		 
		 boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		 
		 if(res==true)
		 {
			 Assert.assertTrue(true);
			 logger.info("test case is passed");
		 }
		 else
		 {
			 logger.info("test case is failed");
			 captureScreen(driver,"addNewCustomer");
			 Assert.assertTrue(false);
		 }
	}
}
