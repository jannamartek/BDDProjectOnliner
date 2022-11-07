Feature: As a user
  I want to have ability to see submenu sections with appropriate categories

  @smoke
  Scenario Outline: Main-menu <tab> should contain appropriate sections
    Given the user opens onliner.by website
    When the user hovers mouse on housesAndApartments <tab> section
    Then housesAndApartments submenu <tab> appears
    And housesAndApartments submenu <tab> contains cities
      | Минск   |
      | Брест   |
      | Витебск |
      | Гомель  |
      | Гродно  |
      | Могилев |
    And housesAndApartments submenu <tab> contains apartments
      | 1-комнатные  |
      | 2-комнатные  |
      | 3-комнатные  |
      | 4+-комнатные |
    And housesAndApartments submenu <tab> contains От, до 4000
    Examples:
      | tab               |
      | "Дома и квартиры" |