package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HWFormWithFaker {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().streetAddress();


    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920*1080";
    }

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .selectGenterWrapper("Male")
                .typeUserNumber(userNumber)
                .setBirthDate("30", "May", "2000")
                .typeSubjectsInput("English")
                .selectHobbie("Reading")
                .uploadPicture("images/1.png")
                .typeCurrentAddress(address)
                .selectState("Haryana")
                .selectCity("Karnal")
                .submit();

        registrationPage.checkResultsHeader("Thanks for submitting the form")
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", "30 May,2000")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "1.png")
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", "Haryana Karnal");
    }
}
