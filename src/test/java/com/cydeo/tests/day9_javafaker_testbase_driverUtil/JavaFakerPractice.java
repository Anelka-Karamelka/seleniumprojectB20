package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test(){
// creating faker object to reach methods
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        //numerify() method will generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        //letterify() method will return random letters where we pass "?"
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-", ""));

    }
}
