package simple;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.testBase;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Smoke")
public class copyFirstTest extends testBase {
    RegistrationPage registrationPage = new RegistrationPage() ;
    Faker faker = new Faker(new Locale("en"));
    String userFirstName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userTelNums = faker.phoneNumber().subscriberNumber(10) ;
//            userTelNums = "+998" + faker.number().numberBetween(100000000, 999999999);
    ;

//    @Disabled
    @Test
    void fillFormTest1() {
        open("https://demoqa.com/automation-practice-form");

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
    @Test
    void test1() {
        assertTrue(true);
    }
    @Test
    void test2() {
        assertTrue(true);
    }

}

