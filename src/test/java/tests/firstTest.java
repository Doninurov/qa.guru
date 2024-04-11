package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class firstTest extends testBase {
    Faker faker = new Faker(new Locale("ru"));
    String userFirstName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userTelNums = "+998" + faker.number().numberBetween(100000000, 999999999);
    ;


    @Disabled
    @Test
    @DisplayName("Первая простая проверка")
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Alex Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another address 1");
        $("#submit").click();

        $("#output").shouldHave(text("Alex Egorov"), text("alex@egorov.com"), text("Some address 1"), text("Another address 1"));
    }

    @Disabled
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

//        $("#submit").click();
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $("#firstName").setValue("Alex");
//        $("#lastName").setValue("Egorov");
//        $("#userEmail").setValue("alex@egorov.com");
//        $("#genterWrapper").$(byText("Male")).click();
//        $("#userNumber").setValue("9778103332");
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("June");
//        $(".react-datepicker__year-select").selectOption("1994");
//        $(".react-datepicker__day--001").click();
//        $("#subjectsInput").setValue("Math").pressEnter();
//        $("#hobbiesWrapper").$(byText("Reading")).click();
//        $("#uploadPicture").uploadFromClasspath("112333.png");
//        $("#currentAddress").setValue("Some address 1");
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
    }

    @Disabled
    @Test
    void fillFormTest2() {
        open("https://www.apple.com/shop/refurbished");
        $$(".rf-refurb-categorieslist li").first().$("a").click();
        $(".t-headline-reduced").shouldHave(text(" Refurbished Mac "));
        sleep(5000);
    }

    @Disabled
    @Test
    void fillFormTest3() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(".markdown-body").$(byText("Soft assertions")).click();
        $("#wiki-body").$("ol").shouldHave(text("JUnit5 extension - "));
        sleep(5000);
    }

    @Disabled
    @Test
    void fillFormTest4() {
        open("https://github.com/");
        $("div.header-menu-wrapper").$(byText("Solutions")).parent().hover();
        $("div.HeaderMenu-dropdown").$(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
//        $(".markdown-body").shouldHave(text("Soft assertions"));
//        $(".markdown-body").$(byText("Soft assertions")).click();
//        $("#wiki-body").$("ol").shouldHave(text("JUnit5 extension - "));
        sleep(5000);
    }

    @ValueSource(strings = {
            "wchada", "xasmurakar"
    })
    @ParameterizedTest(name = "Проверка того что в поле ввода ввели {0}")
    void checkingForInputValue(String testData) {
        open("https://yandex.uz");
        $("#text").setValue(testData).pressEnter();
        $("input.HeaderDesktopForm-Input").shouldHave(attribute("value", testData));
    }
    @CsvSource(value = {
            "wchada|         ПРОЩАЙ ЦЫГАНКА  ",
            "xasmurakar|        Хасмуракар перевод с цыганского",
    },
    delimiter = '|') // для того чтобы в тексте можно было искать текст с зяпятыми
    @ParameterizedTest(name = "Проверка того что в поле ввода ввели {0} и получили {1}")
    void checkingForInputValue1(String testData, String Expected) {
        open("https://yandex.uz");
        $("#text").setValue(testData).pressEnter();
        $("input.HeaderDesktopForm-Input").shouldHave(attribute("value", testData));
        $("#search-result").shouldHave(text(Expected));
    }

    static Stream<Arguments> checkingForInputValue2() {
        return Stream.of(
                Arguments.of(tests.data.Locale.En, Arrays.asList("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(tests.data.Locale.Ru, Arrays.asList("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }
    @MethodSource()
    @ParameterizedTest(name = "Проверка того что в поле ввода ввели {0} и получили {1}")
    void checkingForInputValue2(tests.data.Locale locale, List<String> Expected) {
        open("https://selenide.org");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible).shouldHave(texts(Expected));

    }


    

}

