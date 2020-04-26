package Pages;


import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.*;

public class HomePage  {
    public RegisterAccountPage goToRegisterPage(){
        $("a[href='/account/account-lite']").click();
        return page(RegisterAccountPage.class);
    }

}
