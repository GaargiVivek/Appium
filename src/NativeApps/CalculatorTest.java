package NativeApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
	
	public static AndroidDriver driver;
	public WebElement frameLayout;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
		
		frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
		
		
		
	}
	
	@Test(priority = 1)
	public void add()
	{
		
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_add")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "12");
	}
	
	@Test(priority = 2)
	public void sub()
	{
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_sub")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "2");
		
	}
	
	@Test(priority = 3)
	public void mult()
	{
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "35");
		
	}
	
	@Test(priority = 4)
	public void divide()
	{
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_div")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "4");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
