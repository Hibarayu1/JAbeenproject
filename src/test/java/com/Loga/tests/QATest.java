package com.Loga.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Loga.Pages.HomePage;
import com.Loga.Pages.LoginIn;
import com.Loga.commons.Configuration;

public class QATest {

	public WebDriver driver = Configuration.browser();
	public HomePage home;
	public LoginIn login;

	public QATest() {
		home = new HomePage();
		login = new LoginIn();
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeAllTestCases() {
		driver.get(Configuration.URL);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void PositiveTest() {
		home.HomeSignin();
		login.Login(Configuration.Email, Configuration.password);
		login.Logout();
	
	}

	@DataProvider(name = "DP1")
	public Object[][] createData() {
		Object[][] retObjArr = { { "jabee@b.com", "computer" }, { "", "computer" },
				{ "jabeen@yahoo.com", "computer" }, };
		return (retObjArr);
	}

	@Test(priority = 2, dataProvider = "DP1")
	public void NegativeTest_Email(String Email, String Password) throws InterruptedException {

		// home.HomeSignin();
		login.Login(Email, Password);
		Thread.sleep(3000);
		// Assert.assertEquals(login.ValidateError(), "An email address required.");
		login.ValidateError();

	}

	@Test(priority = 3)
	public void NegativeTestPassword() {
		System.out.println("negatve password");
	}

	@Test(priority = 4)
	public void ReLogin() {

	login.Login(Configuration.Email, Configuration.password);

	}
	
	@Test(testName = "search Product", priority = 5)
	public void searchProduct() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		//login.Search("dresses","Printed Chiffon Dress");
		login.Search("dresses","http://automationpractice.com/img/p/1/0/10-home_default.jpg");

	}
	
	@Test(priority=6)
	public void Addtocht()
	{
    login.AddtoChart();
	}
	
	@Test(priority=7)
	public void ContinueS()
	{
		login.Continue();
	}
	
	
	@Test(testName = "search Product", priority = 8)
	public void searchProduct1() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		//login.Search("dresses","Printed Chiffon Dress");
		login.Search("dresses","http://automationpractice.com/img/p/1/2/12-home_default.jpg");
		login.AddtoChart();
		login.ProceedCheckout();
		
	}
	@Test(priority=9)
	public void DeleteM()
	{
		login.Deleted();
		
	}
	
	@Test(priority=10)
	public void Proceed1() throws InterruptedException
	{
		login.ProceedtoCheck1();
		Thread.sleep(5000);

		login.Addressbox();
		
	}
	
	@Test(priority=11)
	public void Proceed2() throws InterruptedException
	{
		Thread.sleep(5000);

		login.ProceedtoCheck2();
		Thread.sleep(5000);
		login.Payment();
		Thread.sleep(3000);
		login.Confirmation();
	}
	
}

	

	
	
	
	
	
	
	
	
	
	
	


