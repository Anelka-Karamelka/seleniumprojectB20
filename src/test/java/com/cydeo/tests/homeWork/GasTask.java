package com.cydeo.tests.homeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasTask {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. Add a new class GasMileageCalculatorTest
//2. Go to https://www.calculator.net
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get(" https://www.calculator.net ");

    }

    @Test
    public void test() {
        WebElement gasMileage = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        gasMileage.sendKeys("gas mileage" + Keys.ENTER);

//        3. Search for “gas mileage” using search box
//        4. Click on the “Gas Mileage Calculator” link
        WebElement gasCalculator = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasCalculator.click();
//        5. On Next page verify:
//        a. Title equals: “Gas Mileage Calculator”
//        b. “Gas Mileage Calculator” label is displayed
        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle, "wrong title");

        // 6. Locate, clear and type “7925” into “Current odometer” field
        WebElement odometer = driver.findElement(By.xpath("//input[@id='uscodreading']"));
        odometer.clear();

        odometer.sendKeys("7925");

//        7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = driver.findElement(By.xpath("//input[@id='uspodreading']"));
        previousOdometer.clear();

        previousOdometer.sendKeys("7550");

//        8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = driver.findElement(By.xpath("//input[@id='usgasputin']"));
        gasAdded.clear();

        gasAdded.sendKeys("16");

//        9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = driver.findElement(By.xpath("//input[@id='usgasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

//        10. Click on Calculate button
        WebElement calculateButton = driver.findElement(By.xpath("//*[@id='standard']//tr[5]/td/input[@type='image']"));
        calculateButton.click();

//        11. Verify mpg value is as expected:
//        Expected value: “23.44 mpg”
        WebElement value = driver.findElement(By.xpath("//b[.='23.44 mpg']"));
        value.getText();

        String actualValue= value.getText();
        String expectedValue="23.44 mpg";

        Assert.assertEquals(actualValue,expectedValue);




    }

}