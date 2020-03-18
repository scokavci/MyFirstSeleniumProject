package com.automation.myExtraPractice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.etsy.com/");
        WebElement searchItem = driver.findElement(By.id("global-enhancements-search-query"));
        searchItem.sendKeys("knit", Keys.ENTER);

        //*[@id="search-filter-reset-form"]/div[5]/fieldset/div/div/div[1]/a/input

        BrowserUtils.wait(3);
        driver.quit();
    }
}
