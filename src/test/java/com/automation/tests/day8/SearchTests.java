package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;
    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(3);

        // since every search item has a tag name <h3>
        // it is easiest way to collect them all in list

        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem : searchItems){
            String var = searchItem.getText();
            //if there is a text - print it
            if(!var.isEmpty()){
                System.out.println(var);
                // verify that every search result contains java
                //some of search results does not contain java word, it will fail test
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println();
            }
        }
    }

    /**
     * Given user is on the amazon.com page
     * when user enters "java" as a search item
     * then user clicks on search button
     * and user clicks on the first search item
     * and user verifies that title of search item contains "java"
     */
    @Test(description = "Search for Java book on amazon")
    public void amazonsearchTest(){
        driver.get("https://www.amazon.com");
        //there is a chance that item is not visible
        //so we need to maximize window before clicking on it
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(2);

        //find all links inside h2 elements, because h2 element is no clickable itself
        // we use xpath to get another link under h2
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));


        //click on the first item
        for(WebElement searchItem: searchItems){
            System.out.println("Title: "+searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(2);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

        //so h2 elements are not clickable, even though they contain links
        //that's why, instead of collection all h2 elements
        //we collected all hyperlinks
        //every hyperlink represent some search item



    }

    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        // like clean up
        //close browser and destroy webdriver object
        driver.quit();
    }
}
