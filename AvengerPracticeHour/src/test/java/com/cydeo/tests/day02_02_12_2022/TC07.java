package com.cydeo.tests.day02_02_12_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC07 {
    public static void main(String[] args) {
       // TC:7 As a user I should be able to see User is John Doe

        //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        //3-click Login label
       // driver
        //4-enter username "User1"
        //5-enter password "UserUser123"
        //6-click LOG IN
        //7-verify the user John Doe
    }
}
