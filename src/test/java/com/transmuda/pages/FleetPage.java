package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleetPage extends BasePage {

    public FleetPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }



    @FindBy(xpath = "//input[@data-select]")
    public WebElement firstCheckBox;

    @FindBy(xpath =" ")
    public WebElement anyCheckBox;

}
