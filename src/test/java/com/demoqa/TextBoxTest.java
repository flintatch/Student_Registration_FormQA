package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String name = "Irwing";

        open("/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue("gvladovsky@gmail.com");
        $("#currentAddress").setValue("1111");
        $("#permanentAddress").setValue("1111");
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text("gvladovsky@gmail.com"));
        $("#output #currentAddress").shouldHave(text("1111"));
        $("#output #permanentAddress").shouldHave(text("1111"));

    }
}
