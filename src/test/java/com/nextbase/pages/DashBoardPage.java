package com.nextbase.pages;

import com.nextbase.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
