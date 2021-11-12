package com.zooplus.mobileAppRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFile",
        glue = {"classpath:com.zooplus.stepDefinitions", "classpath:com.zooplus.driverInit"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@automated"
        
)
public class TestRunner {

		
	
}
