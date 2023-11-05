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
    public void registrationTest(ScenarioPojo data) throws InterruptedException {
        if (data.getScenarioName().equals("France Registration")) {
            fillRegistrationFormForFrance(data.getData());
        } else if (data.getScenarioName().equals("Afghanistan Registration")) {
            fillRegistrationFormForAfghanistan(data.getData());
        }
        Thread.sleep(10000);
    }

    public void fillRegistrationFormForFrance(DataPojo data) throws InterruptedException {
        homePage.clickRegisterButton();
        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput(data.getPassword());
        registrationPopUpPage.clickSubmitButton();
        yourPersonalDetailsPage.setFirstNameInput(data.getFirstName());
        yourPersonalDetailsPage.setLastNameInput(data.getLastName());
        yourPersonalDetailsPage.setDateOfBirthInput(data.getDateOfBirth());
        yourPersonalDetailsPage.setCountryInput(data.getCountry());
        yourPersonalDetailsPage.setCityInput(data.getCity());
        yourPersonalDetailsPage.setStreetInput(data.getStreet());
        yourPersonalDetailsPage.setStreetNumberInput(data.getStreetNumber());
        yourPersonalDetailsPage.setFlatInput(data.getFlat());
        yourPersonalDetailsPage.setZipCodeInput(data.getZipCode());
        yourPersonalDetailsPage.setPhoneInput(data.getPhoneNumber());
        yourPersonalDetailsPage.clickSubmitButton();

        yourFinancialDetailsPage.clickPrimaryOccupationDropdownClickFirst();
        yourFinancialDetailsPage.currentlyEmployedDropdownClickFirst();
        //getDriver().get(returnConfigValue("url.base"));
    }

    public void fillRegistrationFormForAfghanistan(DataPojo data) {
        homePage.clickRegisterButton();
        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput(data.getPassword());
        registrationPopUpPage.clickSubmitButton();
        yourPersonalDetailsPage.setFirstNameInput(data.getFirstName());
        yourPersonalDetailsPage.setLastNameInput(data.getLastName());
        yourPersonalDetailsPage.setDateOfBirthInput(data.getDateOfBirth());
        yourPersonalDetailsPage.setCountryInput(data.getCountry());
        yourPersonalDetailsPage.setCityInput(data.getCity());
        yourPersonalDetailsPage.setStreetInput(data.getStreet());
        yourPersonalDetailsPage.setStreetNumberInput(data.getStreetNumber());
        yourPersonalDetailsPage.setFlatInput(data.getFlat());
        yourPersonalDetailsPage.setZipCodeInput(data.getZipCode());
        yourPersonalDetailsPage.setPhoneInput(data.getPhoneNumber());
        yourPersonalDetailsPage.clickSubmitButton();

        getDriver().get(returnConfigValue("url.base"));
    }
}
