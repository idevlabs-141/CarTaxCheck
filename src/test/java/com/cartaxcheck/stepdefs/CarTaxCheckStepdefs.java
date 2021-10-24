package com.cartaxcheck.stepdefs;

import com.cartaxcheck.helpers.CarTaxCheckHelper;
import com.cartaxcheck.model.VehicleIdentity;
import com.cartaxcheck.pages.CarTaxCheckPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Slf4j
public class CarTaxCheckStepdefs extends BaseStep{

    @Autowired
    private CarTaxCheckPage taxCheckPage;

    private List<String> regNumbers;
    private Map<String,VehicleIdentity> carRegDirectory;
    private String testResourcesFolder = "src/test/resources";
    private final SoftAssertions matchSoftAssertions = new SoftAssertions();

    @Given("Vehicle Identity of reg numbers from inputFile should match against outputFile")
    public void vehicleIdentityCheck(final DataTable dt) throws IOException {
        final String inputFile = dt.asMaps().get(0).get("inputFile");
        final String outputFile = dt.asMaps().get(0).get("outputFile");

        regNumbers = CarTaxCheckHelper.extractRegNumbersFromFile(testResourcesFolder+"/InputFiles/"+inputFile);
        carRegDirectory = CarTaxCheckHelper.getCarRegDirectory(testResourcesFolder+"/OutputFiles/"+outputFile);

        regNumbers.stream().forEach((reg) -> {
            VehicleIdentity expected = carRegDirectory.get(reg.trim());
            log.info("Expected object::"+expected.toString());
            taxCheckPage.navigateToSite();
            VehicleIdentity actual = taxCheckPage.getCarDetails(reg.trim());
            log.info("Actual object::"+actual.toString());
            matchSoftAssertions.assertThat(actual).isEqualTo(expected);
        });
        taxCheckPage.closeBrowser();
        matchSoftAssertions.assertAll();
    }
}
