package com.cydeo.tests.day10_uploads_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_Registration_Form {
    @Test
    public void registration_form_test(){
        //TC#1: Registration form confirmation
//Note: Use JavaFaker OR read from configuration.properties file when possible.
//1. Open browser
//2. Go to website: https://practice.cydeo.com/registration_form
       Driver.getDriver().get((ConfigurationReader.getProperty("registration.form.url")));
//create java faker object
        Faker faker=new Faker();
//3. Enter first name
        WebElement inputFirstName= Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());
//4. Enter last name
        WebElement inputLastName=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());
//5. Enter username
        WebElement username=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
       String user= faker.bothify("helpdesk###");
       username.sendKeys(user);

//        username.sendKeys(faker.name().username().replaceAll(".",""));
//6. Enter email address
        WebElement email=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(user+"@email.com");
//7. Enter password
        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.numerify("########"));
//8. Enter phone number
        WebElement phoneNumber= Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));
//9. Select a gender from radio buttons
        WebElement genderButton=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        genderButton.click();
//10. Enter date of birth
        WebElement dateOfBirth=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
       dateOfBirth.sendKeys("03/08/2000");
//11. Select Department/Office
        Select departmentDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

//12. Select Job Title

        Select jobTitle=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
//13. Select programming language from checkboxes
        WebElement languageCheckBox= Driver.getDriver().findElement(By.xpath(""));
//14. Click to sign up button
//15. Verify success message “You’ve successfully completed registration.” is
//displayed.
//
//
//Note:
//1. Use new Driver utility class and method
//2. User JavaFaker when possible
//3. User ConfigurationReader when it makes sense
    }
}
