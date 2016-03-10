package NativeApps;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SendSMS {
	
	public static AndroidDriver driver;

	
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.mms");
		capabilities.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
		
		//To click on the messaging tab
		WebElement actionBar = driver.findElement(By.id("android:id/action_bar"));
		List<WebElement> textView = actionBar.findElements(By.className("android.widget.TextView"));
		//System.out.println(textView.size());
		textView.get(1).click();
		
		//to write A message and send it
		driver.findElement(By.id("com.android.mms:id/recipients_editor_to")).sendKeys("9711117891");
		driver.findElement(By.id("com.android.mms:id/mms_rich_composer_linear")).sendKeys("Hi");
		driver.findElement(By.id("")).click();
		
		
		driver.quit();
	}

}
