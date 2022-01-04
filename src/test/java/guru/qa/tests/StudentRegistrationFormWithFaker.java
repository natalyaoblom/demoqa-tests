package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.utils.RandomUtils.getRandomEmail;
import static guru.qa.utils.RandomUtils.getRandomString;

public class StudentRegistrationFormWithFaker {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String userEmail = faker.internet().emailAddress();
    String currentAddress = faker.lebowski().quote() + " " +
            faker.medical().symptoms();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void successTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //Act
        $("#firstName").setValue(firstName);
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9009999099");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");

        $("[aria-label$='April 30th, 1995']").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("images/1.png");

        $("#currentAddress").setValue(currentAddress);

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        //Assert
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " Petrov"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text(userEmail));
    }
}
