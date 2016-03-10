package NativeApps;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AddaContact {
	
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
		
		//To Add a contact on a real phone
		/*WebElement frameLayout = driver.findElement(By.id("android:id/action_bar_container"));
		List<WebElement> actionTabs = frameLayout.findElements(By.className("android.app.ActionBar$Tab"));
		actionTabs.get(3).click();*/
		
		//To Add a contact in my tablet
		driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
		List<WebElement> editTxt = driver.findElements(By.className("android.widget.EditText"));
		editTxt.get(0).sendKeys("TestName");
		editTxt.get(1).sendKeys("9444423456");
		
		driver.findElement(By.id("com.android.contacts:id/menu_save")).click();
		
		driver.quit();
	}

}
