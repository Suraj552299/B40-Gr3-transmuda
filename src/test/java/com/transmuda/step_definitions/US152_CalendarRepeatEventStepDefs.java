package com.transmuda.step_definitions;

import com.transmuda.pages.CalendarRepeatEventPage;
import com.transmuda.utilities.BrowserUtils;
import com.transmuda.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US152_CalendarRepeatEventStepDefs {


    CalendarRepeatEventPage calendarRepeatEventPage =  new CalendarRepeatEventPage();


    @And("the user navigates to {string} and {string}")
    public void theUserNavigatesToAnd(String tab, String module) {
        calendarRepeatEventPage.waitUntilLoaderScreenDisappear();
        calendarRepeatEventPage.navigateToModule(tab, module);
        BrowserUtils.sleep(15);
    }

    @And("the user clicks create calendar events link")
    public void theUserClicksCreateCalendarEventsLink() {
        calendarRepeatEventPage.createCalenderEventLink.click();
        calendarRepeatEventPage.repeat.click();
        BrowserUtils.sleep(30);
    }

    @Then("the user checks Repeat checkbox")
    public void theUserChecksRepeatCheckbox() {
        calendarRepeatEventPage.repeat.click();
        BrowserUtils.sleep(20);

    }

        @And("the user enters {int} into the input  box")
        public void theUserEntersIntoTheInputBox(int arg0) {
         ;
            calendarRepeatEventPage.waitUntilLoaderScreenDisappear();
          calendarRepeatEventPage.negativenumber.sendKeys("-1"+Keys.ENTER);
                  BrowserUtils.sleep(10);


    }

    @Then("user should see {string}")
    public void userShouldSeeTheValueHaveNotToBeLessThan(int arg0) {
       String invalidMessage= calendarRepeatEventPage.invalidMessage.getText();
        System.out.println("invalidMessage = " + invalidMessage);
    }

    @And("user enters {int} into the input box")
    public void userEntersIntoTheInputBox(int arg0) {
        calendarRepeatEventPage.positivenumber.sendKeys("111"+Keys.ENTER);
        BrowserUtils.sleep(18);
        calendarRepeatEventPage.validMessage.isDisplayed();


    }








//
//    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
//
//    @Given("If User enters less than {int} —> users should see “The value have not to be less than 1”)
//    public void if_user_enters_less_than_users_should_see_the_value_have_not_to_be_less_than(Integer int1,Integer int2) {
//        //Driver.getDriver().get("https://qa.transmuda.com");
//    }
//
//
//    @Then("If User enter more than {int} —> users should see “The value have not to be more than {int}.”")
//    public void if_user_enter_more_than_users_should_see_the_value_have_not_to_be_more_than(Integer int1, Integer int2) throws InterruptedException {
//
//       // Actions actions = new Actions(Driver.getDriver());
//        calendarRepeatEventPage.usernameinput.sendKeys("user155"+ Keys.ENTER);
//        calendarRepeatEventPage.passwordinput.sendKeys("UserUser123"+Keys.ENTER);
//        //transmuda_page.Loginbutton.click();
//
//
//        BrowserUtils.hover(calendarRepeatEventPage.activities);
//        wait.until(ExpectedConditions.elementToBeClickable(calendarRepeatEventPage.activities));
//       //actions.moveToElement(transmudapage.activities).pause(2000).perform();
//    }


}

