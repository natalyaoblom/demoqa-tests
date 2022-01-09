package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HWFormWithPageObject {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName("Alex")
                .typeLastName("Petrov")
                .typeUserEmail("test@gmail.com")
                .selectGenterWrapper("Male")
                .typeUserNumber("9009999099")
                .setBirthDate("30", "May", "2000")
                .typeSubjectsInput("English")
                .selectHobbie("Reading")
                .uploadPicture("images/1.png")
                .typeCurrentAddress("Some address")
                .selectState("Haryana")
                .selectCity("Karnal")
                .submit();

        registrationPage.checkResultsHeader("Thanks for submitting the form")
                .checkResultsValue("Student Name", "Alex Petrov")
                .checkResultsValue("Student Email", "test@gmail.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9009999099")
                .checkResultsValue("Date of Birth", "30 May,2000")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "1.png")
                .checkResultsValue("Address", "Some address")
                .checkResultsValue("State and City", "Haryana Karnal");
    }
}
