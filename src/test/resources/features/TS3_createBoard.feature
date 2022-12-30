Feature: Team

  Scenario: TC3 - Create Board
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



