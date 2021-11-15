# Zooplus Assesment

Mobile Application Auotomation

## Tech stack Used
Java, Cucumber, Appium, Extent Report

## Approach 
Project - Maven Project
Design pattern - Page object model
Framework - Cucumber(For Test approach), Appium Driver(For Mobile UI Automation), Cucumber(For Test Execution ), Extent(For Report)
Language - Java 

## Project Setup 
- Driver capabilities -  /src/main/java/com/zooplus/driverInit/
- Page Obejcts -  /src/main/java/com/zooplus/pageObjects
- APK file location  - /src/main/resources/appfile/
- Test Runner  - /src/test/java/com/zooplus/mobileAppRunner
- Step Definitions - src/test/java/com/zooplus/stepDefinitions
- Feature files - /src/test/resources/FeatureFile
- Extent Report Properties  - /src/test/resources/
- Test Report - /reports

## Prerequisites 
    Mac OS/Linux/Windows
    Android Studio (Emulator should be running already)
    Appium (Should be running already)
    Java 8 and above 
    Install Maven and set the Environment Variable
    Any IDE
    
   
## Steps for Local Execution
- Download and Extract this project to your local or use git clone https://github.com/sarputheen/zooplus_appium_task.git 
- Import as a Maven project in IDE ( Prefered - Eclipse)
- Open the pom.xml in the project
- Right Click inside the pom.xml content
- Hover to "Run As" option
- Click on Run Configuration
- Set Goal as "clean install" and click on the "Run" button

## Steps for CircleCI Execution
- Go to  /src/main/java/com/zooplus/driverInit/DriverInitialization.java file in github and change the line no 35 from "driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);"  to "driver = new AndroidDriver(capabilities);". it will automatically start the execution.
- Go to the latest build and monitor the test execution
- Click on the "Run Tests" to view the test status


## Note:
 - When I tried to execute the test using cirecle CI, its failing during the driver initialization and I have referred many sites for the soultion but nothing wokred. 
 
  To check test build summary - https://app.circleci.com/pipelines/github/sarputheen/zooplus_appium  
  To check rest run build detail -  https://app.circleci.com/pipelines/github/sarputheen/zooplus_appium/6/workflows/36a6d59a-4012-4979-a1d5-dd6f92959a0f/jobs/6
    
 
## Next step of Framework Implementation
- Parallel testing also can be added in this framework using TestNG
- This can be integrated with cirecle CI/Jenkins/Github actions (CI/CD), Browserstack (Compatability/Cloud execution), TestRail/Jira (Test Management Tool)
    
  

















