import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HA_firstAutotest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fill_Student_Registration_Form() {

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Savich");
        $("#userEmail").setValue("ser@ser.com");
        $("[value=Male]").doubleClick();
        $("#userNumber").setValue("9253077448");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--019").click();

        $("#subjectsInput").click();
        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("photo_2021-10-13 21.24.16.jpeg");

        $("#currentAddress").setValue("Neumarkt");
        $("#stateCity-wrapper").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("NCR")).click();
        $("#city").click();
        $("#city").$(new ByText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Sergei Savich"), text("ser@ser.com"), text("19 November,1995"), text("Male"), text("English"), text("Neumarkt"));
    }
}
