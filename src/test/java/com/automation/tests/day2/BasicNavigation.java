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
        // method that return page title
        String title = driver.getTitle();  // returns <title>Some title</title/ text
        String expextedTitle = "Google";

        System.out.println("Title is..."+title);
        if(expextedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
        driver.close(); // to close browser

    }
}
