package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_SelectState_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

//        TC #5: Selecting state from State dropdown and verifying result
//        1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void selectState() {

        //Select State dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //Select state Illinois by text
        stateDropdown.selectByVisibleText("Illinois");
        //Select state Virginia by Value
        stateDropdown.selectByValue("VA");
        //Select state California by Index
        stateDropdown.selectByIndex(5);

//        6. Verify final selected option is California.
//        Use all Select options. (visible text, value, index)

        String actualState = stateDropdown.getFirstSelectedOption().getText();
        String expectedState = "California";

        Assert.assertEquals(actualState, expectedState);

    }
    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }
}
