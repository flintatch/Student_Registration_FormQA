package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.textBoxTestPage;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxWithCommentsTestXX {
    textBoxTestPage textBoxTestPage = new textBoxTestPage();
    Faker faker = new Faker(new Locale("en"));

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobile = faker.phoneNumber().subscriberNumber(10);
    String day = String.valueOf(faker.number().numberBetween(1,30));
    String month = "April";
    String year = String.valueOf(faker.number().numberBetween(1950, 2000));
    String subject  = "English";
    String gender = "Male";
    String hobby = "Reading";
    String address = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";

    @Test
    void fillFormTest() {
        textBoxTestPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(mobile)
                .setBirthDate(day, month, year)
                .setHobby(hobby)
                .setSubject(subject)
                .setPicture("image.png")
                .setAddress(address, state, city)
                .clickButton();

        textBoxTestPage.checkTableResultsVisible()
                        .checkResult("Student Name", (firstName + " " + lastName))
                        .checkResult("Student Email", email)
                        .checkResult("Date of Birth", ((day + " " + month + "," + year)))
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", mobile)
                        .checkResult("Subjects", subject)
                        .checkResult("Hobbies", hobby)
                        .checkResult("Picture", "image.png")
                        .checkResult("Address", address)
                        .checkResult("State and City", "NCR Delhi");
    }
}
