package com.transmuda.step_definitions;

import com.transmuda.pages.AccountsPage;
import com.transmuda.pages.LoginPage;
import com.transmuda.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AccountsFilters_StepDefs {

    LoginPage loginPage = new LoginPage();
    AccountsPage accountsPage = new AccountsPage();

    private List<String> cachedFilterNames;

    private void waitUntilDashboard() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.or(
                        ExpectedConditions.titleContains("Dashboard"),
                        ExpectedConditions.presenceOfElementLocated(By.id("user-menu"))
                ));
    }

    @Given("user is on transmuda login page")
    public void user_is_on_transmuda_login_page() {
        Driver.getDriver().get("https://qa.transmuda.com");
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        loginPage.login(username, password);   // LoginPage değişmeden kalıyor
        waitUntilDashboard();
    }

    @When("user navigates to Customers and Accounts")
    public void user_navigates_to_customers_and_accounts() {
        accountsPage.goToAccounts();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
    }

    @Then("user should see {int} filters in header")
    public void user_should_see_filters_in_header(Integer expected) {
        if (cachedFilterNames == null) {
            cachedFilterNames = accountsPage.getFilterNamesSmart();
            if (cachedFilterNames.size() < expected) {
                try { Thread.sleep(250); } catch (InterruptedException ignored) {}
                cachedFilterNames = accountsPage.getFilterNamesSmart();
            }
        }
        System.out.println("Filter chips (cached) = " + cachedFilterNames);
        Assert.assertEquals(
                "Filter sayısı uymuyor! Beklenen: " + expected + " , Gelen: " + cachedFilterNames.size()
                        + " -> " + cachedFilterNames,
                expected.intValue(),
                cachedFilterNames.size()
        );
    }

    @Then("filter names must be")
    public void filter_names_must_be(DataTable table) {
        if (cachedFilterNames == null) {
            cachedFilterNames = accountsPage.getFilterNamesSmart();
        }
        List<String> expected = table.asList();
        List<String> exp = expected.stream().map(s -> s.trim().toLowerCase()).collect(Collectors.toList());
        List<String> act = cachedFilterNames.stream().map(s -> s.trim().toLowerCase()).collect(Collectors.toList());

        boolean same = act.containsAll(exp) && exp.containsAll(act);
        Assert.assertTrue(
                "Filter listesi tam eşleşmiyor!\nExpected: " + expected + "\nActual: " + cachedFilterNames,
                same
        );
    }
}
