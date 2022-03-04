package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SmartBearUtils {

//
//        Mini-Task: CREATE A CLASS à SmartBearUtils
//• Create a method called loginToSmartBear
//• This method simply logs in to SmartBear when you call it.
//• Accepts WebDriver type as parameter

    public static void login_smart_bears(WebDriver driver){
        // 3. Enter username: “Tester”
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        // 4. Enter password: “test”
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys( "test" );
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();




    }
}
