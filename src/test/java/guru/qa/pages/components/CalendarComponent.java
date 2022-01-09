package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
//        String dayLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
//        $(dayLocator).click();

//        $("[aria-label$=' " month + " " + date + "th, " + year + "']").click();
//        String dayLocator = format("[aria-label$=%s %th, %s]", month, day, year); Не подходит всем числам! 1,2,3...
    }
}
