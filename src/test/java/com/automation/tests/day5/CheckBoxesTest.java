package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));

        //TASK
        //Verify that 1st checkbox is not selected and 2nd is selected

         if(!checkboxes.get(0).isSelected() && checkboxes.get(1).isSelected()){
                 System.out.println("TEST PASSED");
         }else{
                 System.out.println("Second Check box is selected");
         }

         //let's click on the first checkbox and verify it's clicked

        //checkboxes.get(0).click();
        // or you can assign to variable
        WebElement checkbox1 = checkboxes.get(0);
        checkbox1.click();

        BrowserUtils.wait(2);
        if(checkbox1.isSelected()){
            System.out.println("TEST PASSED");
            System.out.println("checkbox #1 is selected");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("checkbox #1 is not selected");
        }
        driver.quit();
    }
}
