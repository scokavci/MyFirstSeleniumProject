package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// STATIC IMPORT OF ALL ASSERTIONS
// WE IMPORT ALL STATIC METHODS IN ASSERT CLASS
// WHEN WE CALL METHODS, WE DON'T NEED TO WRITE CLASS ASSERT
//WE CALL STATIC WAY DIRECTLY
import static org.testng.Assert.*;

public class LogInPageTests {
    private WebDriver driver;
    //https is  secured version of http protocol
    //https - data encrypted, no chance for hackers to retrieve info
    //http - it's hybertext transfer protocol that every single website is using nowadays
    //http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";
    //CREDENTIALS FOR STORE MANAGER
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    //By is class, we can use as a data type.
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");
    //private By warningMessageBy = By.xpath("//div[text()='Invalid user name or password.']");

    @Test(description ="verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);
    }
    @Test(description= "Login as store manager and verify that title equals to Dashboard")
    public void loginAsStoreManager(){
            driver.findElement(usernameBy).sendKeys(username);
            driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
            BrowserUtils.wait(5);
            String expected = "Dashboard";
            String actual = driver.getTitle();
            assertEquals(actual, expected, "Page title is not correct!");
        // debugging purpose put in order =  actual first then expected later.
        // this message shows up assertion fails
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        //if webdriver object alive
        if(driver != null){
            //close browser, close session
           driver.quit();
           //destroy webdriver object for sure
           driver = null;
        }
    }

}
