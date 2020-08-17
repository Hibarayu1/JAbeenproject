package com.Loga.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Loga.commons.Configuration;

public class HomePage {

public WebDriver driver=Configuration.browser();

@FindBy(xpath = "//a[@class='login']")
public WebElement loginLink;

public HomePage() {
	PageFactory.initElements(driver, this);
}

public void HomeSignin()
{
	loginLink.click();
	System.out.println("Sign in button is clicked");
}

}
