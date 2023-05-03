package com.filpcart.page;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;


public class loginPage {
	public RemoteWebDriver driver;
	public ExtentTest test;
	
	public loginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	@FindBy(xpath = "(//div[@class='slick-track'])[5]")
	public WebElement trayContainer;

	public void swipright(RemoteWebDriver driver) {
		int startx = 0, starty = 0, endx = 0;
		try {
			Dimension size = driver.manage().window().getSize();
			startx = (int) (size.getWidth() * 0.09);
			starty = (int) (size.getHeight() / 2);
			endx  = (int) (size.getWidth() * 0.05);
//			TouchAction act = new TouchAction((PerformsTouchActions) driver);
//			act
//            .press(startx, starty)
//            .waitAction(Duration.ofMillis(200))
//            .moveTo(endx, starty)
//            .release()
//            .perform();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
