package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);

        //before looking for that element  we need to jump to that frame
        // selenium needs to enter inner frame (another html document)
        //you can specify: name, id, index, or webelement of the frame
        // it is like we are jumping another layer
        driver.switchTo().frame("mce_0_ifr");

        // now this content will be visible
        WebElement textInput = driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());

        BrowserUtils.wait(4);
        textInput.clear(); // delete the text in frame
        textInput.sendKeys("Hello, World!");


        BrowserUtils.wait(4);

        //exit from the frame
        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        // heading is outside the frame
        System.out.println(heading.getText());

        driver.quit();
    }
}
