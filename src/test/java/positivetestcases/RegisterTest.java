package positivetestcases;

import com.github.javafaker.Faker;
import models.ScenariosPojo;
import org.testng.annotations.Test;
import util.BaseTest;
import util.Utils;

import static util.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {
    @Test
    public void registrationTest() throws InterruptedException {
        ScenariosPojo data = Utils.readJsonFile(returnConfigValue("test.data.path"), ScenariosPojo.class);
        System.out.println(data.getScenarios().get(0).getData().getCountry());

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
        userRegistrationPage.setZipCodeInput("1086");
        userRegistrationPage.setPhoneInput("1234567");
        userRegistrationPage.clickSubmitButton();

        Thread.sleep(10000);
    }
}
