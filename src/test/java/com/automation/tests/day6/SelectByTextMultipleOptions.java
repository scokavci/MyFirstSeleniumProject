package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(  By.name("Languages")) );
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple); // -->> it's true , you can select more than one option
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        // let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getOptions();
        for(WebElement selectedLanguage : selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtils.wait(3);
        // for testing purpose, if we want to deselect an item
        //we use  .deselectByVisibleText() -->> unselect somthing
        languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(3);

        languagesSelect.deselectAll(); // deselect all



        BrowserUtils.wait(3);
        driver.quit();

    }
}
