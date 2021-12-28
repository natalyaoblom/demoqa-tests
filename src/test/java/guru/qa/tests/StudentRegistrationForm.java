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
//        $("#gender-radio-1").parent().click(); // doubleClick();
//        $("label[for=gender-radio-1]").click(); //без label тоже можно и [for='...']
//       $(byText("Other")).click(); //BAD PRACTICE

        $("#userNumber").setValue("9009999099");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--030") // $ -  SelenideElement. $$ - ElementsCollection;
//                .filter(not(cssClass(".react-datepicker__day--outside-month)")))
//                .first() // or .get(0)
//                .click();
//        $("[aria-label=\"Choose Sunday, April 30th, 1995\"]"); //квадратные скобки пара ключ:параметр
//        $("[aria-label='Choose Sunday, April 30th, 1995'");
//        $("[aria-label=Choose Sunday, April 30th, 1995");// NOT WORKING
        $("[aria-label$='April 30th, 1995']").click(); //заканчивается с '...'
//        $x("//*contains(@aria-label, \"April 30th, 1995\"]").click();

//<div class="react-datepicker__day      react-datepicker__day--030 react-datepicker__day--outside-month"  aria-label="Choose Thursday, March 30th, 1995" >30</div>
//<div class="react-datepicker__day      react-datepicker__day--030 react-datepicker__day--weekend"        aria-label="Choose Sunday, April 30th, 1995" >30</div>

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

//        $("#uploadPicture").uploadFile(new File("src/test/resources/images/1.png"));
//        File one = new File("src/test/resources/images/1.png");
//        $("#uploadPicture").uploadFile(one);
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
    }
}
