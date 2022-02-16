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

public class T6_SelectDate_Dropdown {
WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
//        TC #6: Selecting date on dropdown and verifying
//        1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void selectDate(){
//        3. Select “December 1st, 1922” and verify it is selected.
//                Select year using  : visible text
//        Select month using   : value attribute
//        Select day using : index number
  //    year
        Select selectDate = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectDate.selectByVisibleText("1992");

        String actualSelectedYear= selectDate.getFirstSelectedOption().getText();
        String expectedSelectedYear="1992";

        Assert.assertEquals(actualSelectedYear, expectedSelectedYear);
 //    month
        Select selectMonth=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByValue("11");

        String actualSelectedMonth= selectMonth.getFirstSelectedOption().getText();
        String expectedSelectedMonth="December";

        Assert.assertEquals(actualSelectedMonth, expectedSelectedMonth);

//     day
       Select selectDay= new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByIndex(0);

        String actualSelectedDay= selectDay.getFirstSelectedOption().getText();
        String expectedSelectedDay="1";

        Assert.assertEquals(actualSelectedDay, expectedSelectedDay);
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }
}