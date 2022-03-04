package com.cydeo.tests.homeWork;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWorkTask {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
    }

    @Test
    public void test(){
//        TC#3: Smartbear software order verification
//        1. Open browser and login to Smartbear software
//        2. Click on View all orders

        SmartBearUtils.login_smart_bears(driver);
        WebElement allOrders= driver.findElement(By.xpath("//a[.='View all orders']"));
        allOrders.click();
//        3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susan = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Susan McLaren']//following-sibling::td[3]"));
        Assert.assertEquals(susan.getText(),"01/05/2010", "Dote doesn't match");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
