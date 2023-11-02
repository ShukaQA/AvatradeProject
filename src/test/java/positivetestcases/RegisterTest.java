package positivetestcases;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import util.BaseTest;

public class RegisterTest extends BaseTest {

    @Test
    public void registrationTest() throws InterruptedException {
        homePage.clickRegisterButton();
        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput("Password!123");
        registrationPopUpPage.clickSubmitButton();
        userRegistrationPage.setFirstNameInput("Test Name");
        userRegistrationPage.setLastNameInput("Test Surname");
        userRegistrationPage.setDateOfBirthInput("11121996");
        userRegistrationPage.setCountryInput("France");
        userRegistrationPage.setCityInput("Test City");
        userRegistrationPage.setStreetInput("Test Street");
        userRegistrationPage.setStreetNumberInput("123");
        userRegistrationPage.setFlatInput("Test Flat");

        Thread.sleep(10000);
    }
}
