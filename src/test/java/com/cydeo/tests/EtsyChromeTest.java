package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyChromeTest extends WebTestBase {

    @Test
    public void etsySearchTest() throws InterruptedException {

        driver.get("https://etsy.com");
        Thread.sleep(1000);

        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("gucci shirt" + Keys.ENTER);
        Thread.sleep(1000);

        // Print number of result
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("Gucci shirt: " + result.getText());
    }

    @Test
    public void loginTest() throws InterruptedException {

        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");

        driver.get("https://www.etsy.com");

        WebElement signIn = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]/.."));
        signIn.click();

        WebElement userNameField = driver.findElement(By.name("email"));
        userNameField.sendKeys(email + Keys.ENTER);

        Thread.sleep(3000);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password + Keys.ENTER);
    }
}