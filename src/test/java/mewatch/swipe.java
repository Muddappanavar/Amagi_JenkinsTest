package mewatch;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.filpcart.page.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class swipe {
	RemoteWebDriver driver;
	ExtentTest test;
	@Test
	public void jvbfhd() {
		try {
			
			
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.voot.com/");
			Thread.sleep(10000);
			loginPage log = new loginPage(driver, test);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", log.trayContainer);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
