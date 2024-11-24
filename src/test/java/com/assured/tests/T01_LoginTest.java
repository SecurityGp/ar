package com.assured.tests;

import com.assured.annotations.FrameworkAnnotation;
import com.assured.common.BaseTest;
import com.assured.dataprovider.DataProviderManager;
import com.assured.enums.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import com.assured.pages.P01_LoginPage;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Sign In Test")
public class T01_LoginTest extends BaseTest {
    P01_LoginPage loginPage;
    public T01_LoginTest() {
        loginPage = new P01_LoginPage();
    }
    @FrameworkAnnotation(author = {AuthorType.Gnanapandithan}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "TC01_signInWithDataProvider", dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
    public void loginWithValidCredentials(Hashtable<String, String> data) {
        loginPage.loginWithValidCredentials(data);

    }


}
