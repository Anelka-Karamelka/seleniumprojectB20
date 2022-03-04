package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));


        informationAlertButton.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is not as expected!!!");
    }
    @Test
    public void alert_test2() throws InterruptedException {
//        3. Click to “Click for JS Confirm” button
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        confirmationAlertButton.click();
        Thread.sleep(1000);
//        4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

//        5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));

        String expectedText = "You clicked: Ok";
        String actualText = resultText.getText();
        Assert.assertTrue(resultText.isDisplayed(), "Actual result text is not as expected!!!");

    }
    @Test
    public void alert_test3() throws InterruptedException {
//        3. Click to “Click for JS Prompt” button
        WebElement informationAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        informationAlert.click();
        Thread.sleep(3000);

        //        4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");

//        5. Click to OK button from the alert
        alert.accept();
//        6. Verify “You entered:  hello” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        String expectedText = "You entered:  hello";
        String actualText = resultText.getText();

        Assert.assertTrue(resultText.isDisplayed(), "Actual result text is not as expected!!!");

    }

    @AfterMethod
    public void tearDownMethod(){
    driver.close();
}


}