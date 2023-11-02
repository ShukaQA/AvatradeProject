package positivetestcases;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import util.BaseTest;

public class RegisterTest extends BaseTest {

    @Test
    public void test1() throws InterruptedException {
        homePage.clickRegisterButton();
        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput("Password!123");
        registrationPopUpPage.clickSubmitButton();
        userRegistrationPage.setFirstNameInput("Test Name");
        userRegistrationPage.setLastNameInput("Test Surname");
        userRegistrationPage.setDateOfBirthInput("11121996");
        userRegistrationPage.setCountryInput("Afghanistan");
        Thread.sleep(10000);
        userRegistrationPage.setCityInput("Test City");
        Thread.sleep(10000);


    }
}
