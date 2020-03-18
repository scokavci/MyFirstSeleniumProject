package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create  a webElement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        // pass web element into Select constructor
        Select selectsimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectsimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectsimpleDropdown.selectByVisibleText("Option 1");

        // we can skip assigning to reference variable and pass directly.
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
        // it should be order, year, month, day
        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("25");
        BrowserUtils.wait(3);

        //select all months one by one
        //.getOptions() ->> returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth : months){
            //get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(3);
        }
        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Georgia");

      // we can verify option is correct
        // option that is currently selected
        // getFirstSelectedOption() -->> returns a webelement , that's why we need to call
        //getText() -->> that retrieves visible text from webelement
        // stateSelect is a webelement. to verify we need string so we need to getText()
        String selected = stateSelect.getFirstSelectedOption().getText();
        if(  selected.equals("Georgia") ){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        //option is webelement
        List<WebElement> states = stateSelect.getOptions();
        for(WebElement stateOption : states){
            System.out.println(stateOption.getText());
        }

        BrowserUtils.wait(3);
        driver.quit();


    }
}
