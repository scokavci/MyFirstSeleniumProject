package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need
        //setup webdriver (browser driver) and create webdriver object
        //WebDriverManager is abstract class
        WebDriverManager.chromedriver().version("79.0").setup();
       // WebDriverManager.chromedriver().setup(); // so many line errors

        // ChromeDriver is class;WebDriver is Interface
        WebDriver driver = new ChromeDriver();  // object creation
        // In selenium , everything starts from WebDriver interface
        // ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");  //to open website
        driver.manage().window().maximize(); // to maximize browser

      //  driver.manage().window().fullscreen(); // JUST DEMO: we usually don't use it

        Thread.sleep(3000);  // for demo, wait 3 seconds
        // method that return page title
        String title = driver.getTitle();  // returns <title>Some title</title/ text
        String expectedTitle = "Google";
        //to get URL
        System.out.println("URL: "+driver.getCurrentUrl());

        System.out.println("Title is..."+title);
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
        // go to another website within same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);  // for demo, wait 3 seconds

        if(driver.getTitle().toLowerCase().contains("amazon") ){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
        //comeback to google
        driver.navigate().back();
        Thread.sleep(3000);  // for demo, wait 3 seconds

        verifyEquals(driver.getTitle(),"Google");

        //move forward in the browser history
        // again , going to amazon
        driver.navigate().forward();
        Thread.sleep(3000);  // for demo, wait 3 seconds
        System.out.println("Title: "+ driver.getTitle());

        driver.navigate().refresh();  // to reload page
        Thread.sleep(3000);  // for demo, wait 3 seconds

        //must be at the end
        driver.close(); // to close browser ;close 1 particular current window
    }
    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
        }
    }

