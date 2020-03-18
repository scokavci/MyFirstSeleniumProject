package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
    private WebDriver driver;
    private Actions actions;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String storemanagerUserName = "storemanager57";
    private String getStoremanagerPassword = "UserUser123";

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBy = By.cssSelector("a[title='Log call']");


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        // before you use actions class you have to create driver;otherwise null exception
        actions = new Actions(driver);

        driver.findElement(usernameBy).sendKeys(storemanagerUserName);
        driver.findElement(passwordBy).sendKeys(getStoremanagerPassword, Keys.ENTER);

        BrowserUtils.wait(3);
        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();

        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(4);
    }

    /**
     * Scenario: Verify for store manager
     * Login as story manager
     * Go to Activities --> Calls
     * Verify that Log Call button is displayed
     */
        @Test
        public void verifyLogCallButton(){
            WebElement logcallBtnElement = driver.findElement(logCallBy) ;
            Assert.assertTrue(logcallBtnElement.isDisplayed());
        }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
