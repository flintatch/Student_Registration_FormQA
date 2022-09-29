package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private final static String TEXT_STUFF = "Thanks for submitting the form";
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    static SelenideElement firstNameInput = $("#firstName");
    static SelenideElement lastNameInput = $("#lastName");
    static SelenideElement emailInput = $("#userEmail");

    public TextBoxTestPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public TextBoxTestPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public TextBoxTestPage setLastName(String name) {
        lastNameInput.setValue(name);
        return this;
    }

    public TextBoxTestPage setEmail(String name) {
        emailInput.setValue(name);
        return this;
    }

    public TextBoxTestPage setGender(String name) {
        $("#genterWrapper").$(byText(name)).click();
        return this;
    }

    public TextBoxTestPage setNumber(String name) {
        $("#userNumber").setValue(name);
        return this;
    }

    public TextBoxTestPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public TextBoxTestPage checkTableResultsVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public TextBoxTestPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }


    public TextBoxTestPage setHobby(String name) {
        $("#hobbiesWrapper").$(byText(name)).click();
        return this;
    }

    public TextBoxTestPage setSubject(String name) {
        $("#subjectsInput").setValue(name).pressEnter();
        return this;
    }

    public TextBoxTestPage setPicture(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    public TextBoxTestPage setAddress(String way, String state, String city) {
        $("#currentAddress").setValue(way);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public TextBoxTestPage clickButton() {
        $("#submit").click();
        return this;
    }
}
