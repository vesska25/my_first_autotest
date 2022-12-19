package tests;

import com.github.javafaker.Faker;
import java.util.Random;

public class TestData {

    static Faker faker = new Faker();
    static Random random = new Random();
    static String[] genders = {"Male", "Female", "Other"},
                    month = {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"},
                    subjects = {"Hindi", "English", "Civics", "Computer Science",
                            "Social Studies", "Maths", "Commerce", "Arts", "Biology",
                            "Accounting", "Chemistry", "Economics", "History", "Physics"},
                    hobbies = {"Sports", "Reading", "Music"},
                    states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
                    citiesNCR = {"Delhi", "Gurgaon", "Noida"},
                    citiesUttar = {"Agra", "Lucknow", "Merrut"},
                    citiesHaryana = {"Karnal", "Panipat"},
                    citiesRajasthan = {"Jaipur", "Jaiselmer"};

    public static String chooseRandom(String[] list) {
        int i = random.nextInt(list.length);
        return list[i];
    }
    public static String chooseCity(String state) {
        switch (state) {
            case "Ncr":
                return chooseRandom(citiesNCR);
            case "Uttar Pradesh":
                return chooseRandom(citiesUttar);
            case "Haryana":
                return chooseRandom(citiesHaryana);
            case "Rajasthan":
                return chooseRandom(citiesRajasthan);
        }

        return state;
    }

     static String firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    email = faker.internet().emailAddress(),
                    gender = chooseRandom(genders),
                    phoneNumber = faker.phoneNumber().subscriberNumber(10),
                    birthDay = String.format("%02d", faker.number().numberBetween(1,28)),
                    birthMonth = chooseRandom(month),
                    birthYear = String.valueOf(faker.number().numberBetween(1900,2021)),
                    subject = chooseRandom(subjects),
                    hobby = chooseRandom(hobbies),
                    photo = "photo_2021-10-13 21.24.16.jpeg",
                    address = faker.address().fullAddress(),
                    state = chooseRandom(states),
                    city = chooseCity(state);

}
