package WebTests;

import Components.Settings.AccountVerification;
import Components.Settings.Settings;
import Setup.SetupTestWeb;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountVerificationTest extends SetupTestWeb {


    public AccountVerification kyc;

    @Test
    public void redirectToKycFromSettings() {
        Settings settings = new Settings();
        settings.clickAccountVerificationButton();

        kyc = new AccountVerification();
        //Check if redirect to KYC page
        Assert.assertTrue(isElementVisible(kyc.firstName));
        System.out.println("Redirect to KYC.");
    }

    @Test
    @Parameters ({"firstNameKyc", "lastNameKyc", "birthDateKyc", "countyKyc", "city", "state", "ZIP",  "street", "building", "apartment", "idNumber", "countryOfIssuance", "documentName", "documentType", "status" })
    public void kyc (String firstNameKyc, String lastNameKyc, String birthDateKyc, String countyKyc, String city, String state, String ZIP, String street, String building, String apartment, String idNumber, String countryOfIssuance, String documentName, String documentType, String status) {

        redirectToKycFromSettings();

        System.out.println("Starting KYC for user from " + getProperty(countyKyc) + " " + "with documents of " + getProperty(countryOfIssuance));

        kyc.kycInputData(getProperty(firstNameKyc), getProperty(lastNameKyc), getProperty(birthDateKyc),
                getProperty(countyKyc), getProperty(city), getProperty(state), getProperty(ZIP), getProperty(street),
                getProperty(building), getProperty(apartment), getProperty(idNumber), getProperty(countryOfIssuance));

        kyc.clickSelectDocumentType();

        //select which document type
        String type = documentType;

        System.out.println("This user has " + documentType);

        if (type.contains("Passport")){
            kyc.clickSelectDocumentPassport();
        } else if (type.contains("DL")){
            kyc.clickSelectDocumentDL();
        }


        Assert.assertTrue(!(kyc.getUploadDocumentArea.getAttribute("style").contains("opacity")), "No document selected.");

        kyc.uploadDocument(documentName);
        //check if document attached
        Assert.assertTrue(isElementVisible(kyc.uploadedDocument), "No document uploaded.");
        System.out.println("Document was uploaded.");

        //Currently frozen, while kYC fixes in progress
        //kyc.clickSubmitButton();
        //check if status appears and status is correct
        Assert.assertTrue(isElementVisible(kyc.verificationStatus), "KYC was not finished.");
        System.out.println("KYC finished.");
        Assert.assertEquals(kyc.verificationStatus.getText(), status);

        if (status.contains("SUCCESS")){
            System.out.println("KYC was successfully completed.");
        } else {
            System.out.println("KYC is in pending, check your account later.");
        }
    }


}


        /*firstNameKyc = Ivan
        lastNameKyc = Kovtunov
        birthDateKyc = 16011988
        countyKyc = Ukraine
        city = Kharkiv
        state = Kharkiv region
        ZIP = 61140
        street = Haharina Ave
        building = 62a
        apartment = 155
        idNumber = 3215705736
        countryOfIssuance = Ukraine


        inputDataField(this.firstName, firstName);
        inputDataField(this.lastName, lastName);
        inputDataField(this.birthDate, birthDate);
        inputDataField(this.country, country);
        inputDataField(this.city, city);
        inputDataField(this.state, state);
        inputDataField(this.zipCode, zipCode);
        inputDataField(this.street, street);
        inputDataField(this.building, building);
        inputDataField(this.apartment, apartment);
        inputDataField(this.idNumber, idNumber);
        inputDataField(this.countryOfIssuance, countryOfIssuance);*/