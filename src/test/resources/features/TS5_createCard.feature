Feature: Board

  Scenario: TC5 - Create Card, TC6 - Private Card
    Given user is on home page
    When user open certain company
    Then user is on company page
    And user open certain team
    Then user is on team page
    When user click board button
    Then user is on board page
    When user click add new card
    And user input card name
    And user click confirm card name
    Then user see card created
    When user click add new card
    And user input card name
    And user check private card switch
    And user click confirm card name
    Then user see card created


