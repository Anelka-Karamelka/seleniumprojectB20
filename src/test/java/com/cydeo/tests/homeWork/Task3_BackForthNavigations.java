package com.cydeo.tests.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3_BackForthNavigations {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       // 2- Go to: https://google.com
        driver.get("https://google.com ");
       // 3- Click to Gmail from top right.
        WebElement gmailElement = driver.findElement(By.linkText("Gmail"));
        gmailElement.sendKeys(Keys.ENTER);

//        4- Verify title contains:
//        Expected: Gmail

        String expectedTitle= "Gmail";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title is passed");
        }else{
            System.out.println("Title is failed");
        }
        //        5- Go back to Google by using the .back();
        driver.navigate().back();

//        6- Verify title equals:
//        Expected: Google
        if (driver.getTitle().equals("Google")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        driver.quit();




    }
}
