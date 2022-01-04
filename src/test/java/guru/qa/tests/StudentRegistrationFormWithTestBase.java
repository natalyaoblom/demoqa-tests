package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithTestBase extends TestBase {

    @Test
    void successTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

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

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        //Assert
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Petrov"), text("email@email.com"), text("Male"), text("9009999099"),
                text("30 April,1995"), text("English"), text("Reading"), text("1.png"), text("Some address"), text("Haryana"), text("Karnal"));
    }
}