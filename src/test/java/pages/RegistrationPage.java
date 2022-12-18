package pages;

import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }
    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }
    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }
    public RegistrationPage setPhoneNumber(String PhoneNumber) {
        $("#userNumber").setValue(PhoneNumber);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subjectName) {
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(subjectName);
        $("#subjectsInput").pressEnter();


        return this;
    }

    public RegistrationPage setHobby(String hobbyName) {
        $("#hobbiesWrapper").$(byText(hobbyName)).click();

        return this;
    }

    public RegistrationPage uploadPhoto(String photoName) {
        $("#uploadPicture").uploadFromClasspath(photoName);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        $("#currentAddress").setValue(address);

        return this;
    }

    public RegistrationPage selectState(String state) {
        $("#stateCity-wrapper").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText(state)).click();

        return this;
    }

    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $("#city").$(new ByText(city)).click();
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppearance() {
        registrationResultModal.verifyModalAppearance();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }
}
