Feature: Filter

  Scenario: TC8 - Filter Card, TC9 - Reset Filter
    Given user is on home page
    When user open certain company
    Then user is on company page
    And user open certain team
    Then user is on team page
    When user click board button
    Then user is on board page
    When user click filter button
    And user input card name for filter
    And user click apply
    Then user see filtered card
    When user click filter button
    And user click reset
    And user click apply
    Then user see all cards




