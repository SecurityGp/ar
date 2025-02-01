package com.assured.pages;

import com.assured.helpers.ExcelHelpers;
import org.openqa.selenium.By;
import com.assured.constants.FrameworkConstants;
import com.assured.utils.DecodeUtils;
import com.assured.model.SignInModel;


import java.util.Hashtable;

import static com.assured.keywords.WebUI.*;

public class P01_LoginPage extends CommonPageCRM {
    private String pageUrl = "sign-in";
    private String pageTitle = "Assured";

    public P01_LoginPage() {super();}


    public By inputEmail = By.xpath("//input[@id='normal_login_email']");
    public By inputPassword = By.xpath("//input[@id='normal_login_password']");
    public By buttonSignIn = By.xpath("//span[normalize-space()='Log in']");
    public By alertErrorMessage = By.xpath("//div[@role='alert']");
    public By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    public By linkSignUp = By.xpath("//a[normalize-space()='Sign up']");
    public By labelEmailError = By.xpath("//span[@id='email-error']");
    public By labelPasswordError = By.xpath("//span[@id='password-error']");

        public P01_LoginPage loginWithValidCredentials(Hashtable<String, String> data) {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        openWebsite(FrameworkConstants.URL_STAGING);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, excelHelpers.getCellData(1, SignInModel.getEmail()));
        setText(inputPassword, excelHelpers.getCellData(1, SignInModel.getPassword()));
        clickElement(buttonSignIn);
            return new P01_LoginPage();
                   }


    }



