package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private By firstnameBy = By.name("firstname");
    private By lastnameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    //languages  // input and label next to each other
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascript = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signUp = By.id("wooden_spoon");


    @Test
    public void test1(){
     driver.findElement(firstnameBy).sendKeys("Patrick");
     driver.findElement(lastnameBy).sendKeys("White");
     driver.findElement(usernameBy).sendKeys("testuser");
     driver.findElement(emailBy).sendKeys("test@email.com");
     driver.findElement(passwordBy).sendKeys("12345678");
     driver.findElement(phoneBy).sendKeys("234-123-1231");

     driver.findElement(femaleBy).click();

     driver.findElement(dateOfBirthBy).sendKeys("12/13/1945");

     Select departmentSelect = new Select(driver.findElement(departmentBy)) ;
     departmentSelect.selectByVisibleText("Department of Agriculture");

     Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
     jobTitleSelect.selectByVisibleText("SDET");

     driver.findElement(javaBy).click();
     driver.findElement(signUp).click();

     BrowserUtils.wait(5);

     String expected = "You've successfully completed registration!";
     String actual = driver.findElement(By.tagName("p")).getText();
     BrowserUtils.wait(3);
        Assert.assertEquals(actual,expected,"it's not matching");

    }
    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstnameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningmessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningmessage.isDisplayed());  // message is visible
    }
    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstnameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningmessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningmessage.isDisplayed());
    }


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
