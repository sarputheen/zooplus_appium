package com.zooplus.driverInit;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.zooplus.pageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverInitialization {
	public static AndroidDriver driver;
	static File root = new File(System.getProperty("user.dir"));
	static File app = new File(root, "/src/main/resources/appfile/app-mock-debug.apk");
	public static BasePage Base = null;

	@Before
	public static void driverInit() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulator-5556");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("useNewWDA", true);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.android.architecture.blueprints.master.mock");
		capabilities.setCapability("appActivity",
				"com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
		driver = new AndroidDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Base = new BasePage(driver);

	}

	@After
	public static void teardown() {
		driver.quit();

	}

}
