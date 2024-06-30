package tests;

import org.junit.jupiter.api.Test;
import pages.WebFormPage;

public class WebFormTest extends WebTestBase {
        WebFormPage webFormPage = new WebFormPage();

    @Test
    void webFormTest() {
        webFormPage.openPage()
        .bannerDrop()
                .setFirstName("Ahmed")
                .setLastName("Ahmedov")
                .setEmail("testahmed@gmail.com")
                .setGender("Male")
                .setUserNumber("7904744684")
                .setDateOfBirth("11", "April", "1985")
                .setSubject("Maths")
                .setHobby("Sports")
                .uploadFile("leopard.jpg")
                .setCurrentAddress("Istanbul")
                .setState("Haryana")
                .setCity("Karnal")
                .submitClick()
                .checkResult("Student Name", "Ahmed Ahmedov")
                .checkResult("Student Email", "testahmed@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7904744684")
                .checkResult("Date of Birth", "11 April,1985")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "leopard.jpg")
                .checkResult("Address", "Istanbul")
                .checkResult("State and City", "Haryana Karnal");
    }
    @Test
    void shortFillFormTest() {
        webFormPage.openPage();
        webFormPage.bannerDrop()
                .setFirstName("Ahmed")
                .setLastName("Ahmedov")
                .setGender("Male")
                .setUserNumber("7904744684")
                .setDateOfBirth("11", "April", "1985")
                .submitClick()
                .checkResult("Student Name", "Ahmed Ahmedov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7904744684")
                .checkResult("Date of Birth", "11 April,1985");
    }

    @Test
    void incorrectFillFormTest() {
        webFormPage.openPage();
        webFormPage.bannerDrop()
                .setFirstName("Ahmed1")
                .setLastName("Ahmedov")
                .setGender("Male")
                .setDateOfBirth("29", "September", "1986")
                .submitClick()
                .checkAbsenceFormResult();
    }
}