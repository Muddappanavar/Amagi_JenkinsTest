package com.filpcart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupFunctionalityTest {
	WebDriver driver;
	
	@Test
	public void signUpValidation() throws InterruptedException {
		try {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		System.out.println("Successfully launches the application");
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unsuccessfully launches the application");
		} 
		driver.close();
	}
}
