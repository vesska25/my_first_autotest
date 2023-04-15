package tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormTestWithPageObjects extends TestBase {


    @Test
    void fill_Student_Registration_Form() {

        registrationPage.openPage()
                        .setFirstName("Sergei")
                        .setLastName("Savich")
                        .setEmail("ser@ser.com")
                        .setGender("Male")
                        .setPhoneNumber("9253077448")
                        .setBirthDate("18", "November", "1995")
                        .setSubject("English")
                        .setHobby("Music")
                        .uploadPhoto("photo_2021-10-13 21.24.16.jpeg")
                        .setAddress("Koeln")
                        .selectState("NCR").selectCity("Delhi");


        registrationPage.verifyResultsModalAppearance()
                        .verifyResult("Student Name", "Sergei Savich")
                        .verifyResult("Student Email", "ser@ser.com")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "9253077448")
                        .verifyResult("Date of Birth", "19 November,1995")
                        .verifyResult("Subjects", "English")
                        .verifyResult("Hobbies", "Music")
                        .verifyResult("Picture", "photo_2021-10-13 21.24.16.jpeg")
                        .verifyResult("Address", "Koeln")
                        .verifyResult("State and City", "NCR Delhi");

    }
}
