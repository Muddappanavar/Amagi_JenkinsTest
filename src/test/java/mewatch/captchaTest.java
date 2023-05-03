package mewatch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingConstants;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingOptions;
import com.twocaptcha.TwoCaptcha;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;

public class captchaTest {

	WebDriver driver;
	private SpeechConfig config = SpeechConfig.fromSubscription("6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe", "6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI");

	@Test(enabled = true)
	public void fnvnfv() {
		try {


			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://mewatch.sg/");

			driver.manage().window().maximize();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@aria-label='Modal Message']//button[text()='Skip']")).click();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			System.out.println("Successfully launches the application");
			// not for web
			driver.findElement(By.xpath("//a[not(@class='vertical-nav__sign-in-action')]//button[contains(text(),'Sign In')]")).click();

			driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("automationUser@gmail.com");
			driver.findElement(By.xpath("(//input[@id='password'])[2]")).sendKeys("automation@123");
			driver.findElement(By.xpath("(//button[text()='Sign in' and @type='submit'])[2]")).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes' and starts-with(@src, 'https://www.google.com/recaptcha')]")));
			WebElement audioOptionButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-audio-button")));
			audioOptionButton.click();
			Thread.sleep(5000);

			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes' and starts-with(@src, 'https://www.google.com/recaptcha')]")));
			// Starts continuous recognition. Uses stopContinuousRecognitionAsync() to stop recognition.
			WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rc-audiochallenge-play-button']//button[text()='PLAY']")));
			playButton.click();
			AudioProcessingOptions audio = AudioProcessingOptions.create(AudioProcessingConstants.AUDIO_INPUT_PROCESSING_ENABLE_DEFAULT);
			AudioConfig audioInput = AudioConfig.fromDefaultMicrophoneInput(audio);
			List<String> recognizedSpeechParts = new ArrayList<>();

			SpeechRecognizer recognizer = new SpeechRecognizer(config, audioInput);
			{
				recognizer.recognized.addEventListener((s, e) -> {
					if (e.getResult().getReason() == ResultReason.RecognizedSpeech) {
						recognizedSpeechParts.add(e.getResult().getText());
						System.out.println("RECOGNIZED: Text=" + e.getResult().getText());
					}
					else if (e.getResult().getReason() == ResultReason.NoMatch) {
						System.out.println("NOMATCH: Speech could not be recognized.");
					}
				});

				recognizer.stopContinuousRecognitionAsync().get();
			}
			//		        config.close();
			//		        audioInput.close();
			//		        audio.close();
			//		        recognizer.close();

			WebElement audioResponseInput = driver.findElement(By.id("audio-response"));
			String captchaText = String. join("", recognizedSpeechParts);
			audioResponseInput.sendKeys(captchaText);

			WebElement verifyButton = driver.findElement(By.id("recaptcha-verify-button"));
			verifyButton.click();

			driver.switchTo().defaultContent();
			WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("wpforms-submit-3347")));
			submitButton.click();
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ncjxv() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://mewatch.sg/");

			driver.manage().window().maximize();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@aria-label='Modal Message']//button[text()='Skip']")).click();
			Thread.sleep(2000);
			System.out.println("Successfully launches the application");
			// not for web
			driver.findElement(By.xpath("//a[not(@class='vertical-nav__sign-in-action')]//button[contains(text(),'Sign In')]")).click();

			driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("automationUser@gmail.com");
			driver.findElement(By.xpath("(//input[@id='password'])[2]")).sendKeys("automation@123");
			driver.findElement(By.xpath("(//button[text()='Sign in' and @type='submit'])[2]")).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			
			WebElement image = driver.findElement(By.xpath("//div[@id='rc-imageselect-target']"));
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = "D:\\VidyaWorkpace\\Amagi_JenkinsTest\\ScreenShots\\captcha.png";
			FileUtils.copyFile(src, new File(path));
			Thread.sleep(2000);
			
			System.out.println("Image ocr down");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
