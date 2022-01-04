package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithPageObjects {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void successTest() {
        registrationPage.openPage();

        //Act
        registrationPage.typeFirstName("Alex");
        registrationPage.typeLastName("Petrov");
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
        $(".modal-content").shouldBe(visible);
        registrationPage.checkResultsValue("Student Name", "Alex Petrov")
                .checkResultsValue("Student Email", "email@email.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9009999099")
                .checkResultsValue("Date of Birth", "30 April,1995")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "1.png")
                .checkResultsValue("Address", "Some address")
                .checkResultsValue("State and City", "Haryana Karnal");
    }

    @Test
    void fillFornWithDslTest() {
        registrationPage.openPage()
                .typeFirstName("Alex")
                .typeLastName("Petrov");
        $("#userEmail").setValue("email@email.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9009999099");

//        registrationPage.calendarComponent.setDate("30", "April", "1995");
        registrationPage.setBirthDate("30", "April", "1995");

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
        registrationPage.checkResultsValue("Student Name", "Alex Petrov")
                .checkResultsValue("Student Email", "email@email.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9009999099")
                .checkResultsValue("Date of Birth", "30 April,1995")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "1.png")
                .checkResultsValue("Address", "Some address")
                .checkResultsValue("State and City", "Haryana Karnal");
    }
}
