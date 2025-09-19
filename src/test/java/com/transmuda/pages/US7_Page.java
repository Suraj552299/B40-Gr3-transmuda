package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US7_Page extends BasePage {

    public US7_Page(){
        PageFactory.initElements(Driver.getDriver(),this);


    }



    @FindBy(xpath = "//input[@data-select]")
    public WebElement firstCheckBox;

    @FindBy(xpath ="//table//tbody//tr[3]//td[1]//input[@type='checkbox']")
    public WebElement anyCheckBox;

}
