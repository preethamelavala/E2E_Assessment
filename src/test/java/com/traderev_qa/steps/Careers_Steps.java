package com.traderev_qa.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

import com.traderev_qa.pages.CareersPage;
import com.traderev_qa.resources.base;

public class Careers_Steps extends base {

    @Given("^user launch the traderev \"(.*)\" application$")
    public void launch_traderev (String url) throws Throwable {
        driver = initializeDriver(url);
    }

    @When("^user navigates to Careers page$")
    public void user_navigates_to_contact_us () throws Throwable {
    	CareersPage hp = new CareersPage (driver);
        hp.navigate_careers();
    }

    @When("^user clicks Canadian Opportunities$")
    public void user_validate_address () throws Throwable {
    	CareersPage hp = new CareersPage (driver);
        hp.click_CanadianOOpportunities();
    }
       
    @And("^user takes a screenshot$")
    public void user_takes_screenshot () throws Throwable {
    	String a = null;
    	getScreenshot(a);
    }
    
    @And("^close browser$")
    public void close_browsers() throws Throwable {
    	tearDown();
    }

    @Then("^verify Careers page displayed with \"(.*)\" properly$")
    public void careers_page_displayed_properly (String titles) throws Throwable {
    	CareersPage hp = new CareersPage (driver);
        Assert.assertTrue(hp.verify_careersScreen(titles));
    }
    
    @Then("^verify Canadian Opportunity page displayed with \"(.*)\" properly$")
    public void verify_canadian_Opportunity_page_displayed_properly (String titles) throws Throwable {
    	CareersPage hp = new CareersPage (driver);
        Assert.assertTrue(hp.verify_CandianOpportunityScreen(titles));
    }
    
    @And("^user filter the Search results by \"(.*)\" \"(.*)\"$")
    public void filer_search_results (String filter, String searchItem) throws Throwable {
    	CareersPage hp = new CareersPage (driver);
        hp.filter_citySearch(filter, searchItem);
    }
    
    @Then("^verify all the job results displayed should belong to \"(.*)\" \"(.*)\"$")
    public void verify_search_results (String filter, String searchItem) throws Throwable {
    	CareersPage hp = new CareersPage (driver);
        hp.getCityfilterSearchResults(filter, searchItem);
    }
    
}
