package com.app.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.AddItem;

import com.app.pages.Login1;

public class myTests {
	
	static WebDriver driver;
	static Login1 login;
	static AddItem add;
	
	@BeforeMethod
	public void setup() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		add = new AddItem(driver);
		login = new Login1(driver);

		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/login/password");
	}

	@Test
	public void verifyLogin() throws Exception {
		login.verifyLogin();
	}

	@Test
	public void AddItem() throws Exception {
		add.addItem();
		add.verifyBag();
		add.addBag();
		add.verifyAdd();
	}

}
