package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Base {

public static AppiumDriver<MobileElement> driver;
	 
		
	public void setup() throws MalformedURLException{
		DesiredCapabilities cab= new DesiredCapabilities();
		cab.setCapability("deviceName", "Redmi 6_Pro");
		cab.setCapability("udid", "4c88ce520905");
		cab.setCapability("platformName", "Android");
		cab.setCapability("platformVersion", "9");
		cab.setCapability("automationName", "Appium");
		cab.setCapability("noReset","true");
	
		cab.setCapability("app", "E:\\MUKESH\\Amplify_MobileApp\\App\\General-Store.apk");
		URL url= new URL("http://127.0.0.1:4723/wd/hub");

		driver=new AndroidDriver<MobileElement>(url,cab);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}
