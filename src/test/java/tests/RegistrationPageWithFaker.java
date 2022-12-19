package tests;

import org.junit.jupiter.api.Test;
import static tests.TestData.*;


public class RegistrationPageWithFaker extends TestBase {


    @Test
    void fill_Student_Registration_Form() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPhoto(photo)
                .setAddress(address)
                .selectState(state).selectCity(city);


        registrationPage.verifyResultsModalAppearance()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", photo)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

    }
}

