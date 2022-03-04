package com.cydeo.tests.homeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.etsy.com");

    }
    @Test
    public void test(){
        WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
       // searchBoxElement.sendKeys("earrings"+ Keys.ENTER);

        WebElement searchAnythingElement = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));

        String expectedResult= "Search for anything";
        String actualResult= searchAnythingElement.getAttribute("placeholder");

        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void test1SignIn(){
        WebElement signInElement = driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));

        String expectedResultSign="Sign in";
        String actualResultSign=signInElement.getText();

        Assert.assertEquals(actualResultSign,expectedResultSign);
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

