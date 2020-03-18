package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);
        //how to collect all links from the page?
        // every link has <a tag name
        List<WebElement> links =  driver.findElements(By.tagName("a"));

        for(WebElement link : links){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
        }
        for (int i = 1; i <links.size() ; i++) {  // skipped first link because it is home
            links.get(i).click();
            driver.navigate().back();
            links = driver.findElements(By.tagName("a"));
        }
        driver.quit();
    }
}
