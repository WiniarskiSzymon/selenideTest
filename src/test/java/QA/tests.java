package QA;

import DTO.JobOfferDTO;
import Pages.HomePage;
import Pages.MyJobSearchPages;
import Pages.SavedJobsPage;
import Pages.SearchResultPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

import static com.codeborne.selenide.Selenide.open;

public class tests {

    HomePage homePage;

    @BeforeTest
    public void openWebPage() {
        Configuration.startMaximized =true;
        homePage = open("https://www.monsterworksdemo.com/home/", HomePage.class);
    }

    @Test
    public void testSavingLovedJobsOffer() {
        SearchResultPage searchResultPage = homePage
                .goToRegisterPage()
                .fillCredentials("cqwertye@mial.com", "123QWERTy/")
                .selectJobCenter("To edit the items in here change messages 389442-389565")
                .acceptTermsAndAgreements()
                .createAccount()
                .selectJobSearchFromFooter("Philips Jobs");

        List<JobOfferDTO> savedJobs = new LinkedList<JobOfferDTO>();
        int resultCount = searchResultPage.getSearchResultsCount();

        savedJobs.add(searchResultPage.selectSearchResultByNumber(1)
                .saveJobOffer()
                .getJobOfferDetails(1));
        savedJobs.add(searchResultPage.selectSearchResultByNumber(resultCount - 1)
                .saveJobOffer()
                .getJobOfferDetails(resultCount - 1));

        List<JobOfferDTO> jobsInSavedTab = ((SavedJobsPage)searchResultPage.navigateToMyJobSearchPages(MyJobSearchPages.SAVEDJOBS)).getSavedJobs();
        Assert.assertEquals(savedJobs.size(),jobsInSavedTab.size());
        Assert.assertTrue(savedJobs.containsAll(jobsInSavedTab));

    }
}
