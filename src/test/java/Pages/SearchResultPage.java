package Pages;

import DTO.JobOfferDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage extends BaseNavigationPageObject{

    private String searchResultLocator = "#SearchResults section";
    private String saveOfferButtonLocator = "#SaveJob";


    public SearchResultPage selectSearchResultByNumber(int number) {
        sleep(1000);
        $("#SearchResults").shouldBe(Condition.visible).hover();
        int visibleElementsCount = $$(searchResultLocator).size();

        while(visibleElementsCount <= number){
            $$(searchResultLocator).get(visibleElementsCount-1).scrollIntoView(true);
            visibleElementsCount = $$(searchResultLocator).size();
        }
        SelenideElement resultToSelect  = $$(searchResultLocator).get(number-1);
        resultToSelect.scrollIntoView(true);
        resultToSelect.click();
        return this;
    }

    public SearchResultPage saveJobOffer(){
        $(saveOfferButtonLocator).click();
        return this;
    }

    public int getSearchResultsCount(){
        return Integer.parseInt($("div[data-results-target=\"#SearchResults\"]").getAttribute("data-total-search-results"));
    }

    public JobOfferDTO getJobOfferDetails(int number){
        String jobTitle = $(searchResultLocator + ":nth-child(" +number + ") div.summary" ).getText().split("\n")[0];
        String companyName = $(searchResultLocator + ":nth-child(" +number + ") div.company" ).getText();
        String jobLocation = $(searchResultLocator + ":nth-child(" +number + ") div.location" ).getText();
        return new JobOfferDTO(jobTitle,companyName,jobLocation);
    }

}
