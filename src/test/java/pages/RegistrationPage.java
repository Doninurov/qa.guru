package pages;

import pages.component.CalendarComponent;
import pages.component.StateComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.getRandomInt;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private StateComponent stateComponent = new StateComponent();


    public RegistrationPage setLastName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationPage setName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setAdress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setDateOnCalendar1(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDateOnCalendar(day, month, year);
        return this;
    }

    public RegistrationPage setState(String state, String city) {
        stateComponent.setState(state, city);
        return this;
    }

    public RegistrationPage checkForResultWindow() {
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public String pickRandomGender(String[] values) {
            int index = getRandomInt(0, values.length - 1);
            return values[index];
        }
    }


