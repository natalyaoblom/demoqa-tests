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

        registrationPage.typeFirstName("Alex");
        registrationPage.typeLastName("Petrov");
        registrationPage.typeUserEmail("test@gmail.com");
        registrationPage.selectGenterWrapper("Male");
        registrationPage.typeUserNumber("9009999099");
        registrationPage.setBirthDate("30", "May", "2000");
        registrationPage.typeSubjectsInput("English");
        registrationPage.selectHobbie("Reading");
        registrationPage.uploadPicture("images/1.png");
        registrationPage.typeCurrentAddress("Some address");
        registrationPage.selectState("Haryana");
        registrationPage.selectCity("Karnal");
        registrationPage.submit();

        registrationPage.checkResultsHeader("Thanks for submitting the form");
        registrationPage.checkResultsValue("Student Name", "Alex Petrov");
        registrationPage.checkResultsValue("Student Email", "test@gmail.com");
        registrationPage.checkResultsValue("Gender", "Male");
        registrationPage.checkResultsValue("Mobile", "9009999099");
        registrationPage.checkResultsValue("Date of Birth", "30 May,2000");
        registrationPage.checkResultsValue("Subjects", "English");
        registrationPage.checkResultsValue("Hobbies", "Reading");
        registrationPage.checkResultsValue("Picture", "1.png");
        registrationPage.checkResultsValue("Address", "Some address");
        registrationPage.checkResultsValue("State and City", "Haryana Karnal");

    }
}
