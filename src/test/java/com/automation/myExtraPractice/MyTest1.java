package com.automation.myExtraPractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest1 {
    //http://automationpractice.com/index.php
// 1. Click on t-shirt.
//2. List all of the sizes then select size M.
//3. Verify that orange color selectable. Then click orange color
//4. select one of the t-shirt and add to cart.
//5. verify that you got the same message (Product successfully added to your shopping cart)
        public static void main(String[] args) {
            WebDriverManager.chromedriver().version("79").setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationpractice.com/index.php");
            WebElement tshirtBox = driver.findElement(By.xpath("//a[@title='T-shirts']"));
            tshirtBox.click();

//         BrowserUtils.wait(2);
//         driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_2']"));

         BrowserUtils.wait(3);
         driver.quit();


        }
    }

