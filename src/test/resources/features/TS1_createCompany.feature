Feature: Home

  Scenario: TC1 - Create Company
    Given user is on home page
    When user click create company button
    And user input company name
    And user input description
    And user click create button
    Then user see success create company toast
