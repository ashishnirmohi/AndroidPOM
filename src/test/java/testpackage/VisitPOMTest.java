package testpackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import pagepackage.FirstPage;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class VisitPOMTest {
	private AndroidDriver driver;
	private FirstPage FirstPage1;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		File js = new File("C:\\Users\\LENOVO\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(js).withIPAddress("0.0.0.0")
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").usingPort(4723).withTimeout(Duration.ofSeconds(10))
				.build();
		service.start();
		System.out.println("Appium Server Started at: " + service.getUrl());
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "LAVA LZX414");
		caps.setCapability("udid", "LAO2EY24GB023454");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "13"); // e.g., "11.0"
		caps.setCapability("appPackage", "io.appium.android.apis");
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("app", "\\Users\\LENOVO\\OneDrive\\Documents\\APKFile\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), caps);
		System.out.println("Application started");
		FirstPage1 = new FirstPage(driver);
	}

	@Test
	public void testLogin() {
		FirstPage1.visitPage();
	}

	@AfterClass
	public void tearDown() {
		// Quit the driver
		if (driver != null) {
			driver.quit();
		}
	}
}