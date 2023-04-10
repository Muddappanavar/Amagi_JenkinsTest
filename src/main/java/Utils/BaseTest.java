package Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentTest test;
	
	public void launchApplication() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public boolean waitvisiable(WebDriver driver, WebElement element) {
		boolean isEnable = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isEnable = true;
		}catch (Exception e) {
			isEnable = false;
		}
		return isEnable;
	}
}
