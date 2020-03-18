package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDown {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);


        driver.findElement(By.id("dropdownMenuLink")).click();  // to expand dropdown

        // no select down it has <a tag which has href link
        // <a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(3);

        // since they have same className, we chose className locator.
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for(WebElement link : allLinks){
            System.out.println(link.getText()+" : "+link.getAttribute("href"));
        }


        driver.findElement(By.linkText("Etsy")).click(); // click an option

        BrowserUtils.wait(3);
        driver.quit();
    }
}
