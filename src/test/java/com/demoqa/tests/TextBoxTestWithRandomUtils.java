package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.RandomUtils.*;

public class TextBoxTestWithRandomUtils {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String email = getRandomEmail();
    String mobile = getRandomPhone();
    String day = "08";
    String month = "April";
    String year = "1996";
    String subject  = "English";
    String gender = "Male";
    String hobby = "Reading";
    String address = "address 1";
    String state = "NCR";
    String city = "Delhi";

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--selected").click();
        $("#hobbiesWrapper").$(byText(hobby)).click();;
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text(firstName + " " + lastName));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text(email));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text(gender));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text(mobile));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text(day + " " + month + "," + year));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text(subject));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text(hobby));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("image.png"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text(address));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text(state + " " + city));
    }
}
