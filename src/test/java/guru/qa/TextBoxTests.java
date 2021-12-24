package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("email@email.com");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#name").shouldHave(Condition.text("Alex"));
        $("#email").shouldHave(Condition.text("email@email.com"));
        $("#output #currentAddress").shouldHave(Condition.text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(Condition.text("Another address"));

    }
}
