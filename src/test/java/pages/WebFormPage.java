package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultFormComponent;
import pages.components.LocationComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebFormPage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            resulModalWindow = $(".modal-content");

    CalendarComponent calendar = new CalendarComponent();
    ResultFormComponent resultPracticeForm = new ResultFormComponent();
    LocationComponent stateAndCity = new LocationComponent();

    public WebFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public WebFormPage bannerDrop() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public WebFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public WebFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public WebFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public WebFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public WebFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public WebFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public WebFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public WebFormPage setHobby(String hobby) {
        hobbiesWrapperInput.$(byText(hobby)).click();
        return this;
    }

    public WebFormPage uploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    public WebFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress).pressEnter();
        return this;
    }

    public WebFormPage setState(String state) {
        stateInput.click();
        stateAndCity.setStateOrCity(state);
        return this;
    }

    public WebFormPage setCity(String city) {
        cityInput.click();
        stateAndCity.setStateOrCity(city);
        return this;
    }

    public WebFormPage submitClick() {
        submit.click();
        return this;
    }

    public WebFormPage checkResult(String key, String value) {
        resultPracticeForm.checkResultForm(key, value);
        return this;
    }

    public void checkAbsenceFormResult() {
        resulModalWindow.shouldNotBe(visible);
    }
}