Feature: Home

  Scenario: TC1 - Fail Create Company with null name
    Given user is on home page
    When user click create company button
    And user click create button
    Then user see error message
