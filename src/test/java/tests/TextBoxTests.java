package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.RandomData;


public class TextBoxTests extends WebTestBase {

    TextBoxPage textBox = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBox.openPage()
        .bannerDrop()
                .setFullName("Ahmed")
                .setEmail("testahmed@gmail.com")
                .setCurrentAddress("Istanbul")
                .setPermanentAddress("Istanbul 33")
                .submitClick()
                .checkResult("name","Ahmed")
                .checkResult("email","testahmed@gmail.com")
                .checkResult("currentAddress","Istanbul")
                .checkResult("permanentAddress","Istanbul 33");
    }
}