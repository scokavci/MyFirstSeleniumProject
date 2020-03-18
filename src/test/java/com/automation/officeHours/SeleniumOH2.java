package com.automation.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumOH2 {
    public static void main(String[] args) {
        /*
            1. Go to http://automationpractice.com
            2. Search for 'tshirt' in a searchbox + click enter OR click search button
            3. validate you got 'no results' message on UI
            4. Search for 't-shirt'
            5. Validate there was 1 result found
         */

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://automationpractice.com");
        WebElement search_box= driver.findElement(By.id("search_query_top"));
        //WebElement - interface in selenium/java and it has many useful methods
        //.sendKeys("value that we want to send - input tag ")
        search_box.sendKeys("tshirt"+ Keys.ENTER);

        BrowserUtils.wait(3);
//        <p class="alert alert-warning">
//                No results were found for your search&nbsp;"tshirt"
//                </p>

        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        //.getText() -> returns String (text) from the element
        String errorText = error.getText();
        System.out.println("Error message: "+ errorText);

        //NoSuchElementException - it means we could not locate the element. if element is not found
        // we need to find element again

        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        //.clear() - (void) it will delete any values from input box

        BrowserUtils.wait(2);
        search_box.sendKeys("t-shirt"+ Keys.ENTER);
        //StaleElementReferenceException - element is old/stale - we want to find
        //this element again OR refresh page
        BrowserUtils.wait(3);


        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: "+count.getText());

        WebElement addToChart = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
        addToChart.click();

        driver.quit();

    }
}
