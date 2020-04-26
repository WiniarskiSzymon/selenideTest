package Pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaseNavigationPageObject {
    private String footerlocator = "div.\"row footer-links\"";

    public BaseNavigationPageObject navigateToMyJobSearchPages(MyJobSearchPages pageToNavigate){
        $("a[id=\"dropdown-My-job-search\"]").hover();
        $$("li[class=\"dropdown-toggle open\"] li").findBy(text(pageToNavigate.label())).click();

        switch (pageToNavigate) {
            case SAVEDJOBS:
                return new SavedJobsPage();
            default:
                return new SavedJobsPage();
        }

    }
}
