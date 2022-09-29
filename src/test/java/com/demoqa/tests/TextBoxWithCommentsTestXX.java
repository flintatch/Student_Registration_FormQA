package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TextBoxTestPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TextBoxWithCommentsTestXX {
    TextBoxTestPage textBoxTestPage = new TextBoxTestPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        textBoxTestPage.openPage()
                .setFirstName("Irwing")
                .setLastName("Price")
                .setEmail("gvladovsky@gmail.com")
                .setGender("Male")
                .setNumber("1111222234")
                .setBirthDate("08", "April", "1996")
                .setHobby("Reading")
                .setSubject("English")
                .setPicture("image.png")
                .setAddress("address 1", "NCR", "Delhi")
                .clickButton();

        textBoxTestPage.checkTableResultsVisible()
                        .checkResult("Student Name", "Irwing Price")
                        .checkResult("Student Email", "gvladovsky@gmail.com")
                        .checkResult("Date of Birth", "08 April,1996")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "1111222234")
                        .checkResult("Subjects", "English")
                        .checkResult("Hobbies", "Reading")
                        .checkResult("Picture", "image.png")
                        .checkResult("Address", "address 1")
                        .checkResult("State and City", "NCR Delhi");
    }
}
