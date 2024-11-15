package com.Manaf.stepdefinitions;

import com.Manaf.framework.core.jbehave.BeforeAfterScenario;
import com.Manaf.steps.HomePageSteps;

import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.Manaf.framework.driver.DriverManager.getDriver;

import java.util.List;


public class HomePageScenario extends BeforeAfterScenario {

    HomePageSteps homePageSteps = new HomePageSteps(getDriver());

    @Given("user opens home page")
    public void gotoHomePage(){
        homePageSteps.openHomePage();
    }

    @When("user enters into search box with next '$value'")
    public void search(final String value){
        System.out.println("*****given parameter as*****:" + value);
        homePageSteps.searchKeyword(value);
    }

    @When("user clicks on search button")
    public void search() throws InterruptedException {
        homePageSteps.clickSearch();
    }

    @Then("all the result titles should contain the word $value")
    public void verifyLandingPage(final String value){
        List<String> actual = homePageSteps.searchResults();
        SoftAssertions softly = new SoftAssertions();
        //softly.assertThat(actual.get(0)).describedAs("list contains wrong values").contains(value);
        softly.assertThat(actual).describedAs("list contains wrong values").contains(value);
        softly.assertAll();
    }
}
