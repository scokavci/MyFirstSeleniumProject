package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    // xpath allows to specify multiple search criterias
    // in this locator we are looking for element
    // that has a class name and contains text. We use contain due to spaces
    private By fleetBy = By.xpath("//span[@class = 'title title-level-1' and contains(text(), 'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    // private By pageNumberBy = By.cssSelector("input[type='number']");
    private By pagenumberBy = By.xpath("//input[@type='number']");

    @Test
    public void verifyPageSubTitle(){
        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());

        String expected = "All Cars";
        String actual = subTitleElement.getText();
        Assert.assertEquals(actual,expected);
    }
    /**
     *     Given user is on the vytrack landing page
     *     When user logs on as a store manager
     *     Then user navigates to Fleet --> Vehicles
     *     And user verifies that page number is equals to "1"
     */
    @Test
    public void verifyPageNumber(){
        String actual = driver.findElement(pagenumberBy).getAttribute("value");
        String expected = "1";

        Assert.assertEquals(actual,expected,"it's not matching");
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);
        // click on feet
        //  driver.findElement(fleetBy).click();

        // we can do more manipulation with actions instead of click()
        //hover mouse on webelement, click twice,etc..
        //move to element instead of click()
        //Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        // move to element instead of click()
        // moving the mouse basically
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform - to execute command - confirm action

        BrowserUtils.wait(2);
        //click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);

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
