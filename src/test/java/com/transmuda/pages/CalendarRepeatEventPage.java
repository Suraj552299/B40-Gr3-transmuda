package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarRepeatEventPage extends BasePage {

    public CalendarRepeatEventPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="temp-validation-name-125-error")
    public WebElement transmudavalidation;

    @FindBy(id="temp-validation-name-329-error")
    public WebElement transmudavalidation2;

    @FindBy(id="prependedInput")
    public WebElement usernameinput;

    @FindBy(id="prependedInput2")
    public WebElement passwordinput;

    @FindBy(xpath = "(//span[normalize-space(text())='Activities'])[2]")
    public WebElement activities;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalenderEventLink;

    @FindBy(id = "recurrence-repeat-view242")
    public WebElement repeat;

    @FindBy(xpath = "//input[@checked='checked']")
    public WebElement repeatEvery;

    @FindBy(xpath = "//input[@class='recurrence-subview-control__number error']")
            public WebElement negativenumber;

    @FindBy(xpath = "//span[text()='The value have not to be less than 1.']")
    public WebElement invalidMessage;

    @FindBy(xpath = "//input[@class='recurrence-subview-control__number error']")
    public WebElement positivenumber;

    @FindBy(id = "temp-validation-name-125-error")
    public WebElement validMessage;


}
