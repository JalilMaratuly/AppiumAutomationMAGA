package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    @Test
    public void calculatorAddTest() throws MalformedURLException, InterruptedException {

        // DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("deviceName", "Pixel33");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel33");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        // Set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");

        // Launch appiumDriver
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);

        // System.out.println(driver.getTitle());
        System.out.println(driver.getDeviceTime());

        Assertions.assertEquals("android", driver.getPlatformName());

        Thread.sleep(4000);

        // Locate AC element on calculator using AccessibilityId("clear")
        MobileElement clearElement = driver.findElement(MobileBy.AccessibilityId("clear"));

        System.out.println("Text of element: " + clearElement.getText());
        Assertions.assertTrue(clearElement.isDisplayed());

        //close the app
        driver.closeApp();
    }
}