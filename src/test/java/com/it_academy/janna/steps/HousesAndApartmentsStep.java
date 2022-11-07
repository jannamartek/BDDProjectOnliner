package com.it_academy.janna.steps;

import com.it_academy.janna.pages.OnlinerHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HousesAndApartmentsStep {
    private static final String PRICE_PATTERN = "(До|От)\\s+\\d+[.,]?[0-9]+\\s+";
    private static final String HOUSES_AND_APARTMENTS_XPATH =
            "//*[contains(@class, 'b-main-navigation__dropdown-column b-main-navigation__dropdown-column_50')]" +
                    "//span[contains(@class, 'b-main-navigation__dropdown-advert-sign')]";
    private final OnlinerHomePage homePage = new OnlinerHomePage();

    @When("the user hovers mouse on housesAndApartments {string} section")
    public void theUserHoversOnTab(String tab) {
        homePage.hoverOnItemSection(tab);
    }

    @Then("housesAndApartments submenu {string} appears")
    public void submenuIsDisplayed(String title) {
        assertThat(homePage.isSubmenuDisplayed(HOUSES_AND_APARTMENTS_XPATH))
                .as("Submenu is not displayed " + title)
                .isTrue();
    }

    @Then("housesAndApartments submenu {string} contains cities")
    public void submenuContainsCities(String title, List<String> cities) {
        assertThat(homePage.getTexts(HOUSES_AND_APARTMENTS_XPATH))
                .as("Submenu " + title + " doesn't contain cities " + cities)
                .containsAll(cities);
    }

    @Then("housesAndApartments submenu {string} contains apartments")
    public void submenuContainsApartments(String title, List<String> apartments) {
        assertThat(homePage.getTexts(HOUSES_AND_APARTMENTS_XPATH))
                .as("Submenu " + title + " doesn't contain apartments " + apartments)
                .containsAll(apartments);
    }

    @Then("housesAndApartments submenu {string} contains От, до {int}")
    public void submenuContainsPrices(String title, int price) {
        Pattern pattern = Pattern.compile(PRICE_PATTERN);
        assertThat(homePage.getTexts(HOUSES_AND_APARTMENTS_XPATH))
                .as("Submenu " + title + " doesn't contain prices " + price)
                .anyMatch(pattern.asPredicate());
    }
}