package com.transmuda.step_definitions;

import com.transmuda.pages.BasePage;
import com.transmuda.pages.FleetPage;
import com.transmuda.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FleetStepDefinitions {

   FleetPage fleetPage=new FleetPage();
    @When("user clicks on {string} tab then {string} module")
    public void user_clicks_on_tab_then_module(String tab, String module) {
        fleetPage.navigateToModule(tab,module);

    }
    @When("user can see all the checkboxes as unchecked")
    public void user_can_see_all_the_checkboxes_as_unchecked() {
        BrowserUtils.sleep(3);
        System.out.println("fleetPage.firstCheckBox.isSelected() = " + fleetPage.firstCheckBox.isSelected());

    }

    @Then("user can check the first checkbox to select all the cars")
    public void userCanCheckTheFirstCheckboxToSelectAllTheCars() {
        BrowserUtils.sleep(3);
        fleetPage.firstCheckBox.click();
        System.out.println("fleetPage.firstCheckBox.isSelected() = " + fleetPage.firstCheckBox.isSelected());
    }

    @Then("user can select any car")
    public void userCanSelectAnyCar() {
        fleetPage.anyCheckBox.click();
        System.out.println("fleetPage.anyCheckBox = " + fleetPage.anyCheckBox);
    }
}
