Feature: Company

  Scenario: Create Team
    Given user is on home page
    When user open certain company
    Then user is on company page
    When user click add button
    And user click add team
    And user input team name
    And user input description
    And user click create button
    Then user see team created

