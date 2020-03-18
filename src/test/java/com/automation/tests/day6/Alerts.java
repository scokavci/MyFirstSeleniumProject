package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();   // click on the first button
        BrowserUtils.wait(3);
        // once we click how can we switch to alert

        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept(); // to click okay
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //Result:You successfuly clicked an alert
        //it will fail , because there is typo ##BUG##
        System.out.println("TEST #1");
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected : "+expected);
            System.out.println("Actual: "+actual);
        }
        BrowserUtils.wait(3);
        //**********************************************************
        buttons.get(1).click();  // to click on second button
        BrowserUtils.wait(3);

        //to click cancel
        driver.switchTo().alert().dismiss();
        //Result: You clicked: Cancel
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        System.out.println("TEST #2");
        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected : "+expected);
            System.out.println("Actual: "+actual);
        }
        BrowserUtils.wait(3);
        //TASK: CLICK ON BUTTON #3
        //ENTER some text: Hello, World!
        //Verify that result text ends with Hello, World!
        //Alert is interface
        buttons.get(2).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!");
        alert.accept();
        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";
        System.out.println("TEST #3");
        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        }else{
        System.out.println("TEST FAILED");
        System.out.println("Expected : "+expected);
        System.out.println("Actual: "+actual);
    }

        BrowserUtils.wait(3);
        driver.quit();

    }
}
