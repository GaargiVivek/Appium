package NativeApps;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class MakeCall {
	
public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.google.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
		
		//To click the dialpad tab
		WebElement frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
		WebElement horizontalScrollView = frameLayout.findElement(By.className("android.widget.HorizontalScrollView"));
		List<WebElement> actionTab = horizontalScrollView.findElements(By.className("android.app.ActionBar$Tab"));
		actionTab.get(0).click();
		
		//To dial a number 9711191558
		WebElement linearLayout = driver.findElement(By.id("com.android.contacts:id/dialpad"));
		
		linearLayout.findElement(By.id("com.android.contacts:id/nine")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/seven")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/nine")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/five")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/five")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/eight")).click();
		
		driver.findElement(By.id("com.android.contacts:id/callbutton")).click();
		
		driver.quit();
	}

}
