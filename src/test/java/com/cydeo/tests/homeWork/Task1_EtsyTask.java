package com.cydeo.tests.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_EtsyTask {

    public static void main(String[] args) {
        //           1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //        2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //        3. Search for “wooden spoon”
        WebElement searchElement = driver.findElement(By.id("global-enhancements-search-query"));
        searchElement.sendKeys("wooden spoon" + Keys.ENTER);

        // 4. Verify title:
        // Expected: “Wooden spoon | Etsy”
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is passed");
        } else {
            System.out.println("Title is failed");

        }
    }

    }
