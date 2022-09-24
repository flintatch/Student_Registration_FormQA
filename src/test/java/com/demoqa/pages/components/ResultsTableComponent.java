package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsTableComponent {

private final static String TEXT_STUFF = "Thanks for submitting the form";
    public ResultsTableComponent checkVisible() {
        $("#example-modal-sizes-title-lg").shouldHave(text(TEXT_STUFF));
        return this;
    }
    public ResultsTableComponent checkResult(String key, String value) {
        $$(".table-responsive").findBy(text(key)).shouldHave(text(value));
        return this;
    }
}