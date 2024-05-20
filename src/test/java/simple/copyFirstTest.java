package simple;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.testBase;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;


public class copyFirstTest extends testBase {
    RegistrationPage registrationPage = new RegistrationPage() ;
    Faker faker = new Faker(new Locale("ru"));
    String userFirstName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userTelNums = "+998" + faker.number().numberBetween(100000000, 999999999);
    ;

    @Tag("Smoke")
    @Test
    void fillFormTest1() {
        open("/automation-practice-form");

        registrationPage.setName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setNumber(userTelNums)
                .setSubject("Math")
                .setHobbies("Reading")
                .uploadPicture("112333.png")
                .setAdress("Some address 1")
                .setDateOnCalendar1("001", "June", "1994")
                .setState("NCR", "NCR")
                .checkForResultWindow();
    }

}

