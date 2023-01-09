package com.app.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddItem {
	WebDriver driver;

	public AddItem(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void addItem() throws Exception {
		// TODO Auto-generated method stub
		driver.findElement(By.id("mobileNumberPass")).sendKeys("ketakidhotre3@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input"))
				.sendKeys("Ketaki@2272");
		driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
		Thread.sleep(34000);
		driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
	}

	public void verifyBag() throws Exception
	{
		driver.findElement(By.xpath("//span[contains(text(),\"Bag\")] ")).click();
		WebElement NoItemMsg=driver.findElement(By.xpath("//div[contains(text(),\"There is nothing in your bag. Let's add some items.\")]"));
		String ActualMsg=NoItemMsg.getText();
		String ExpectedMsg="There is nothing in your bag. Let's add some items.";
		Assert.assertEquals(ActualMsg, ExpectedMsg,"There is an Item in the Cart");
		Thread.sleep(3000);
	}

	public void addBag() throws InterruptedException
	{
		 driver.findElement(By.xpath("//a[@class=\"linkClean\"]")).click();
	     driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("Redmi",Keys.ENTER);
	     Thread.sleep(10000);
	     driver.findElement(By.xpath("//img[@title=\"DressBerry Lavender Textured Structured Mobile Pouch\"]")).click();
	     Thread.sleep(5000);

	     ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	     //switch to new tab
	     driver.switchTo().window(newTb.get(1));
	     driver.findElement(By.xpath("//div[contains(text(),\"ADD TO BAG\")]")).click();
	}

	public void verifyAdd() throws Exception
	{
		driver.findElement(By.xpath("//span[contains(text(),\"Bag\")] ")).click();
		Thread.sleep(4000);
        WebElement AddtoCart=driver.findElement(By.xpath("//div[contains(text(),\"1/1 ITEMS SELECTED\")]"));
        String MsgActual=AddtoCart.getText();
        String MsgExpected="1/1 ITEMS SELECTED";
        Assert.assertEquals(MsgActual, MsgExpected,"The item is Not Added");
	}

}


