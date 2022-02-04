package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) {

        //Google search
        //Open chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2 Go to https://google.com
        driver.get("https://google.com");

        // 3.write "apple" search box
        //4. press enter using Keys.Enter
        WebElement googleSearchBox= driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        //5. Verify title
        //expected title should start with "Apple" word

        String expectedTitle="apple";
        String actualTitle=driver.getTitle();

        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("");
        }else{
            System.out.println("Title verification FAILED");
        }
    }
}
