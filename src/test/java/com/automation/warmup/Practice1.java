package com.automation.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice1 {
    static WebDriver driver;

    public static void main(String[] args) {
        // ebayTest();
      amazonTest();

    }

    public static void ebayTest() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();

        WebElement results = driver.findElement(By.tagName("h1"));
        System.out.println(results.getText().split(" ")[0]);
        driver.quit();

    }

    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazonTest() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();  // https://www.amazon.com/s?k=java+book&ref=nb_sb_noss_1
        if (title.contains("java book")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
        driver.quit();
    }
}