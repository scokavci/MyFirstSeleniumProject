package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        //<input type="radio" id="black" name="color">
        // how I decide: id is unique.
        WebElement blackButton = driver.findElement(By.id("black"));
//        WebElement greenButton = driver.findElement(By.id("green"));
//        if(  greenButton.isDisplayed() && greenButton.isEnabled()) {
//            System.out.println("CLICK ON Green BUTTON");
//            blackButton.click();
//        }else{
//            System.out.println("FAILED TO CLICK ON green BUTTON");
        //}
        // isDisplayed == means visible
        if(  blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("CLICK ON BLACK BUTTON");
            blackButton.click();
        }else{
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }
        BrowserUtils.wait(2);

        //how do we verify that button click
        // returns true, if button clicked
        if( blackButton.isSelected()){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }
      driver.quit();
    }
}
