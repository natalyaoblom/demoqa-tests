package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void successTest() {
        open("/automation-practice-form");

        //Act
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("email@email.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9009999099");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");

        $("[aria-label$='April 30th, 1995']").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("images/1.png");

        $("#currentAddress").setValue("Some address");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        //Assert
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alex"), text("Petrov"), text("email@email.com"), text("Male"), text("9009999099"),
                text("30 April,1995"), text("English"), text("Reading"), text("1.png"), text("Some address"), text("Haryana"), text("Karnal"));
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Alex Petrov"));
    }
}
