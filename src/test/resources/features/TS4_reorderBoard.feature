Feature: Team

  Scenario: TC4 - Reorder Board
    Given user is on home page
    When user open certain company
    Then user is on company page
    And user open certain team
    Then user is on team page
    When user click board button
    Then user is on board page
    When user click add button
    And user input board name
    And user click submit
    Then user see board created
    When user get order existing board
    And user change board order
    Then user see board order changed





