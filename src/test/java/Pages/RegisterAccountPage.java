package Pages;

import bsh.This;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class RegisterAccountPage {

    private String emailFieldLocator = "ocs-input[meta='meta.emailNew'] input:nth-child(3)";
    private String passwordFieldLocator = "ocs-input[meta='meta.password'] input:nth-child(1)";
    private String confirmPasswordFieldLocator = "ocs-input[meta='meta.passwordConfirm'] input:nth-child(1)";
    private String jobsCenterSelectLocator = "ng-form[meta='meta.oneStopCenter'] select";
    private String hearAboutSelectLocator = "ng-form[meta='meta.hearAboutContent'] select";
    private String termsAndConditionCheckboxLocator = "ng-form[meta='meta.userTermsMessage'] span[class=\"checkbox-custom checkbox-toggle\"]";
    private String createAccountButtonLocator = "button[ocs-busy=\"busyLinks.createUserAction\"]";

    public RegisterAccountPage fillCredentials(String login, String password){
        $(emailFieldLocator).waitUntil(visible,6000);
        $(emailFieldLocator).setValue(login);
        $(passwordFieldLocator).setValue(password);
        $(confirmPasswordFieldLocator).setValue(password);
        return this;
    }

    public RegisterAccountPage selectJobCenter(String center){
        $(jobsCenterSelectLocator).selectOption(center);
        return this;
    }

    public RegisterAccountPage acceptTermsAndAgreements() {
        $(termsAndConditionCheckboxLocator).click();
        return this;

    }

    public RegisterAccountPage selectHearAboutSource(String source){
        $(hearAboutSelectLocator).selectOption(source);
        return this;
    }


        public DashBoardPage createAccount(){
        $(createAccountButtonLocator).shouldBe(visible);
        $(createAccountButtonLocator).shouldBe(enabled);
        $(createAccountButtonLocator).click();
        return page(DashBoardPage.class);
    }
}
