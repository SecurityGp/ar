package com.assured.pages;

import com.assured.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPageCRM {

    public P01_LoginPage loginPage;

    public P01_LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new P01_LoginPage();
        }
        return loginPage;
    }

}
