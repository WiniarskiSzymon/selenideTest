package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ScrollIntoView;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;

public class DashBoardPage {

    private String footerlocator = "div[class=\"row footer-links\"] li a";

    public SearchResultPage selectJobSearchFromFooter (String footerJob){
        sleep(3000);
        $$(footerlocator).findBy(text(footerJob)).scrollIntoView(true).shouldBe().click();

    return page(SearchResultPage.class);
    }
}
