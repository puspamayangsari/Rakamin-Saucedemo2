Feature: User can login with valid credential

  @Loginsaucedemo         @Positive
  Scenario: login with valid credential
    Given user access the swag labs web
    Then user input a registered username
    And user input registered password
    Then user click login button

  @Loginsaucedemo          @negative
  Scenario: login with invalid credential
    Given user access the swag labs web
    Then user input a unregistered username
    And user input registered password
    Then user click login button
    Then user get error message

