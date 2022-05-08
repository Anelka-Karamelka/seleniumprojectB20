package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void task4_and_task5(){

//   TC #4: Scroll practice
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

//3- Scroll down to “Powered by CYDEO”
// create object of Actions and pass our "driver" instance
        Actions actions=new Actions(Driver.getDriver());

//locating Cydeo link to be able to pass in the actions method, xpath -->  //a[@href='https://cydeo.com/']
        WebElement cydeoLink= Driver.getDriver().findElement(By.linkText("CYDEO"));

//4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).perform();

        //5- scroll back up to "home" link using page up button
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();


        Driver.closeDriver();

    }
@Test
    public void test2(){
    Driver.getDriver().get("https://practice.cydeo.com/");
    Driver.closeDriver();
}

}
