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
    public void fillRegistrationFormForFrance(DataPojo data) {
        homePage.clickRegisterButton();

        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput(data.getRegistration().getPassword());
        registrationPopUpPage.clickSubmitButton();
        registrationPopUpPage.waitForRegistrationLoader();

        yourPersonalDetailsPage.setFirstNameInput(data.getRegistration().getFirstName());
        yourPersonalDetailsPage.setLastNameInput(data.getPersonalDetails().getLastName());
        yourPersonalDetailsPage.setDateOfBirthInput(data.getPersonalDetails().getDateOfBirth());
        yourPersonalDetailsPage.setCountryInput(data.getPersonalDetails().getCountry());
        yourPersonalDetailsPage.setCityInput(data.getPersonalDetails().getCity());
        yourPersonalDetailsPage.setStreetInput(data.getPersonalDetails().getStreet());
        yourPersonalDetailsPage.setStreetNumberInput(data.getPersonalDetails().getStreetNumber());
        yourPersonalDetailsPage.setFlatInput(data.getPersonalDetails().getFlat());
        yourPersonalDetailsPage.setZipCodeInput(data.getPersonalDetails().getZipCode());
        yourPersonalDetailsPage.setPhoneInput(data.getPersonalDetails().getPhoneNumber());
        yourPersonalDetailsPage.clickSubmitButton();

        yourFinancialDetailsPage.setPrimaryOccupationDropdown(data.getFinancialDetails().getPrimaryOccupation());
        yourFinancialDetailsPage.setCurrentlyEmployedDropdown(data.getFinancialDetails().getCurrentlyEmployed());
        yourFinancialDetailsPage.setSourceOfTheFundsDropdown(data.getFinancialDetails().getSourceOfTheFunds());
        yourFinancialDetailsPage.setEstimatedAnnualIncomeDropdown(data.getFinancialDetails().getEstimatedAnnualIncome());
        yourFinancialDetailsPage.setEstimatedValueDropdown(data.getFinancialDetails().getEstimatedValue());
        yourFinancialDetailsPage.setInvestAmountDropdown(data.getFinancialDetails().getInvestAmount());
        yourFinancialDetailsPage.clickSubmitButton();

        tradingExperiencePage.clickYesButton();
        tradingExperiencePage.setTradingExperienceForexDropdown(data.getTradingExperience().getTradingExperienceForex());
        tradingExperiencePage.setAverageTradeSizeDropdown(data.getTradingExperience().getAverageTradeSize());
        tradingExperiencePage.setTradingWithLeverageDropdown(data.getTradingExperience().getTradingWithLeverage());
        tradingExperiencePage.setTradingWithLeverageMaximumDropdown(data.getTradingExperience().getTradingWithLeverageMaximum());
        tradingExperiencePage.setOpenPositionDropdown(data.getTradingExperience().getOpenPosition());
        tradingExperiencePage.setTradeWithUsDropdown(data.getTradingExperience().getTradeWithUs());
        tradingExperiencePage.clickCheckBoxButton();
        tradingExperiencePage.clickSubmitButton();

        termsAndConditionsPage.setTermsAndConditionButtonTrue();

    }

    public void fillRegistrationFormForAfghanistan(DataPojo data) {
        homePage.clickRegisterButton();

        registrationPopUpPage.setMailInput(new Faker().internet().emailAddress());
        registrationPopUpPage.setPasswordInput(data.getRegistration().getPassword());
        registrationPopUpPage.clickSubmitButton();
        registrationPopUpPage.waitForRegistrationLoader();

        yourPersonalDetailsPage.setFirstNameInput(data.getRegistration().getFirstName());
        yourPersonalDetailsPage.setLastNameInput(data.getPersonalDetails().getLastName());
        yourPersonalDetailsPage.setDateOfBirthInput(data.getPersonalDetails().getDateOfBirth());
        yourPersonalDetailsPage.setCountryInput(data.getPersonalDetails().getCountry());
        yourPersonalDetailsPage.setCityInput(data.getPersonalDetails().getCity());
        yourPersonalDetailsPage.setStreetInput(data.getPersonalDetails().getStreet());
        yourPersonalDetailsPage.setStreetNumberInput(data.getPersonalDetails().getStreetNumber());
        yourPersonalDetailsPage.setFlatInput(data.getPersonalDetails().getFlat());
        yourPersonalDetailsPage.setZipCodeInput(data.getPersonalDetails().getZipCode());
        yourPersonalDetailsPage.setPhoneInput(data.getPersonalDetails().getPhoneNumber());
        yourPersonalDetailsPage.clickSubmitButton();

        yourFinancialDetailsPage.setPrimaryOccupationDropdown(data.getFinancialDetails().getPrimaryOccupation());
        yourFinancialDetailsPage.setCurrentlyEmployedDropdown(data.getFinancialDetails().getCurrentlyEmployed());
        yourFinancialDetailsPage.setSourceOfTheFundsDropdown(data.getFinancialDetails().getSourceOfTheFunds());
        yourFinancialDetailsPage.setEstimatedAnnualIncomeDropdown(data.getFinancialDetails().getEstimatedAnnualIncome());
        yourFinancialDetailsPage.setEstimatedValueDropdown(data.getFinancialDetails().getEstimatedValue());
        yourFinancialDetailsPage.setInvestAmountDropdown(data.getFinancialDetails().getInvestAmount());
        yourFinancialDetailsPage.clickSubmitButton();

        //TODO afghanistan registration steps...

    }
}
