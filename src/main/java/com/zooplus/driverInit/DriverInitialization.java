package com.zooplus.driverInit;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.zooplus.pageObjects.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverInitialization {
	public static RemoteWebDriver driver;
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder builder;
	static File root = new File(System.getProperty("user.dir"));
	static File app = new File(root, "/src/main/resources/appfile/app-mock-debug.apk");

	public static String androidHome = "/Users/sarputheen/Library/Android/sdk";
	public static String javaHome = "/Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home";

	public static String adbHome = androidHome+"/platform-tools/";
	
	
	
	public static BasePage Base = null;
	@Before
	public static void driverInit() throws MalformedURLException {
		Map<String, String> environment = new HashMap<String, String>();
		environment.put("ANDROID_HOME",androidHome);
		environment.put("JAVA_HOME",javaHome);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5556");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("noReset", false);
		
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);
		capabilities.setCapability("autoGrantPermissions", true);
//		capabilities.setCapability("useNewWDA", true);
		capabilities.setCapability("app", app.getAbsolutePath());
//		capabilities.setCapability("skipDeviceInitialization", true);
//		capabilities.setCapability("skipServerInstallation", true);
//		capabilities.setCapability("app", System.getProperty("user.dir")+"/src/main/resources/appfile/app-mock-debug.apk");
		capabilities.setCapability("appPackage", "com.example.android.architecture.blueprints.master.mock");
		capabilities.setCapability("appActivity", "com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		


		Base = new BasePage(driver);
		
	}
	public static void unInstallappiumSettings() {
		String cmd = adbHome+"adb shell getprop ro.build.version.release";

		String osVersion=executeCommand(cmd);
		System.out.println("Android version: " + osVersion);
		    if(osVersion.contains("7"))
		    {
		        //uninstall io.appium.settings
		        cmd=adbHome+"adb uninstall  io.appium.settings";
		        executeCommand(cmd);

		        //uninstall io.appium.unlock
		        cmd=adbHome+"adb uninstall  io.appium.unlock";
		        executeCommand(cmd);

		    }
	}
	
	public static String executeCommand(String cmd)
	{
	    String commandresponse="";
	    try
	    {	
	    	
	        Runtime run = Runtime.getRuntime();
	        Process proc=run.exec(cmd);
	        BufferedReader stdInput = new BufferedReader(new 
	                InputStreamReader(proc.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new 
	                InputStreamReader(proc.getErrorStream()));

	        String response=null;
	        while ((response = stdInput.readLine()) != null) 
	        {
	            if(response.length()>0)
	            {
	                commandresponse=commandresponse+response;
	            }
	        }

	        while ((response = stdError.readLine()) != null) 
	        {
	            commandresponse=commandresponse+response;

	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    //System.out.println(commandresponse);
	    return commandresponse;
	}
	
	
	@After
	public static void teardown() {
		driver.quit();
		
	}
	
	
	
}
