package Pages;

import DTO.JobOfferDTO;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;
import java.util.stream.Collectors;

public class SavedJobsPage extends BaseNavigationPageObject {

    private String savedJobLocaot= "div[class=\"list display-table\"] > div";

    public List<JobOfferDTO> getSavedJobs(){
        $$(savedJobLocaot).first().waitUntil(visible,6000);
      return  $$(savedJobLocaot).stream().map(element -> getJobProperties(element)).collect(Collectors.toList());
    }


    private JobOfferDTO getJobProperties(SelenideElement jobOffer){
        String jobName = jobOffer.find("div[class=\"header-actions\"]").waitUntil(visible,10000).$(" a").getText();
        String companyName = jobOffer.find("span[title=\"Company\"]").getText();
        String location = jobOffer.find("span[title=\"Location\"]").getText();

        return new JobOfferDTO(jobName,companyName,location);
    }
}
