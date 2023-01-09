package com.app.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Login1 {
	WebDriver driver;
	public Login1(WebDriver driver){
		this.driver=driver;
	}
	public void verifyLogin() throws Exception{
		String rootFolder = System.getProperty("user.dir");
        Properties propObj=new Properties();
        propObj.load(new FileInputStream(rootFolder+ "//src//test//resources//data.properties"));
        String emailId=propObj.getProperty("emailId");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(emailId);
        String password=propObj.getProperty("password");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[.='LOGIN']")).click();
        Thread.sleep(31000);
        driver.findElement(By.xpath("//button[.='LOGIN']")).click();
        Thread.sleep(4000);
        driver.get("https://www.myntra.com/my/profile");
		String actual=driver.findElement(By.xpath("//div[normalize-space()='Ketaki Dhotre']")).getText();
		String expected="Ketaki Dhotre";
		Assert.assertEquals(actual,expected,"Not verified");		
}

}
