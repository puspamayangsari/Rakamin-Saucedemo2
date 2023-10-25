Feature: User can checkout the shopping cart

  @checkoutproduct
  Scenario: checkout the shopping cart
    Given user click Add to Cart button on one of the product
    Then user click shopping cart icon
    And user click Checkout button
    And user input First Name
    And user input Last Name
    And user input Postalcode
    And user click Continue button
    And user click Finish button