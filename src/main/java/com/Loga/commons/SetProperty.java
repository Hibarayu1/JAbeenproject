package com.Loga.commons;




import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class SetProperty  {
	@Test
  public static void main(String[] args) {
	
	Properties prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream("C:\\Users\\meraj\\Desktop\\dummymaven\\MavenLogaProject\\src\\test\\Resources\\QA-environment.properties");

		// set the properties value
		prop.setProperty("Email", "jabeenhashmi@ymail.com");
		prop.setProperty("Password", "computer");
		prop.setProperty("Browser", "chrome");
		prop.setProperty("date", "Dec22");
		prop.setProperty("URL", "http://automationpractice.com/index.php");
		prop.setProperty("EnvType", "dev");

		// save properties to project root folder
		prop.store(output, null);
		
		output = new FileOutputStream("C:\\Users\\meraj\\Desktop\\dummymaven\\MavenLogaProject\\src\\test\\Resources\\dev-environment.properties");

		// set the properties value
		prop.setProperty("Email", "jabeenhas@ymail.com");
		prop.setProperty("Password", "computer");
		prop.setProperty("URL", "http://automationpractice.com/index.php");
		prop.setProperty("Browser", "chrome");
		prop.setProperty("EnvType", "dev");
		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	System.out.println("Hello World");
  }

}

