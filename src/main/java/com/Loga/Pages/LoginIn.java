package com.Loga.Pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Loga.commons.Configuration;

public class LoginIn {

	public WebDriver driver = Configuration.browser();

	@FindBy(xpath = "//input[@id='email']")
	public WebElement EmailTextBox;

	@FindBy(xpath = "//input[@name='passwd']")
	public WebElement passwordTextBx;

	@FindBy(id = "SubmitLogin")
	public WebElement SubmitBtn;

	@FindBy(xpath = "//a[@class='logout']")
	public WebElement logout;

	@FindBy(xpath = "//div[@class='alert alert-danger']//li")
	public WebElement ErrorMessage;

	@FindBy(id = "search_query_top")
	public WebElement Searchtextbox;

	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement Searchbtn;

	@FindBy(xpath = "//div[(@class='clearfix']//span[@title='Continue shopping']")
	public WebElement ContinueshopBtn;

	public LoginIn() {
		PageFactory.initElements(driver, this);
	}

	public void Login(String Email, String Password) {
		EmailTextBox.clear();
		EmailTextBox.sendKeys(Email);
		passwordTextBx.clear();
		passwordTextBx.sendKeys(Password);

		SubmitBtn.click();
		System.out.println("signin successfully");
	}

	public void Logout() {
		logout.click();

	}

	public void ValidateError() {
		Assert.assertEquals(ErrorMessage.getText(), "An email address required.");
		System.out.println(ErrorMessage.getText());

	}

	// public void Search(String SearchProd,String classname,String Product)
	public void Search(String SearchProd, String Imgsrc)

	{
		Searchtextbox.clear();
		Searchtextbox.sendKeys(SearchProd);

		Searchbtn.click();
		driver.findElement(By.xpath("//img[@src='" + Imgsrc + "']")).click();
		
	}

	public void AddtoChart() {
		WebElement e = driver.findElement(By.className("fancybox-iframe"));
		driver.switchTo().frame(e);
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		//driver.switchTo().defaultContent();

	}

	public void Continue() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")));
		
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
		driver.switchTo().defaultContent();

	}

	public void ProceedCheckout() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		driver.switchTo().defaultContent();

	}
	
	public void Deleted()
	{
		driver.findElement(By.xpath("//*[@id=\"4_16_0_131010\"]")).click();
	}
	
	public void ProceedtoCheck1()
	{
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		
	}
	public void Addressbox()
	{
		
		driver.findElement(By.xpath("//input[@id='addressesAreEquals']")).click();
	}
	
	public void ProceedtoCheck2() 
	{
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		
		driver.findElement(By.xpath("//input[@name='cgv']")).click();
       driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
	}
	
	public void Payment()
	{
		driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
	}
	public void Confirmation()
	{ 
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
		
	}
	}
	
	

