package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail =$("#userEmail"),
            genterWrapper =$("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper =$("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            selectState =$("#state"),
            selectCity = $("#city"),
            buttonSubmit = $("#submit"),

            resultHeader = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage selectGenterWrapper(String gender) {
        genterWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage typeSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage selectHobbie(String hobbie) {
        hobbiesWrapper.$(byText(hobbie)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String state) {
        selectState.scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }

    public RegistrationPage selectCity(String city) {
        selectCity.click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationPage submit() {
        buttonSubmit.click();

        return this;
    }

    /*
    public AnotherPage clickOnAnotherPage() {
        $("").click();
        return new AnotherPage();
    }
     */

    public RegistrationPage checkResultsHeader(String value) {
        resultHeader.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
