package testpackage;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class FirstTC_LAVA {

	public static AndroidDriver driver;

	public static void main(String[] args) throws Exception {
		File js = new File("C:\\Users\\LENOVO\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(js).withIPAddress("0.0.0.0")
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").usingPort(4723).withTimeout(Duration.ofSeconds(10))
				.build();
		service.start();
		System.out.println("Appium Server Started at: " + service.getUrl());
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "LAVA LZX414");

		// Set the UDID (Unique Device Identifier of your device)
		caps.setCapability("udid", "LAO2EY24GB023454"); // adb devices
		caps.setCapability("automationName", "uiautomator2");
		// Set the platform name
		caps.setCapability("platformName", "Android");

		// Set the platform version of your Android device
		caps.setCapability("platformVersion", "13"); // e.g., "11.0"

		// Set the app package (You can get this by using "adb shell pm list packages"
		// command)
		caps.setCapability("appPackage", "io.appium.android.apis");
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		// Set the automation name to UiAutomator2 (recommended for Android)
		caps.setCapability("automationName", "UiAutomator2");
		// Optional: If your app is already installed on the device
		
		caps.setCapability("app", "\\Users\\LENOVO\\OneDrive\\Documents\\APKFile\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), caps);
		System.out.println("Application started");

	}
}
