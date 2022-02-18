package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_SelectValue_dropdown {
    WebDriver driver;

//    TC #7: Selecting value from non-select dropdown
//1. Open Chrome browser
@BeforeMethod
public void setupMethod(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //2. Go to https://practice.cydeo.com/dropdown
    driver.get("https://practice.cydeo.com/dropdown");
}
@Test
public void clickNonSelect(){
//            3. Click to non-select dropdown

}
//4. Select Facebook from dropdown
//5. Verify title is “Facebook - Log In or Sign Up”
}
