package com.herokuapp.theinternet;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() throws MalformedURLException {
		System.out.println("starting login test");
		//create driver
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//WebDriver driver =new RemoteWebDriver(new URL("http://192.168.29.219:4444/wd/hub"),DesiredCapabilities.chrome());
		
		//sleep for 3 sec
		Sleep(3000);
		
		String url="https://the-internet.herokuapp.com/login";
		
		//open test page
		driver.get(url);
		System.out.println("page is opened");
		
		//sleep for 3 sec
		Sleep(3000);
		
		
		//maximise the browser window
		driver.manage().window().maximize();
		//enter username
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		Sleep(1500);
		
		//enter pasword
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		Sleep(3000);
		//click the button
		WebElement loginButton=driver.findElement(By.tagName("button"));
		loginButton.click();
		Sleep(5000);
		
		//verifications
		String expectedurl="https://the-internet.herokuapp.com/secure";
		//String expectedurl="https://the-internet.herokuapp.com/secure-broken";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedurl,"Actual page url is not same as expected");
		//new url
		
		//logout button is visible
		WebElement logoutButton=driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logoutButton.isDisplayed(),"Log Out Button is not visible");
		//successful login message
		//WebElement successMessage=driver.findElement(By.cssSelector("#flash"));
		WebElement successMessage=driver.findElement(By.xpath("//div[@id='flash']"));
	    String expectedMessage="You logged into a secure area";
	    String actualMessage=successMessage.getText();
	    //Assert.assertEquals(actualMessage, expectedMessage,"Actual Message is not the same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\n Actual Message:"+actualMessage+
				"\nExpected Message:"+expectedMessage);
		//close browser
		driver.quit();
	}

	private void Sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
	}
	
}
