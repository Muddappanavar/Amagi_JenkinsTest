package com.filpcart.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.filpcart.page.SignUpPage;

import Utils.BaseTest;

public class SignInAndClickOnAnyAsset extends BaseTest{
	@Test
	public void launchAndClickAsset() {
		try {
			launchApplication();
			SignUpPage signup = new SignUpPage(driver, test);
			
			try {
				signup.popupCrossButton.click();
			}catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", signup.popupCrossButton);
			}
			Thread.sleep(2000);
			if(!waitvisiable(driver, signup.popupCrossButton)) {
				System.out.println("Successfully deleleted the popup");
			}else {
				System.err.println("Unale to deleleted the popup");
			}
			driver.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
