package com.cydeo.tests.day02_02_12_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC05 {

    public static void main(String[] args) {
       // C:5 As a user I should be able to see the login page

        //1-open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        //3-click Login label
        WebElement loginWebElement = driver.findElement(By.xpath("//ul[@id='top-menu']/li[6]/a[.='LOGIN']"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginWebElement.click();
        //4-verify the url contains login
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("login")){
                System.out.println("passed");
            }else{
                System.err.println("failed");
            }
            driver.close();
        }
    }

