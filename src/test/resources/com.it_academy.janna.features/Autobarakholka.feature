Feature: As a user
  I want to have ability to see submenu sections with appropriate categories

  @smoke
  Scenario Outline: Top-menu <tab> should contain appropriate sections
    Given the user opens onliner.by website
    When the user hovers mouse on autobarakholka <tab> section
    Then submenu autobarakholka <tab> appears
    And submenu autobarakholka <tab> contains sections: car models
      | Audi          |
      | BMW           |
      | Citroen       |
      | Ford          |
      | Mazda         |
      | Mercedes-Benz |
      | Nissan        |
      | Opel          |
      | Peugeot       |
      | Renault       |
      | Toyota        |
      | Volkswagen    |
    And submenu autobarakholka <tab> contains sections: Авто до 4000 р.
    And submenu autobarakholka <tab> contains sections: cities
      | Минск   |
      | Брест   |
      | Витебск |
      | Гомель  |
      | Гродно  |
      | Могилев |
    Examples:
      | tab             |
      | "Автобарахолка" |