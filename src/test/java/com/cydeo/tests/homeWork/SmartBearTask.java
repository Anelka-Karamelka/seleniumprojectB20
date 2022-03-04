package com.cydeo.tests.homeWork;

import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //        TC #1: Smartbear software link verification
//        1. Open browser
//        2. Go to website:
//        http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
    }
        @Test
        public void test() {
//        6. Print out count of all the links on landing page
//        7. Print out each link text on this page
            SmartBearUtils.login_smart_bears(driver);

            List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
            System.out.println(listOfLinks.size());

            for (WebElement eachLink : listOfLinks) {
                System.out.println(eachLink.getText());
            }

        }
        @Test
        public void test2(){
            SmartBearUtils.login_smart_bears(driver);
            //        6. Click on Order

            WebElement order=driver.findElement(By.xpath("//a[.='Order']"));
            order.click();
//        7. Select familyAlbum from product, set quantity to 2
            Select productDropdown=new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
            productDropdown.selectByVisibleText("FamilyAlbum");
            //        8. Click to “Calculate” button


            WebElement quantity= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
            quantity.sendKeys("2");

            WebElement calculate=driver.findElement(By.xpath("//input[@type='submit']"));
            calculate.click();

//        9. Fill address Info with JavaFaker
//• Generate: name, street, city, state, zip code
            Faker faker = new Faker();
            WebElement customer = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
            customer.sendKeys(faker.name().firstName()+" "+faker.name().lastName());

            WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
            street.sendKeys(faker.address().streetName());

            WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
            city.sendKeys(faker.address().city());

            WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
            state.sendKeys(faker.address().state());

            WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
            zip.sendKeys(faker.address().zipCode());

            //        10. Click on “visa” radio button
            WebElement visaButton= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
            visaButton.click();
            Assert.assertTrue(visaButton.isSelected());
            //11. Generate card number using JavaFaker
            WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
            cardNumber.sendKeys(faker.number().digit()); //faker.business().creditCardNumber()

            WebElement expirationDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
            expirationDate.sendKeys("12/22"); //faker.business().creditCardExpiry()

            //12. Click on “Process”
            WebElement processBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
            processBtn.click();

            //13. Verify success message “New order has been successfully added.”
            WebElement successfulOrderMessage = driver.findElement(By.xpath("//strong"));

            Assert.assertEquals(successfulOrderMessage.getText(), "New order has been successfully added.");

        }
@AfterMethod
    public void teardown(){
    //    driver.quit();
}
        }














