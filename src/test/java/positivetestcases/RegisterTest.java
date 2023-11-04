package positivetestcases;

import com.github.javafaker.Faker;
import models.DataPojo;
import models.ScenarioPojo;
import models.ScenariosPojo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.BaseTest;
import util.Utils;

import java.util.List;

import static util.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {
    @DataProvider(name = "registrationScenarios")
    public Object[][] registrationScenarios() {
        ScenariosPojo data
                = Utils.readJsonFile(returnConfigValue("test.data.path"), ScenariosPojo.class);
        assert data != null;
        List<ScenarioPojo> scenarios = data.getScenarios();
        Object[][] testData = new Object[scenarios.size()][1];
        for (int i = 0; i < scenarios.size(); i++) {
            testData[i][0] = scenarios.get(i);
        }
        return testData;
    }

    @Test(dataProvider = "registrationScenarios")
    public void registrationTest(ScenarioPojo data) {
        if (data.getScenarioName().equals("France Registration")) {
            fillRegistrationFormForFrance(data.getData());
        } else if (data.getScenarioName().equals("Afghanistan Registration")) {
            fillRegistrationFormForAfghanistan(data.getData());
        }
    }

    public void fillRegistrationFormForFrance(DataPojo data) {
        homePage.clickRegisterButton();
        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput(data.getPassword());
        registrationPopUpPage.clickSubmitButton();
        userRegistrationPage.setFirstNameInput(data.getFirstName());
        userRegistrationPage.setLastNameInput(data.getLastName());
        userRegistrationPage.setDateOfBirthInput(data.getDateOfBirth());
        userRegistrationPage.setCountryInput(data.getCountry());
        userRegistrationPage.setCityInput(data.getCity());
        userRegistrationPage.setStreetInput(data.getStreet());
        userRegistrationPage.setStreetNumberInput(data.getStreetNumber());
        userRegistrationPage.setFlatInput(data.getFlat());
        userRegistrationPage.setZipCodeInput(data.getZipCode());
        userRegistrationPage.setPhoneInput(data.getPhoneNumber());
        userRegistrationPage.clickSubmitButton();

        driver.get(returnConfigValue("url.base"));
    }

    public void fillRegistrationFormForAfghanistan(DataPojo data) {
        homePage.clickRegisterButton();
        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput(data.getPassword());
        registrationPopUpPage.clickSubmitButton();
        userRegistrationPage.setFirstNameInput(data.getFirstName());
        userRegistrationPage.setLastNameInput(data.getLastName());
        userRegistrationPage.setDateOfBirthInput(data.getDateOfBirth());
        userRegistrationPage.setCountryInput(data.getCountry());
        userRegistrationPage.setCityInput(data.getCity());
        userRegistrationPage.setStreetInput(data.getStreet());
        userRegistrationPage.setStreetNumberInput(data.getStreetNumber());
        userRegistrationPage.setFlatInput(data.getFlat());
        userRegistrationPage.setZipCodeInput(data.getZipCode());
        userRegistrationPage.setPhoneInput(data.getPhoneNumber());
        userRegistrationPage.clickSubmitButton();

        driver.get(returnConfigValue("url.base"));
    }
}
