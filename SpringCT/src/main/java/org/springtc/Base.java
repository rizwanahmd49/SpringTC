//package autocomplete.google.base;
package org.springtc;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	String url = "https://www.google.co.in/";
	String urlNukri = "https://www.naukri.com/";
	protected WebDriver driver;

	public void init() {
		InvokeBrowser();
		setUrl(url);
	}

	public void InvokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void setUrl(String url) {
		driver.get(url);
		System.out.println("Application Launched URL: " + url);
	}

	public boolean IsPopwindowAvailable() {
		Set<String> allwin = driver.getWindowHandles();
		if (allwin.size() > 1) {
			System.out.println("There are " + allwin.size() + " windows");
			return true;
		} else {
			return false;
		}

	}
	
	public void click(By by) {
		driver.findElement(by).click();
	}
	
	public String getText(By by) {
		return driver.findElement(by).getText();
	}
}
