package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need
        //setup webdriver (browser driver) and create webdriver object
        //WebDriverManager is abstract class
        WebDriverManager.chromedriver().setup();

        // ChromeDriver is class;WebDriver is Interface
        WebDriver driver = new ChromeDriver();  // object creation
        // In selenium , everything starts from WebDriver interface
        // ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");  //to open website
        Thread.sleep(3000);  // for demo, wait 3 seconds
        driver.close(); // to close browser

    }
}
