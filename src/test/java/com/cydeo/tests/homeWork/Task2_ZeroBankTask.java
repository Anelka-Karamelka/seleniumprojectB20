package com.cydeo.tests.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_ZeroBankTask {

    public static void main(String[] args) {

       // TC #2: Zero Bank header verification
        // 1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.navigate().to("http://zero.webappsecurity.com/login.html ");


        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement headerText = driver.findElement(By.tagName("h3"));

        String expectedHeader="Log in to ZeroBank";
        String actualHeader= headerText.getText();

        if(actualHeader.equals(expectedHeader)){
            System.out.println("Header is passed");
        }else{
            System.out.println("Header is failed");
        }


    }
}
