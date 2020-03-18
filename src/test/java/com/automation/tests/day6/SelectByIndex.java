package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        // index starts from 0
        stateSelect.selectByIndex(9); //District of Columbia

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);

        // if we want to know indexes of all states
        List<WebElement> stateLst = stateSelect.getOptions();
        int count = 0;
        for (WebElement eachState: stateLst) {
            System.out.println( count++ + " = " +eachState.getText());
        }


        BrowserUtils.wait(3);
        driver.quit();

    }
}
